package com.gadarts.industrial.shared.model.characters;

import com.gadarts.industrial.shared.model.ElementType;
import lombok.Getter;

@Getter
public enum CharacterTypes implements ElementType {
	PLAYER, ENEMY, NPC;

	public static final float BILLBOARD_SCALE = 0.013F;
	public static final float BILLBOARD_Y = 0.7f;
}


