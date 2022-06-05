package com.gadarts.industrial.shared.model.pickups;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Player's weapons definitions.
 */
@Getter
public enum WeaponsDefinitions implements ItemDefinition {
	KNIFE(1, 2,
			4,
			Assets.UiTextures.WEAPON_KNIFE,
			Assets.Sounds.ATTACK_KNIFE,
			new int[]{
					1,
					1,
			},
			true,
			"Knife",
			false,
			false),
	COLT(2, 2,
			2,
			Assets.UiTextures.WEAPON_COLT,
			Assets.Sounds.ATTACK_COLT,
			new int[]{
					1, 1,
					1, 0
			},
			"Colt M1911",
			Assets.Models.COLT,
			true,
			1);

	@Getter(AccessLevel.NONE)
	private final int symbolWidth;

	@Getter(AccessLevel.NONE)
	private final int symbolHeight;

	@Getter(AccessLevel.NONE)
	private final Assets.UiTextures image;

	@Getter(AccessLevel.NONE)
	private final int[] mask;

	private final Assets.Sounds attackSound;
	private final boolean melee;
	private final int hitFrameIndex;
	private final String displayName;
	private final Assets.Models modelDef;
	private final boolean hitScan;
	private final int damage;
	private final boolean noisy;
	private final boolean canBeSeenOnTheMap;

	WeaponsDefinitions(int symbolWidth,
					   int symbolHeight,
					   int hitFrameIndex,
					   Assets.UiTextures image,
					   Assets.Sounds attackSound,
					   int[] mask,
					   boolean melee,
					   String displayName,
					   boolean noisy,
					   boolean canBeSeenOnTheMap) {
		this(symbolWidth,
				symbolHeight,
				hitFrameIndex,
				image,
				attackSound,
				mask,
				melee,
				displayName,
				null,
				false,
				0,
				noisy,
				canBeSeenOnTheMap);
	}

	WeaponsDefinitions(final int symbolWidth,
					   final int symbolHeight,
					   final int hitFrameIndex,
					   final Assets.UiTextures image,
					   final Assets.Sounds attackSound,
					   final int[] mask,
					   final String displayName,
					   final Assets.Models model,
					   final boolean hitScan,
					   final int damage) {
		this(symbolWidth,
				symbolHeight,
				hitFrameIndex,
				image,
				attackSound,
				mask,
				false,
				displayName,
				model,
				hitScan,
				damage,
				true,
				true);
	}

	WeaponsDefinitions(final int symbolWidth,
					   final int symbolHeight,
					   final int hitFrameIndex,
					   final Assets.UiTextures image,
					   final Assets.Sounds attackSound,
					   final int[] mask,
					   final boolean melee,
					   final String displayName,
					   final Assets.Models model,
					   final boolean hitScan,
					   final int damage,
					   final boolean noisy,
					   final boolean canBeSeenOnTheMap) {
		this.symbolWidth = symbolWidth;
		this.symbolHeight = symbolHeight;
		this.hitFrameIndex = hitFrameIndex;
		this.image = image;
		this.attackSound = attackSound;
		this.mask = flipMatrixVertically(mask);
		this.melee = melee;
		this.displayName = displayName;
		this.modelDef = model;
		this.hitScan = hitScan;
		this.damage = damage;
		this.noisy = noisy;
		this.canBeSeenOnTheMap = canBeSeenOnTheMap;
	}

	private int[] flipMatrixVertically(final int[] mask) {
		int[] flipped = new int[mask.length];
		for (int row = 0; row < symbolHeight; row++) {
			for (int col = 0; col < symbolWidth; col++) {
				flipped[row * symbolWidth + col] = mask[((symbolHeight - 1 - row) * symbolWidth) + col];
			}
		}
		return flipped;
	}

	public int getSymbolWidth( ) {
		return symbolWidth;
	}

	@Override
	public int getDepth( ) {
		return 1;
	}

	@Override
	public int[] getMask( ) {
		return mask;
	}

	public int getSymbolHeight( ) {
		return symbolHeight;
	}

	@Override
	public int getId( ) {
		return ordinal() + 1;
	}

	@Override
	public Assets.UiTextures getImage( ) {
		return image;
	}


	@Override
	public String getDisplayName( ) {
		return displayName;
	}


	@Override
	public boolean isCanBeSeenOnTheMap( ) {
		return canBeSeenOnTheMap;
	}

	@Override
	public Assets.Models getModelDefinition( ) {
		return modelDef;
	}

	@Override
	public int getWidth( ) {
		return 1;
	}
}
