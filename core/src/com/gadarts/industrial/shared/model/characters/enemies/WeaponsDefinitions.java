package com.gadarts.industrial.shared.model.characters.enemies;

import com.badlogic.gdx.graphics.Color;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.definitions.SoundDefinition;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeaponsDefinitions {
	PUNCH(
			0.1F,
			1,
			true,
			1.0F),
	CUTTER(
			0.1F,
			2,
			1,
			true,
			0.4F,
			Assets.Sounds.WEAPON_CUTTER),
	RAPID_LASER_CANNON(
			0.1F,
			2,
			Assets.ParticleEffects.LASER_EXP,
			Assets.Sounds.WEAPON_RAPID_LASER_CANNON,
			Assets.Sounds.SMALL_EXP,
			5, 7,
			4,
			Assets.Models.LASER_BULLET,
			0.2F,
			Color.RED),
	GLOCK(
			0.1F,
			1,
			Assets.ParticleEffects.BULLET_RICOCHET,
			Assets.Sounds.WEAPON_GLOCK,
			Assets.Sounds.SMALL_EXP,
			1, Assets.Models.GUN_BULLET,
			0.6F,
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
	private final Color lightColor;
	private final boolean lightOnCreation;
	private final Assets.Models bulletJacket;
	private final boolean melee;
	private final float duration;

	WeaponsDefinitions(float frameDuration,
					   int damage,
					   boolean melee,
					   float duration) {
		this(
				frameDuration,
				damage,
				null, null, null,
				0, 0, 0,
				null, 0, null, false, null,
				melee,
				duration);
	}

	WeaponsDefinitions(float frameDuration,
					   int damage,
					   int engineConsumption,
					   boolean melee,
					   float duration,
					   Assets.Sounds engageSound) {
		this(
				frameDuration,
				damage,
				null, engageSound, null,
				0, 0,
				engineConsumption,
				null, 0,
				null, false, null,
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
			Color lightColor) {
		this(frameDuration,
				damage,
				particleEffectOnDestroy,
				engageSound,
				impactSound,
				minNumberOfBullets, maxNumberOfBullets,
				engineConsumption,
				modelDefinition,
				bulletSpeed,
				lightColor,
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
				null,
				lightOnCreation,
				bulletJacket,
				false,
				1F);
	}
}
