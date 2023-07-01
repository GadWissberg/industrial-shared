package com.gadarts.industrial.shared.model.characters.player;


import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.declarations.characters.CharacterDeclaration;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;

public class PlayerDeclaration implements CharacterDeclaration {
	private static final PlayerDeclaration instance = new PlayerDeclaration();

	private PlayerDeclaration( ) {
	}

	public static PlayerDeclaration getInstance( ) {
		return instance;
	}

	@Override
	public String displayName( ) {
		return "Player";
	}

	@Override
	public String id( ) {
		return name();
	}

	@Override
	public String toString( ) {
		return displayName();
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
	public Assets.Atlases getAtlasDefinition( ) {
		return Assets.Atlases.PLAYER_COLT;
	}

	@Override
	public float getHeight( ) {
		return 1.5F;
	}

	@Override
	public Assets.Sounds getSoundMelee( ) {
		return Assets.Sounds.WEAPON_FIST;
	}
}
