package com.gadarts.industrial.shared.model.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpriteType {
	IDLE(0.3f, Animation.PlayMode.LOOP_PINGPONG),
	RUN(0.06f),
	ATTACK_PRIMARY(0.06f, Animation.PlayMode.NORMAL),
	PAIN(0.1F, Animation.PlayMode.NORMAL, false, true),
	PICKUP(0.1f, Animation.PlayMode.NORMAL, false, true),
	LIGHT_DEATH_1(0.06f, Animation.PlayMode.NORMAL, true, false, true),
	LIGHT_DEATH_2(0.06f, Animation.PlayMode.NORMAL, true, false, true),
	LIGHT_DEATH_3(0.06f, Animation.PlayMode.NORMAL, true, false, true);

	private final float animationDuration;
	private final Animation.PlayMode playMode;
	private final boolean singleAnimation;
	private final boolean addReverse;
	private final boolean death;
	private final String regionName;

	SpriteType(final float animationDuration) {
		this(animationDuration, Animation.PlayMode.LOOP);
	}

	SpriteType(final float animationDuration, final Animation.PlayMode playMode) {
		this(animationDuration, playMode, false, false, false, null);
	}

	SpriteType(final float animationDuration,
			   final Animation.PlayMode playMode,
			   final boolean singleAnimation,
			   final boolean addReverse) {
		this(animationDuration, playMode, singleAnimation, addReverse, false, null);
	}


	SpriteType(float animationDuration, Animation.PlayMode playMode, String regionName) {
		this(animationDuration, playMode, false, false, false, regionName);
	}

	SpriteType(float animationDuration,
			   Animation.PlayMode playMode,
			   boolean singleAnimation,
			   boolean addReverse,
			   boolean death) {
		this(animationDuration, playMode, singleAnimation, addReverse, death, null);
	}

	public static SpriteType randomLightDeath( ) {
		int random = MathUtils.random(3);
		if (random == 0) {
			return LIGHT_DEATH_1;
		} else if (random == 1) {
			return LIGHT_DEATH_2;
		} else {
			return LIGHT_DEATH_3;
		}
	}
}
