package com.gadarts.industrial.shared.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class DataLoader extends AsynchronousAssetLoader<Data, DataLoader.DataLoaderParameter> {
	public static class DataLoaderParameter extends AssetLoaderParameters<Data> {
	}

	public DataLoader(FileHandleResolver resolver) {
		super(resolver);
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, DataLoaderParameter parameter) {
		return null;
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, DataLoaderParameter parameter) {

	}

	@Override
	public Data loadSync(AssetManager manager, String fileName, FileHandle file, DataLoaderParameter parameter) {
		return null;
	}


}
