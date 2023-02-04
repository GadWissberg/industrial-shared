package com.gadarts.industrial.shared.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.gadarts.industrial.shared.assets.Declaration;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Reader;

import static java.lang.String.format;

public class DeclarationsLoader extends AsynchronousAssetLoader<Declaration, DeclarationsLoader.DeclarationsLoaderParameter> {
	private final Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();

	@Getter
	@RequiredArgsConstructor
	public static class DeclarationsLoaderParameter extends AssetLoaderParameters<Declaration> {
		private final Class<? extends Declaration> typeClass;
	}

	public DeclarationsLoader(FileHandleResolver resolver) {
		super(resolver);
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
		Reader reader = Gdx.files.internal(path).reader();
		return gson.fromJson(reader, parameter.getTypeClass());
	}


}
