package com.gadarts.industrial.shared.model.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeaponsDefinitions {
	RAPID_LASER_CANNON(
			0.1F,
			2,
			Assets.ParticleEffects.ENERGY_BALL_EXPLOSION,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			5, 7,
			4,
			Assets.Models.LASER_BULLET,
			0.2F,
			true),
	COLT(
			0.1F,
			2,
			Assets.ParticleEffects.BULLET_RICOCHET,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			1, Assets.Models.GUN_BULLET,
			0.7F,
			true,
			Assets.Models.GUN_BULLET_JACKET),
	HAMMER(
			0.1F,
			2,
			Assets.ParticleEffects.ENERGY_BALL_EXPLOSION,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			1, 7, false);

	private final float frameDuration;
	private final Integer damage;
	private final Assets.ParticleEffects particleEffectOnDestroy;
	private final Assets.Sounds engageSound;
	private final Assets.Sounds impactSound;
	private final int minNumberOfBullets;
	private final int maxNumberOfBullets;
	private final boolean melee;
	private final int engineConsumption;
	private final Assets.Models modelDefinition;
	private final float bulletSpeed;
	private final boolean emitsLight;
	private final boolean lightOnCreation;
	private final Assets.Models bulletJacket;

	WeaponsDefinitions(float frameDuration,
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
				false,
				engineConsumption,
				modelDefinition,
				bulletSpeed,
				emitsLight,
				false,
				null);
	}

	WeaponsDefinitions(float frameDuration,
					   int damage,
					   Assets.ParticleEffects particleEffectOnDestroy,
					   Assets.Sounds engageSound,
					   Assets.Sounds impactSound,
					   int minNumberOfBullets, int maxNumberOfBullets,
					   boolean melee) {
		this(frameDuration,
				damage,
				particleEffectOnDestroy,
				engageSound,
				impactSound,
				minNumberOfBullets, maxNumberOfBullets,
				melee,
				0,
				null,
				0,
				false,
				false,
				null);
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
				false,
				0,
				modelDefinition,
				bulletSpeed,
				false,
				lightOnCreation,
				bulletJacket);
	}
}
