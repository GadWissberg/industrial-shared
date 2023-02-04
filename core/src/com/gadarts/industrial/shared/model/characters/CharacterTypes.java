package com.gadarts.industrial.shared.model.characters;

import com.gadarts.industrial.shared.model.characters.player.NPCs;
import com.gadarts.industrial.shared.model.characters.player.PlayerDeclaration;
import lombok.Getter;

@Getter
public enum CharacterTypes {
	PLAYER(new PlayerDeclaration[]{new PlayerDeclaration()}), ENEMY, NPC(NPCs.values());

	public static final float BILLBOARD_SCALE = 0.013F;
	public static final float BILLBOARD_Y = 0.7f;
	private final CharacterDeclaration[] definitions;

	CharacterTypes( ) {
		this(null);
	}

	CharacterTypes(final CharacterDeclaration[] definitions) {
		this.definitions = definitions;
	}
}
