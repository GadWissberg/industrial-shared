package com.gadarts.industrial.shared.model.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeaponsDefinitions {
	CUTTER(
			0.1F,
			2,
			1,
			true,
			0.4F),
	RAPID_LASER_CANNON(
			0.1F,
			2,
			Assets.ParticleEffects.LASER_EXP,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			5, 7,
			4,
			Assets.Models.LASER_BULLET,
			0.2F,
			true),
	GLOCK(
			0.1F,
			1,
			Assets.ParticleEffects.BULLET_RICOCHET,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			1, Assets.Models.GUN_BULLET,
			0.7F,
			true,
			Assets.Models.GUN_BULLET_JACKET);

	private final float frameDuration;
	private final Integer damage;
	private final Assets.ParticleEffects particleEffectOnDestroy;
	private final Assets.Sounds engageSound;
	private final Assets.Sounds impactSound;
	private final int minNumberOfBullets;
	private final int maxNumberOfBullets;
	private final int engineConsumption;
	private final Assets.Models modelDefinition;
	private final float bulletSpeed;
	private final boolean emitsLight;
	private final boolean lightOnCreation;
	private final Assets.Models bulletJacket;
	private final boolean melee;
	private final float duration;

	WeaponsDefinitions(float frameDuration,
					   int damage,
					   int engineConsumption,
					   boolean melee,
					   float duration) {
		this(
				frameDuration,
				damage,
				null, null, null,
				0, 0,
				engineConsumption,
				null, 0,
				false, false, null,
				melee,
				duration);
	}

	WeaponsDefinitions(
			float frameDuration,
			int damage,
			Assets.ParticleEffects particleEffectOnDestroy,
			Assets.Sounds engageSound,
			Assets.Sounds impactSound,
			int minNumberOfBullets, int maxNumberOfBullets,
			int engineConsumption,
			Assets.Models modelDefinition,
			float bulletSpeed,
			boolean emitsLight) {
		this(frameDuration,
				damage,
				particleEffectOnDestroy,
				engageSound,
				impactSound,
				minNumberOfBullets, maxNumberOfBullets,
				engineConsumption,
				modelDefinition,
				bulletSpeed,
				emitsLight,
				false,
				null,
				false,
				1F);
	}

	WeaponsDefinitions(float frameDuration,
					   int damage,
					   Assets.ParticleEffects particleEffectOnDestroy,
					   Assets.Sounds engageSound,
					   Assets.Sounds impactSound,
					   int numberOfBullets,
					   Assets.Models modelDefinition,
					   float bulletSpeed,
					   boolean lightOnCreation,
					   Assets.Models bulletJacket) {
		this(frameDuration,
				damage,
				particleEffectOnDestroy,
				engageSound,
				impactSound,
				numberOfBullets,
				numberOfBullets,
				0,
				modelDefinition,
				bulletSpeed,
				false,
				lightOnCreation,
				bulletJacket,
				false,
				1F);
	}
}
