package com.gadarts.industrial.shared.model;

import com.gadarts.industrial.shared.assets.definitions.TextureDefinition;

public interface ItemDeclaration extends ModelElementDeclaration {
	int getSymbolWidth( );

	String getId( );

	int[] getMask( );

	int getSymbolHeight( );


	TextureDefinition getSymbol( );

}