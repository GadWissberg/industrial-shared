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
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.gadarts.industrial.shared.assets.Assets.AssetsTypes;
import com.gadarts.industrial.shared.assets.definitions.*;
import com.gadarts.industrial.shared.assets.loaders.ShaderLoader;

import java.util.Arrays;
import java.util.Optional;

import static com.gadarts.industrial.shared.assets.definitions.ModelDefinition.FOLDER;

/**
 * Assets loader and manager.
 */
public class GameAssetsManager extends AssetManager {
	private final String assetsLocation;
	private boolean loadedParticleEffects;

	public GameAssetsManager( ) {
		this("");
	}

	public GameAssetsManager(final String assetsLocation) {
		this.assetsLocation = assetsLocation;
		setLoader(String.class, new ShaderLoader(getFileHandleResolver()));
		FileHandleResolver resolver = new InternalFileHandleResolver();
		setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		FreetypeFontLoader loader = new FreetypeFontLoader(resolver);
		setLoader(BitmapFont.class, FontDefinition.FORMAT, loader);
		DataLoader dataLoader = new DataLoader(resolver);
		setLoader(Data.class, DataDefinition.FORMAT, dataLoader);
	}

	public void loadParticleEffects(ParticleBatch<?> pointSpriteParticleBatch) {
		Arrays.stream(AssetsTypes.PARTICLES.getAssetDefinitions())
				.forEach(def -> loadFileWithManualParameters(
						def,
						def.getFilePath(),
						new ParticleEffectLoader.ParticleEffectLoadParameter(Array.with(pointSpriteParticleBatch))));
		finishLoading();
		loadedParticleEffects = true;
	}

	public void unloadParticleEffects( ) {
		if (!loadedParticleEffects) return;

		Arrays.stream(AssetsTypes.PARTICLES.getAssetDefinitions()).forEach(def -> unloadFileWithManualParameters(def));
		finishLoading();
		loadedParticleEffects = false;
	}

	/**
	 * Loads all defined assets and inflating animations.
	 */
	public void loadGameFiles(final AssetsTypes... assetsTypesToExclude) {
		Arrays.stream(AssetsTypes.values())
				.filter(type -> Arrays.stream(assetsTypesToExclude).noneMatch(toExclude -> toExclude == type))
				.filter(type -> !type.isManualLoad())
				.forEach(type -> Arrays.stream(type.getAssetDefinitions()).forEach(def -> {
					String[] filesList = def.getFilesList();
					if (filesList.length == 0) {
						loadFile(def);
					} else {
						Arrays.stream(filesList).forEach(file -> loadFile(def, file));
					}
				}));
		finishLoading();
	}

	@Override
	public void dispose( ) {
		unloadParticleEffects();
		super.dispose();
	}

	private void loadFile(AssetDefinition def) {
		loadFile(def, def.getFilePath());
	}

	private void loadFile(AssetDefinition def, String fileName) {
		String path = Gdx.files.getFileHandle(assetsLocation + fileName, FileType.Internal).path();
		Class<?> typeClass = def.getTypeClass();
		if (Optional.ofNullable(def.getParameters()).isPresent()) {
			String assetManagerKey = def.getAssetManagerKey();
			load(assetManagerKey != null ? assetManagerKey : path, typeClass, def.getParameters());
		} else {
			load(path, typeClass);
		}
		loadModelExplicitTexture(def);
	}

	private void loadModelExplicitTexture(AssetDefinition def) {
		if (def instanceof ModelDefinition) {
			ModelDefinition modelDef = (ModelDefinition) def;
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

	/**
	 * Sets repeat value wrap for all loaded textures.
	 */
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

	public <T extends Data> T getModel(String name, Class<T> clazz) {
		return get(assetsLocation + name, clazz);
	}

	public String getShader(final Assets.Shaders shaders) {
		return get(assetsLocation + shaders.getFilePath(), String.class);
	}

	public BitmapFont getFont(final Assets.Fonts font) {
		int size = font.getParams().fontParameters.size;
		String fileName = assetsLocation + font.getFilename() + "_" + size + "." + FontDefinition.FORMAT;
		return get(fileName, BitmapFont.class);
	}
}