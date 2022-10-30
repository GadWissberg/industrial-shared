package com.gadarts.industrial.shared.model.characters.player;


import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.CharacterDefinition;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;
import com.gadarts.industrial.shared.model.characters.enemies.WeaponsDefinitions;

public class PlayerDefinition implements CharacterDefinition {
	@Override
	public String getDisplayName( ) {
		return "Player";
	}

	@Override
	public String toString( ) {
		return getDisplayName();
	}

	@Override
	public CharacterTypes getCharacterType( ) {
		return CharacterTypes.PLAYER;
	}

	@Override
	public boolean isSingleDeathAnimation( ) {
		return true;
	}

	@Override
	public String name( ) {
		return "player";
	}

	@Override
	public int getPrimaryAttackHitFrameIndex( ) {
		return -1;
	}

	@Override
	public int ordinal( ) {
		return 0;
	}

	@Override
	public Assets.Atlases getAtlasDefinition( ) {
		return Assets.Atlases.PLAYER_COLT;
	}

	@Override
	public float getHeight( ) {
		return 1.5F;
	}
}
