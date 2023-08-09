package com.gadarts.industrial.shared.assets.declarations.characters;

import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.declarations.ElementDeclaration;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;

public interface CharacterDeclaration extends ElementDeclaration {
	CharacterTypes getCharacterType( );

	boolean isSingleDeathAnimation( );

	String name( );

	int getPrimaryAttackHitFrameIndex( );

	Assets.Atlases getAtlasDefinition( );

	default float getShadowRadius( ) {
		return 0.2F;
	}

	float getHeight( );

	default Vector3 getBulletCreationOffset(Vector3 output) {
		return output.set(output.x, getHeight() / 2F, output.z);
	}

	Assets.Sounds getSoundMelee( );

	Assets.UiTextures getHudIcon( );
}
