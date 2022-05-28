package com.gadarts.industrial.shared.model.characters.player;


import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.CharacterDefinition;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;

public class PlayerDefinition implements CharacterDefinition {
	@Override
	public String getDisplayName() {
		return "Player";
	}
	
	@Override
	public String toString() {
		return getDisplayName();
	}

	@Override
	public CharacterTypes getCharacterType() {
		return CharacterTypes.PLAYER;
	}

	@Override
	public boolean isSingleDeathAnimation() {
		return true;
	}

	@Override
	public String name() {
		return "player";
	}

	@Override
	public int getMeleeHitFrameIndex() {
		return 4;
	}

	@Override
	public int getPrimaryAttackHitFrameIndex() {
		return 4;
	}

	@Override
	public int ordinal() {
		return 0;
	}

	@Override
	public Assets.Atlases getAtlasDefinition() {
		return Assets.Atlases.PLAYER_KNIFE;
	}
}
