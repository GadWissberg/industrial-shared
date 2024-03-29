package com.gadarts.industrial.shared.assets;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader;
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.gadarts.industrial.shared.assets.Assets.AssetsTypes;
import com.gadarts.industrial.shared.assets.declarations.pickups.weapons.WeaponDeclaration;
import com.gadarts.industrial.shared.assets.declarations.pickups.weapons.WeaponsDeclarations;
import com.gadarts.industrial.shared.assets.definitions.*;
import com.gadarts.industrial.shared.assets.loaders.DeclarationsLoader;
import com.gadarts.industrial.shared.assets.loaders.ShaderLoader;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Optional;

import static com.gadarts.industrial.shared.assets.definitions.ModelDefinition.FOLDER;

public class GameAssetManager extends AssetManager {
	private final String assetsLocation;
	private boolean loadedParticleEffects;
	private final Gson gson = Assets.generateDefinedGsonBuilder().create();

	public GameAssetManager( ) {
		this("");
	}

	public GameAssetManager(final String assetsLocation) {
		this.assetsLocation = assetsLocation;
		setLoader(String.class, new ShaderLoader(getFileHandleResolver()));
		FileHandleResolver resolver = new InternalFileHandleResolver();
		setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		FreetypeFontLoader loader = new FreetypeFontLoader(resolver);
		setLoader(BitmapFont.class, FontDefinition.FORMAT_TTF, loader);
		setLoader(Declaration.class, DeclarationDefinition.FORMAT, new DeclarationsLoader(resolver, (json, t, c) -> {
			WeaponDeclaration result;
			if (json.isJsonPrimitive()) {
				WeaponsDeclarations declaration = (WeaponsDeclarations) getDeclaration(Assets.Declarations.WEAPONS);
				result = declaration.parse(json.getAsString());
			} else {
				result = gson.fromJson(json, t);
			}
			return result;
		}));
	}

	public void loadParticleEffects(PointSpriteParticleBatch pointSpriteParticleBatch,
									BillboardParticleBatch billboardParticleBatch) {
		Arrays.stream(AssetsTypes.PARTICLES.getAssetDefinitions())
				.forEach(def -> {
					ParticleBatch<?> batch;
					if (def != Assets.ParticleEffects.BLOOD_SPLATTER) {
						batch = pointSpriteParticleBatch;
					} else {
						batch = billboardParticleBatch;
					}
					loadFileWithManualParameters(
							def,
							def.getFilePath(),
							new ParticleEffectLoader.ParticleEffectLoadParameter(Array.with(batch)));
				});
		finishLoading();
		loadedParticleEffects = true;
	}

	public void unloadParticleEffects( ) {
		if (!loadedParticleEffects) return;

		Arrays.stream(AssetsTypes.PARTICLES.getAssetDefinitions()).forEach(this::unloadFileWithManualParameters);
		finishLoading();
		loadedParticleEffects = false;
	}

	public void loadGameFiles(final AssetsTypes... assetsTypesToExclude) {
		Arrays.stream(AssetsTypes.values())
				.filter(type -> Arrays.stream(assetsTypesToExclude).noneMatch(toExclude -> toExclude == type))
				.filter(type -> !type.isManualLoad())
				.forEach(type -> Arrays.stream(type.getAssetDefinitions()).forEach(def -> {
					String[] filesList = def.getFilesList();
					if (filesList.length == 0) {
						loadFile(def, def.getFilePath(), type.isBlock());
					} else {
						Arrays.stream(filesList).forEach(file -> loadFile(def, file, type.isBlock()));
					}
				}));
		finishLoading();
	}

