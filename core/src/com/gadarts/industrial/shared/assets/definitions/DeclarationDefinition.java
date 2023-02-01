package com.gadarts.industrial.shared.assets.definitions;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.Declaration;

public interface DeclarationDefinition extends AssetDefinition {
	String DATA_FOLDER = "declarations";
	String FORMAT = "json";

	default String getFilePath( ) {
		String sub = getSubFolderName();
		String path = DATA_FOLDER + (sub != null ? Assets.PATH_SEPARATOR + sub : "") + Assets.PATH_SEPARATOR;
		return path + getName().toLowerCase() + "." + FORMAT;
	}

	String getSubFolderName( );

	@Override
	default Class<Declaration> getTypeClass( ) {
		return Declaration.class;
	}

	String getName( );
}
