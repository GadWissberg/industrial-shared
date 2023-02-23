package com.gadarts.industrial.shared.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.Declaration;
import com.gadarts.industrial.shared.assets.declarations.weapons.WeaponDeclaration;
import com.google.gson.Gson;
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
		this.gson = Assets.generateDefinedGsonBuilder()
				.registerTypeAdapter(WeaponDeclaration.class, weaponDeclarationDeserializer)
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
