package com.gadarts.industrial.shared.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.Assets.*;
import com.gadarts.industrial.shared.assets.Declaration;
import com.gadarts.industrial.shared.assets.declarations.weapons.PlayerWeaponDeclaration;
import com.gadarts.industrial.shared.assets.declarations.weapons.WeaponDeclaration;
import com.gadarts.industrial.shared.model.characters.attributes.Accuracy;
import com.gadarts.industrial.shared.model.characters.attributes.Sight;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.InputStreamReader;

import static java.lang.String.format;

public class DeclarationsLoader extends AsynchronousAssetLoader<Declaration, DeclarationsLoader.DeclarationsLoaderParameter> {
	private final Gson gson;

	@Getter
	@RequiredArgsConstructor
	public static class DeclarationsLoaderParameter extends AssetLoaderParameters<Declaration> {
		private final Class<? extends Declaration> typeClass;
	}

	public DeclarationsLoader(FileHandleResolver resolver,
							  JsonDeserializer<WeaponDeclaration> weaponDeclarationDeserializer) {
		super(resolver);
		this.gson = new GsonBuilder()
				.registerTypeAdapter(Color.class, (JsonDeserializer<Color>) (j, t, c) -> Color.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(Atlases.class, (JsonDeserializer<Atlases>) (j, t, c) -> Atlases.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(Accuracy.class, (JsonDeserializer<Accuracy>) (j, t, c) -> Accuracy.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(Sight.class, (JsonDeserializer<Sight>) (j, t, c) -> Sight.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(WeaponDeclaration.class, weaponDeclarationDeserializer)
				.registerTypeAdapter(Sounds.class, (JsonDeserializer<Sounds>) (j, t, c) -> Sounds.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(Models.class, (JsonDeserializer<Models>) (j, t, c) -> Models.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(UiTextures.class, (JsonDeserializer<UiTextures>) (j, t, c) -> UiTextures.valueOf(j.getAsString().toUpperCase()))
				.registerTypeAdapter(ParticleEffects.class, (JsonDeserializer<ParticleEffects>) (j, t, c) -> ParticleEffects.valueOf(j.getAsString().toUpperCase()))
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, DeclarationsLoaderParameter parameter) {
		return null;
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, DeclarationsLoaderParameter parameter) {

	}

	@Override
	public Declaration loadSync(AssetManager manager, String fileName, FileHandle file, DeclarationsLoaderParameter parameter) {
		String path = format("%s", fileName);
		InputStreamReader reader = (InputStreamReader) Gdx.files.internal(path).reader();
		return gson.fromJson(reader, parameter.getTypeClass());
	}


}
