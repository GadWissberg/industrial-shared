package com.gadarts.industrial.shared.assets.declarations.weapons;

import com.badlogic.gdx.graphics.Color;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.ItemDeclaration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeaponDeclaration implements ItemDeclaration {
	private String id;
	private float frameDuration;
	private String displayName;
	private Integer damage;
	private Assets.ParticleEffects bulletExplosion;
	private Assets.Sounds soundEngage;
	private Assets.Sounds soundImpact;
	private int numberOfBulletsMin;
	private int numberOfBulletsMax;
	private int engineConsumption;
	private Assets.Models bulletModel;
	private float bulletSpeed;
	private Color bulletLightColor;
	private boolean lightOnCreation;
	private Assets.Models bulletJacket;
	private boolean melee;
	private float duration;

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
}
