package com.gadarts.industrial.shared.model.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.characters.CharacterDefinition;
import com.gadarts.industrial.shared.model.characters.CharacterTypes;
import com.gadarts.industrial.shared.model.characters.attributes.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum Enemies implements CharacterDefinition {
	SCORPION("Scorpion",
			Assets.Atlases.SCORPION,
			List.of(Agility.LOW, Agility.LOW, Agility.LOW, Agility.MED, Agility.MED),
			List.of(Strength.of(1), Strength.of(1), Strength.of(1), Strength.of(1, 2), Strength.of(1, 2)),
			List.of(1, 1, 2, 2, 2),
			1,
			true,
			0.1F,
			Assets.Sounds.SCORPION_AWAKE, Assets.Sounds.SCORPION_ROAM, Assets.Sounds.SCORPION_ATTACK, Assets.Sounds.SCORPION_PAIN, Assets.Sounds.SCORPION_DEATH, Assets.Sounds.LIGHT_STEP),

	ANUBIS("Anubis Zealot",
			Assets.Atlases.ANUBIS,
			List.of(Agility.LOW, Agility.MED, Agility.MED, Agility.HIGH, Agility.HIGH),
			List.of(Strength.of(1), Strength.of(1), Strength.of(1), Strength.of(1, 2), Strength.of(1, 2)),
			List.of(2, 2, 2, 3, 3),
			new Accuracy[]{Accuracy.NONE, Accuracy.LOW, Accuracy.MED, Accuracy.MED, Accuracy.MED},
			List.of(Range.NONE, Range.MED, Range.MED, Range.MED, Range.HIGH),
			List.of(ReloadTime.NONE, ReloadTime.MED, ReloadTime.MED, ReloadTime.MED, ReloadTime.MED),
			EnemyWeaponsDefinitions.ENERGY_BALL,
			4,
			5,
			false,
			Assets.Sounds.ENEMY_AWAKE, Assets.Sounds.ENEMY_ROAM, Assets.Sounds.ATTACK_FIST, Assets.Sounds.ENEMY_PAIN, Assets.Sounds.ENEMY_DEATH, Assets.Sounds.STEP);

	private final String displayName;
	private final Assets.Atlases atlasDefinition;
	private final List<Agility> agility;
	private final List<Strength> strength;
	private final List<Integer> health;
	private final Accuracy[] accuracy;
	private final List<Range> range;
	private final List<ReloadTime> reloadTime;
	private final EnemyWeaponsDefinitions primaryAttack;
	private final int meleeHitFrameIndex;
	private final int primaryAttackHitFrameIndex;
	private final boolean singleDeathAnimation;
	private final float height;
	private final Assets.Sounds awakeSound;
	private final Assets.Sounds roamSound;
	private final Assets.Sounds attackSound;
	private final Assets.Sounds painSound;
	private final Assets.Sounds deathSound;
	private final Assets.Sounds stepSound;

	Enemies(final String displayName,
			final Assets.Atlases atlasDefinition,
			final List<Agility> agility,
			final List<Strength> strength,
			final List<Integer> health,
			final int meleeHitFrameIndex,
			final boolean singleDeathAnimation,
			final float height,
			final Assets.Sounds awakeSound,
			final Assets.Sounds roamSound,
			final Assets.Sounds attackSound,
			final Assets.Sounds painSound,
			final Assets.Sounds deathSound,
			final Assets.Sounds stepSound) {
		this(
				displayName,
				atlasDefinition,
				agility,
				strength,
				health,
				null, null, null, null,
				meleeHitFrameIndex, 0,
				singleDeathAnimation,
				height,
				awakeSound,
				roamSound,
				attackSound,
				painSound,
				deathSound,
				stepSound);
	}

	Enemies(final String displayName,
			final Assets.Atlases atlasDefinition,
			final List<Agility> agility,
			final List<Strength> strength,
			final List<Integer> health,
			final Accuracy[] accuracy,
			final List<Range> range,
			final List<ReloadTime> reloadTime,
			final EnemyWeaponsDefinitions primaryAttack,
			final int meleeHitFrameIndex,
			final int primaryAttackHitFrameIndex,
			final boolean singleDeathAnimation,
			final Assets.Sounds awakeSound,
			final Assets.Sounds roamSound,
			final Assets.Sounds attackSound,
			final Assets.Sounds painSound,
			final Assets.Sounds deathSound,
			final Assets.Sounds stepSound) {
		this(
				displayName,
				atlasDefinition,
				agility,
				strength,
				health,
				accuracy,
				range,
				reloadTime,
				primaryAttack,
				meleeHitFrameIndex,
				primaryAttackHitFrameIndex,
				singleDeathAnimation,
				1F,
				awakeSound, roamSound, attackSound, painSound, deathSound, stepSound);
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
}
