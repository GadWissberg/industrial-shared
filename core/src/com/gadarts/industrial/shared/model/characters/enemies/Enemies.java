package com.gadarts.industrial.shared.model.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.CharacterDefinition;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;
import com.gadarts.industrial.shared.model.characters.attributes.Accuracy;
import com.gadarts.industrial.shared.model.characters.attributes.Sight;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Enemies implements CharacterDefinition {
	MAINT_BOT("Maintenance Bot",
			Assets.Atlases.MAINT_BOT,
			0.4F,
			2,
			Accuracy.NONE,
			Sight.HIGH,
			2,
			WeaponsDefinitions.CUTTER,
			4,
			false,
			1,
			Assets.Sounds.ENEMY_AWAKE,
			Assets.Sounds.ENEMY_ROAM,
			Assets.Sounds.ATTACK_FIST,
			Assets.Sounds.ENEMY_PAIN,
			Assets.Sounds.ENEMY_DEATH,
			Assets.Sounds.STEP,
			Assets.ParticleEffects.SMALL_EXP,
			0.45F),
	GUARD_BOT("Guard Bot",
			Assets.Atlases.GUARD_BOT,
			1F,
			4,
			Accuracy.MED,
			Sight.HIGH,
			4,
			WeaponsDefinitions.RAPID_LASER_CANNON,
			3,
			false,
			1.5F,
			Assets.Sounds.ENEMY_AWAKE,
			Assets.Sounds.ENEMY_ROAM,
			Assets.Sounds.ATTACK_FIST,
			Assets.Sounds.ENEMY_PAIN,
			Assets.Sounds.ENEMY_DEATH,
			Assets.Sounds.STEP,
			Assets.ParticleEffects.SMALL_EXP,
			0.2F);

	private final String displayName;
	private final Assets.Atlases atlasDefinition;
	private final float agility;
	private final Integer health;
	private final Accuracy accuracy;
	private final Sight sight;
	private final Integer engine;
	private final WeaponsDefinitions primaryAttack;
	private final int primaryAttackHitFrameIndex;
	private final boolean singleDeathAnimation;
	private final float height;
	private final Assets.Sounds awakeSound;
	private final Assets.Sounds roamSound;
	private final Assets.Sounds attackSound;
	private final Assets.Sounds painSound;
	private final Assets.Sounds deathSound;
	private final Assets.Sounds stepSound;
	private final Assets.ParticleEffects explosionEffectOnDestroy;
	private final float shadowRadius;


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

	@Override
	public float getShadowRadius( ) {
		return shadowRadius;
	}
}
