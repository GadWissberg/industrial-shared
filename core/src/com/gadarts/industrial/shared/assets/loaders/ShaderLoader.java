package com.gadarts.industrial.shared.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class ShaderLoader extends AsynchronousAssetLoader<String, ShaderLoader.ShaderParameters> {
	public ShaderLoader(final FileHandleResolver resolver) {
		super(resolver);
	}

	@Override
	public Array<AssetDescriptor> getDependencies(final String fileName,
												  final FileHandle file,
												  final ShaderParameters parameter) {
		return null;
	}

	@Override
	public void loadAsync(final AssetManager manager,
						  final String fileName,
						  final FileHandle file,
						  final ShaderParameters parameter) {

	}

	@Override
	public String loadSync(final AssetManager manager,
						   final String fileName,
						   final FileHandle file,
						   final ShaderParameters parameter) {
		return file.readString();
	}


	public static class ShaderParameters extends AssetLoaderParameters<String> {
	}
}
