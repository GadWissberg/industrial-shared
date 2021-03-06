package com.gadarts.industrial.shared.model.characters.player;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.CharacterDefinition;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;
import com.gadarts.industrial.shared.model.characters.enemies.WeaponsDefinitions;

public enum NPCs implements CharacterDefinition {
	;

	@Override
	public String getDisplayName() {
		return "NPC";
	}

	@Override
	public CharacterTypes getCharacterType() {
		return CharacterTypes.NPC;
	}

	@Override
	public boolean isSingleDeathAnimation() {
		return false;
	}

	@Override
	public int getPrimaryAttackHitFrameIndex() {
		return 0;
	}

	@Override
	public Assets.Atlases getAtlasDefinition() {
		return null;
	}
}
