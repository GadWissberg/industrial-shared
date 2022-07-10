package com.gadarts.industrial.shared.model.pickups;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.enemies.WeaponsDefinitions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Player's weapons definitions.
 */
@Getter
@RequiredArgsConstructor
public enum PlayerWeaponsDefinitions implements ItemDefinition {
	HAMMER(1, 2,
			4,
			Assets.UiTextures.WEAPON_HAMMER,
			new int[]{
					1,
					1,
			},
			true,
			"Hammer",
			false,
			false,
			WeaponsDefinitions.HAMMER),
	COLT(2, 2,
			2,
			Assets.UiTextures.WEAPON_COLT,
			new int[]{
					1, 1,
					1, 0
			},
			"Colt M1911",
			Assets.Models.COLT,
			WeaponsDefinitions.COLT);

	@Getter(AccessLevel.NONE)
	private final int symbolWidth;
	@Getter(AccessLevel.NONE)
	private final int symbolHeight;
	private final int hitFrameIndex;
	@Getter(AccessLevel.NONE)
	private final Assets.UiTextures symbol;
	@Getter(AccessLevel.NONE)
	private final int[] mask;
	private final boolean melee;
	private final String displayName;
	private final Assets.Models modelDef;
	private final boolean noisy;
	private final boolean canBeSeenOnTheMap;
	private final WeaponsDefinitions weaponsDefinition;

	PlayerWeaponsDefinitions(int symbolWidth,
							 int symbolHeight,
							 int hitFrameIndex,
							 Assets.UiTextures symbol,
							 int[] mask,
							 boolean melee,
							 String displayName,
							 boolean noisy,
							 boolean canBeSeenOnTheMap,
							 WeaponsDefinitions weaponDefinition) {
		this(symbolWidth, symbolHeight,
				hitFrameIndex,
				symbol,
				mask,
				melee,
				displayName,
				null,
				noisy,
				canBeSeenOnTheMap,
				weaponDefinition);
	}

	PlayerWeaponsDefinitions(int symbolWidth, int symbolHeight,
							 int hitFrameIndex,
							 Assets.UiTextures symbol,
							 int[] mask,
							 String displayName,
							 Assets.Models modelDef,
							 WeaponsDefinitions weaponsDefinition) {
		this(symbolWidth, symbolHeight,
				hitFrameIndex,
				symbol,
				mask,
				false,
				displayName,
				modelDef,
				true,
				true,
				weaponsDefinition);
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

	public Assets.UiTextures getSymbol( ) {
		return symbol;
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
