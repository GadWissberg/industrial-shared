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
			5, 7, false),
	COLT(
			0.1F,
			2,
			Assets.ParticleEffects.ENERGY_BALL_EXPLOSION,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			5, 7, false),
	HAMMER(
			0.1F,
			2,
			Assets.ParticleEffects.ENERGY_BALL_EXPLOSION,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP,
			5, 7, false);

	private final float frameDuration;
	private final Integer damage;
	private final Assets.ParticleEffects particleEffect;
	private final Assets.Sounds engageSound;
	private final Assets.Sounds impactSound;
	private final int minNumberOfBullets;
	private final int maxNumberOfBullets;
	private final boolean melee;

}
