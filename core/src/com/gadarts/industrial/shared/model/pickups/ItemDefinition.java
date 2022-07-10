package com.gadarts.industrial.shared.model.pickups;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.ModelElementDefinition;

public interface ItemDefinition extends ModelElementDefinition {
	int getSymbolWidth( );

	int[] getMask( );

	int getSymbolHeight( );

	int getId( );

	Assets.UiTextures getSymbol( );

}