package com.gadarts.industrial.shared.model.characters;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.ElementDefinition;

public interface CharacterDefinition extends ElementDefinition {
	CharacterTypes getCharacterType( );

	boolean isSingleDeathAnimation( );

	String name( );

	int getPrimaryAttackHitFrameIndex( );

	Assets.Atlases getAtlasDefinition( );

	default float getShadowRadius( ) {
		return 0.2F;
	}

	float getHeight( );

	default float getBulletCreationHeight( ) {
		return getHeight() / 2F;
	}
}
