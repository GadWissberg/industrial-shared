package com.gadarts.industrial.shared.model.characters;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.ElementDefinition;
import com.gadarts.industrial.shared.model.characters.enemies.WeaponsDefinitions;

public interface CharacterDefinition extends ElementDefinition {
	CharacterTypes getCharacterType( );

	boolean isSingleDeathAnimation( );

	String name( );

	int getPrimaryAttackHitFrameIndex( );

	Assets.Atlases getAtlasDefinition( );
}
