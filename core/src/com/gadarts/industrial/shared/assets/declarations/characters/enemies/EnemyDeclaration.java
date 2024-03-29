package com.gadarts.industrial.shared.assets.declarations.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.declarations.Agility;
import com.gadarts.industrial.shared.assets.declarations.characters.CharacterDeclaration;
import com.gadarts.industrial.shared.assets.declarations.pickups.weapons.WeaponDeclaration;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;
import com.gadarts.industrial.shared.model.characters.attributes.Accuracy;
import com.gadarts.industrial.shared.model.characters.attributes.Sight;
import com.gadarts.industrial.shared.utils.ImmutableVector3;

public record EnemyDeclaration(String id,
							   String displayName,
							   Assets.Atlases atlasDefinition,
							   Agility agility,
							   Integer health,
							   Accuracy accuracy,
							   Sight sight,
							   int engine,
							   WeaponDeclaration attackPrimary,
							   int attackPrimaryHitFrameIndex,
							   boolean singleDeathAnimation,
							   float height,
							   Assets.Sounds soundAwake,
							   Assets.Sounds soundMelee,
							   Assets.Sounds soundPain,
							   Assets.Sounds soundDeath,
							   Assets.Sounds soundStep,
							   Assets.Sounds explosionEffectOnDestroy,
							   float shadowRadius,
							   boolean human,
							   ImmutableVector3 bulletCreationOffset,
							   Assets.UiTextures hudIcon) implements CharacterDeclaration {
	@Override
	public CharacterTypes getCharacterType( ) {
		return CharacterTypes.ENEMY;
	}

	@Override
	public boolean isSingleDeathAnimation( ) {
		return false;
	}

	@Override
	public String name( ) {
		return displayName;
	}

	@Override
	public int getPrimaryAttackHitFrameIndex( ) {
		return attackPrimaryHitFrameIndex;
	}

	@Override
	public Assets.Atlases getAtlasDefinition( ) {
		return atlasDefinition;
	}

	@Override
	public float getHeight( ) {
		return height;
	}

	@Override
	public Assets.Sounds getSoundMelee( ) {
		return soundMelee;
	}

	@Override
	public Assets.UiTextures getHudIcon( ) {
		return hudIcon;
	}
}
