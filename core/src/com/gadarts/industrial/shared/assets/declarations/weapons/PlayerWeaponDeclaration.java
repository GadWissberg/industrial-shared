package com.gadarts.industrial.shared.assets.declarations.weapons;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.definitions.TextureDefinition;
import com.gadarts.industrial.shared.model.ItemDeclaration;

public record PlayerWeaponDeclaration(String id,
									  int hitFrameIndex,
									  int symbolWidth,
									  int symbolHeight,
									  Assets.UiTextures symbol,
									  WeaponDeclaration declaration,
									  Assets.Atlases relatedAtlas,
									  int[] mask,
									  Assets.Models modelDeclaration) implements ItemDeclaration {

	@Override
	public String displayName( ) {
		return declaration.displayName();
	}

	@Override
	public String name( ) {
		return id;
	}

	@Override
	public int getSymbolWidth( ) {
		return symbolWidth;
	}

	@Override
	public String getId( ) {
		return id;
	}

	@Override
	public int[] getMask( ) {
		return mask;
	}

	@Override
	public int getSymbolHeight( ) {
		return symbolHeight;
	}

	@Override
	public TextureDefinition getSymbol( ) {
		return symbol;
	}

	@Override
	public Assets.Models getModelDefinition( ) {
		return modelDeclaration;
	}
}