	public void applyRepeatWrapOnAllTextures( ) {
		Array<Texture> textures = new Array<>();
		getAll(Texture.class, textures);
		textures.forEach(texture -> texture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat));
		Arrays.stream(Assets.SurfaceTextures.values())
				.filter(texture -> texture.getTextureWrap().equals(TextureWrap.ClampToEdge))
				.forEach(t -> get(t.getFilePath(), Texture.class)
						.setWrap(TextureWrap.ClampToEdge, TextureWrap.ClampToEdge));
	}

	@Override
	public <T> void addAsset(final String fileName, final Class<T> type, final T asset) {
		super.addAsset(fileName, type, asset);
		if (type == com.badlogic.gdx.graphics.g3d.Model.class) {
			com.badlogic.gdx.graphics.g3d.Model model = (com.badlogic.gdx.graphics.g3d.Model) asset;
			model.materials.forEach(material -> material.remove(ColorAttribute.Specular));
		}
	}

	public TextureAtlas getAtlas(final AtlasDefinition atlas) {
		return get(assetsLocation + atlas.getFilePath(), TextureAtlas.class);
	}

	public ParticleEffect getParticleEffect(final ParticleDefinition particle) {
		return get(assetsLocation + particle.getFilePath(), ParticleEffect.class);
	}

	public com.badlogic.gdx.graphics.g3d.Model getModel(final ModelDefinition model) {
		return get(assetsLocation + model.getFilePath(), com.badlogic.gdx.graphics.g3d.Model.class);
	}

	public Texture getModelExplicitTexture(final ModelDefinition model) {
		return get(assetsLocation + FOLDER + "/" + model.getTextureFileName() + ".png", Texture.class);
	}

	public Texture getTexture(final TextureDefinition definition) {
		return get(assetsLocation + definition.getFilePath(), Texture.class);
	}

	public Music getMelody(final Assets.Melody definition) {
		return get(assetsLocation + definition.getFilePath(), Music.class);
	}

	public Sound getSound(final Assets.Sounds sound) {
		return getSound(sound.getFilePath());
	}

	public Sound getSound(String filePath) {
		return get(assetsLocation + filePath, Sound.class);
	}

	public <T extends Declaration> T getModel(String name, Class<T> clazz) {
		return get(assetsLocation + name, clazz);
	}

	public String getShader(final Assets.Shaders shaders) {
		return get(assetsLocation + shaders.getFilePath(), String.class);
	}

	public BitmapFont getFont(final Assets.Fonts font) {
		return get(assetsLocation + font.getAssetManagerKey(), BitmapFont.class);
	}

	public Declaration getDeclaration(Assets.Declarations declaration) {
		return get(assetsLocation + declaration.getFilePath(), Declaration.class);
	}

	@Override
	public void dispose( ) {
		unloadParticleEffects();
		super.dispose();
	}

	private void loadFile(AssetDefinition def, String fileName, boolean block) {
		String path = Gdx.files.getFileHandle(assetsLocation + fileName, FileType.Internal).path();
		if (def.getParameters() != null) {
			load(def.getAssetManagerKey() != null ? def.getAssetManagerKey() : path, def.getTypeClass(), def.getParameters());
		} else {
			load(path, def.getTypeClass());
		}
		if (block) {
			finishLoadingAsset(path);
		}
		loadModelExplicitTexture(def);
	}

	private void loadModelExplicitTexture(AssetDefinition def) {
		if (def instanceof ModelDefinition modelDef) {
			Optional.ofNullable(modelDef.getTextureFileName()).ifPresent(t -> {
				String fileName = assetsLocation + FOLDER + "/" + t + ".png";
				load(fileName, Texture.class);
			});
		}
	}

	private void loadFileWithManualParameters(AssetDefinition def,
											  String fileName,
											  AssetLoaderParameters parameters) {
		String filePath = assetsLocation + fileName;
		String path = Gdx.files.getFileHandle(filePath, FileType.Internal).path();
		Class<?> typeClass = def.getTypeClass();
		String assetManagerKey = def.getAssetManagerKey();
		load(assetManagerKey != null ? assetManagerKey : path, typeClass, parameters);
	}

	private void unloadFileWithManualParameters(AssetDefinition def) {
		String filePath = assetsLocation + def.getFilePath();
		String path = Gdx.files.getFileHandle(filePath, FileType.Internal).path();
		String assetManagerKey = def.getAssetManagerKey();
		unload(assetManagerKey != null ? assetManagerKey : path);
	}
}