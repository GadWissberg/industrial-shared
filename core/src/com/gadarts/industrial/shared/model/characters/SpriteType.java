package com.gadarts.industrial.shared.model.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpriteType {
	IDLE(0F, Animation.PlayMode.LOOP_PINGPONG, 2),
	RUN(0.06f),
	ATTACK_PRIMARY(0.06f, Animation.PlayMode.NORMAL),
	PAIN(0.1F, Animation.PlayMode.NORMAL, false, true),
	PICKUP(0.1f, Animation.PlayMode.NORMAL, false, true),
	LIGHT_DEATH(0.06f, Animation.PlayMode.NORMAL, true, false, true, 3);

	private final float animationDuration;
	private final Animation.PlayMode playMode;
	private final boolean singleAnimation;
	private final boolean addReverse;
	private final boolean death;
	private final String regionName;
	private final int variations;

	SpriteType(final float animationDuration) {
		this(animationDuration, Animation.PlayMode.LOOP, 1);
	}

	SpriteType(float animationDuration, Animation.PlayMode playMode) {
		this(animationDuration, playMode, false, false, false, null, 1);
	}

	SpriteType(final float animationDuration, final Animation.PlayMode playMode, int variations) {
		this(animationDuration, playMode, false, false, false, null, variations);
	}

	SpriteType(final float animationDuration,
			   final Animation.PlayMode playMode,
			   final boolean singleAnimation,
			   final boolean addReverse) {
		this(animationDuration, playMode, singleAnimation, addReverse, false, null, 1);
	}

	SpriteType(float animationDuration,
			   Animation.PlayMode playMode,
			   boolean singleAnimation,
			   boolean addReverse,
			   boolean death,
			   int variations) {
		this(animationDuration, playMode, singleAnimation, addReverse, death, null, variations);
	}

	public static int randomLightDeath( ) {
		return MathUtils.random(3);
	}
}
