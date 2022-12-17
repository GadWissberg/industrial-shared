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
			1,
			Assets.Sounds.GUARD_BOT_AWAKE,
			Assets.Sounds.WEAPON_FIST,
			Assets.Sounds.GUARD_BOT_PAIN,
			Assets.Sounds.GUARD_BOT_DEATH,
			Assets.Sounds.STEP_CONCRETE,
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
			1.5F,
			Assets.Sounds.GUARD_BOT_AWAKE,
			Assets.Sounds.WEAPON_FIST,
			Assets.Sounds.GUARD_BOT_PAIN,
			Assets.Sounds.GUARD_BOT_DEATH,
			Assets.Sounds.GUARD_BOT_STEP,
			Assets.ParticleEffects.SMALL_EXP,
			0.2F,
			1F),
	TERRORIST_GLOCK("Terrorist - Glock",
			Assets.Atlases.TERRORIST_GLOCK,
			0.5F,
			3,
			Accuracy.MED,
			Sight.HIGH,
			WeaponsDefinitions.GLOCK,
			3,
			1.5F,
			Assets.Sounds.WEAPON_FIST,
			Assets.Sounds.PLAYER_PAIN,
			Assets.Sounds.PLAYER_DEATH,
			Assets.Sounds.STEP_CONCRETE,
			0.2F,
			true);

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
	private final Assets.Sounds meleeSound;
	private final Assets.Sounds painSound;
	private final Assets.Sounds deathSound;
	private final Assets.Sounds stepSound;
	private final Assets.ParticleEffects explosionEffectOnDestroy;
	private final float shadowRadius;
	private final boolean human;
	private final float bulletCreationHeight;

	Enemies(String displayName,
			Assets.Atlases atlasDefinition,
			float agility,
			Integer health,
			Accuracy accuracy,
			Sight sight,
			int engine,
			WeaponsDefinitions primaryAttack,
			int primaryAttackHitFrameIndex,
			float height,
			Assets.Sounds awakeSound,
			Assets.Sounds meleeSound,
			Assets.Sounds painSound,
			Assets.Sounds deathSound,
			Assets.Sounds stepSound,
			Assets.ParticleEffects explosionEffectOnDestroy,
			float shadowRadius,
			float bulletCreationHeight) {
		this(
				displayName,
				atlasDefinition,
				agility,
				health,
				accuracy,
				sight,
				engine,
				primaryAttack,
				primaryAttackHitFrameIndex,
				false,
				height,
				awakeSound,
				meleeSound,
				painSound,
				deathSound,
				stepSound, explosionEffectOnDestroy,
				shadowRadius,
				false,
				bulletCreationHeight);
	}

	Enemies(String displayName,
			Assets.Atlases atlasDefinition,
			float agility,
			Integer health,
			Accuracy accuracy,
			Sight sight,
			WeaponsDefinitions primaryAttack,
			int primaryAttackHitFrameIndex,
			float height,
			Assets.Sounds meleeSound,
			Assets.Sounds painSound,
			Assets.Sounds deathSound,
			Assets.Sounds stepSound,
			float shadowRadius,
			boolean human) {
		this(
				displayName,
				atlasDefinition,
				agility,
				health,
				accuracy,
				sight,
				0,
				primaryAttack,
				primaryAttackHitFrameIndex,
				false,
				height,
				null,
				meleeSound,
				painSound,
				deathSound,
				stepSound,
				null,
				shadowRadius,
				human,
				height / 2F);
	}

	Enemies(String displayName,
			Assets.Atlases atlasDefinition,
			float agility,
			Integer health,
			Accuracy accuracy,
			Sight sight,
			int engine,
			WeaponsDefinitions primaryAttack,
			int primaryAttackHitFrameIndex,
			float height,
			Assets.Sounds awakeSound,
			Assets.Sounds meleeSound,
			Assets.Sounds painSound,
			Assets.Sounds deathSound,
			Assets.Sounds stepSound,
			Assets.ParticleEffects explosionEffectOnDestroy,
			float shadowRadius) {
		this(displayName,
				atlasDefinition,
				agility,
				health,
				accuracy,
				sight,
				engine,
				primaryAttack,
				primaryAttackHitFrameIndex,
				height,
				awakeSound,
				meleeSound,
				painSound,
				deathSound,
				stepSound,
				explosionEffectOnDestroy,
				shadowRadius,
				height / 2F);
	}

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
