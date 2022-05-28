package com.gadarts.industrial.shared.assets.definitions;

import com.badlogic.gdx.graphics.Texture;
import com.gadarts.industrial.shared.assets.Assets;

public interface TextureDefinition extends AssetDefinition {
	String TEXTURES_FOLDER = "textures";
	String TEXTURE_FORMAT = "png";

	default String getFilePath() {
		String path = TEXTURES_FOLDER + Assets.PATH_SEPARATOR + getSubFolderName() + Assets.PATH_SEPARATOR;
		return path + getName().toLowerCase() + "." + TEXTURE_FORMAT;
	}

	String getSubFolderName();

	@Override
	default Class<Texture> getTypeClass() {
		return Texture.class;
	}

	String getName();
}
