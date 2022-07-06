package com.gadarts.industrial.shared.model.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.CharacterDefinition;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;
import com.gadarts.industrial.shared.model.characters.attributes.Accuracy;
import com.gadarts.industrial.shared.model.characters.attributes.Agility;
import com.gadarts.industrial.shared.model.characters.attributes.Range;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Enemies implements CharacterDefinition {
	GUARD_BOT("Guard Bot",
			Assets.Atlases.GUARD_BOT,
			Agility.MED,
			4,
			Accuracy.MED,
			Range.HIGH,
			4,
			EnemyWeaponsDefinitions.RAPID_LASER_CANNON,
			4,
			false,
			1.5F,
			Assets.Sounds.ENEMY_AWAKE,
			Assets.Sounds.ENEMY_ROAM,
			Assets.Sounds.ATTACK_FIST,
			Assets.Sounds.ENEMY_PAIN,
			Assets.Sounds.ENEMY_DEATH,
			Assets.Sounds.STEP);

	private final String displayName;
	private final Assets.Atlases atlasDefinition;
	private final Agility agility;
	private final Integer health;
	private final Accuracy accuracy;
	private final Range range;
	private final Integer engine;
	private final EnemyWeaponsDefinitions primaryAttack;
	private final int primaryAttackHitFrameIndex;
	private final boolean singleDeathAnimation;
	private final float height;
	private final Assets.Sounds awakeSound;
	private final Assets.Sounds roamSound;
	private final Assets.Sounds attackSound;
	private final Assets.Sounds painSound;
	private final Assets.Sounds deathSound;
	private final Assets.Sounds stepSound;


	@Override
	public String toString( ) {
		return getDisplayName();
	}

	@Override
	public String getDisplayName( ) {
		return displayName;
	}


	@Override
	public CharacterTypes getCharacterType( ) {
		return CharacterTypes.ENEMY;
	}

	@Override
	public boolean isSingleDeathAnimation( ) {
		return singleDeathAnimation;
	}

	@Override
	public Assets.Atlases getAtlasDefinition( ) {
		return atlasDefinition;
	}
}
