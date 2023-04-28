package com.gadarts.industrial.shared.assets.declarations.weapons;

import com.badlogic.gdx.graphics.Color;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.ItemDeclaration;

public record WeaponDeclaration(
		String id,
		float frameDuration,
		String displayName,
		Integer damage,
		Assets.ParticleEffects bulletExplosion,
		Assets.Sounds soundEngage,
		Assets.Sounds soundImpact,
		int numberOfBulletsMin,
		int numberOfBulletsMax,
		int engineConsumption,
		int actionPointsConsumption,
		Assets.Models bulletModel,
		float bulletSpeed,
		Color bulletLightColor,
		boolean lightOnCreation,
		Assets.Models bulletJacket,
		boolean melee,
		float duration
) implements ItemDeclaration {

	@Override
	public String displayName( ) {
		return displayName;
	}

	@Override
	public String name( ) {
		return displayName;
	}


	@Override
	public int getSymbolWidth( ) {
		return 0;
	}

	@Override
	public String getId( ) {
		return id;
	}

	@Override
	public int[] getMask( ) {
		return new int[0];
	}

	@Override
	public int getSymbolHeight( ) {
		return 0;
	}

	@Override
	public Assets.UiTextures getSymbol( ) {
		return null;
	}


	@Override
	public Assets.Models getModelDefinition( ) {
		return bulletModel;
	}

	@Override
	public String toString( ) {
		return displayName;
	}
}
