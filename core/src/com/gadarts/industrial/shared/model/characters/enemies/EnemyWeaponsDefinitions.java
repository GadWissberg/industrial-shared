package com.gadarts.industrial.shared.model.characters.enemies;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnemyWeaponsDefinitions {
	RAPID_LASER_CANNON(
			0.1F,
			2,
			Assets.ParticleEffects.ENERGY_BALL_EXPLOSION,
			Assets.Sounds.ATTACK_ENERGY_BALL,
			Assets.Sounds.SMALL_EXP);

	private final float frameDuration;
	private final Integer damagePoints;
	private final Assets.ParticleEffects particleEffect;
	private final Assets.Sounds engageSound;
	private final Assets.Sounds impactSound;

}
