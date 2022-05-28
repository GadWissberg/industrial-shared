package com.gadarts.industrial.shared.model.pickups;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.ModelElementDefinition;

public interface ItemDefinition extends ModelElementDefinition {
	int getWidth( );

	int[] getMask( );

	int getHeight( );

	int getId( );

	Assets.UiTextures getImage( );

}