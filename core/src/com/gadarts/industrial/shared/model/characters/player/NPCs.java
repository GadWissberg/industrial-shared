package com.gadarts.industrial.shared.model.characters.player;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.declarations.characters.CharacterDeclaration;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;

public enum NPCs implements CharacterDeclaration {
	;

	@Override
	public String displayName( ) {
		return "NPC";
	}

	@Override
	public String id( ) {
		return null;
	}

	@Override
	public CharacterTypes getCharacterType( ) {
		return CharacterTypes.NPC;
	}

	@Override
	public boolean isSingleDeathAnimation( ) {
		return false;
	}

	@Override
	public int getPrimaryAttackHitFrameIndex( ) {
		return 0;
	}

	@Override
	public Assets.Atlases getAtlasDefinition( ) {
		return null;
	}

	@Override
	public float getHeight( ) {
		return 1.5F;
	}

	@Override
	public Assets.Sounds getSoundMelee( ) {
		return null;
	}
}
