package com.gadarts.industrial.shared.assets.definitions;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.Data;

public interface DataDefinition extends AssetDefinition {
	String DATA_FOLDER = "data";
	String FORMAT = "json";

	default String getFilePath() {
		String path = DATA_FOLDER + Assets.PATH_SEPARATOR + getSubFolderName() + Assets.PATH_SEPARATOR;
		return path + getName().toLowerCase() + "." + FORMAT;
	}

	String getSubFolderName();

	@Override
	default Class<Data> getTypeClass() {
		return Data.class;
	}

	String getName();
}
