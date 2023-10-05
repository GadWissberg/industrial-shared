package com.gadarts.industrial.shared.model.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpriteType {
	IDLE(0.15f, Animation.PlayMode.NORMAL, 2),
	RUN(0.06f),
	ATTACK_PRIMARY(0.06f, Animation.PlayMode.NORMAL, false, 2),
	PAIN(0.1F, Animation.PlayMode.NORMAL, false, true),
	PICKUP(0.1f, Animation.PlayMode.NORMAL, false, true),
	RELOAD(0.1f, Animation.PlayMode.NORMAL, false, false),
	LIGHT_DEATH(0.06f, Animation.PlayMode.NORMAL, true, false, true, 3);

	private final float frameDuration;
	private final Animation.PlayMode playMode;
	private final boolean singleDirection;
	private final boolean addReverse;
	private final boolean death;
	private final int variations;
	private final boolean commandDoneOnReverseEnd;

	SpriteType(final float frameDuration) {
		this(frameDuration, Animation.PlayMode.LOOP, 1);
	}

	SpriteType(float frameDuration, Animation.PlayMode playMode, boolean commandDoneOnReverseEnd, int variations) {
		this(
				frameDuration,
				playMode,
				false,
				false,
				false,
				variations,
				commandDoneOnReverseEnd);
	}

	SpriteType(final float frameDuration, final Animation.PlayMode playMode, int variations) {
		this(
				frameDuration,
				playMode,
				false,
				false,
				false,
				variations,
				true);
	}

	SpriteType(final float frameDuration,
			   final Animation.PlayMode playMode,
			   final boolean singleDirection,
			   final boolean addReverse) {
		this(frameDuration,
				playMode,
				singleDirection,
				addReverse,
				false,
				1,
				true);
	}

	SpriteType(float frameDuration,
			   Animation.PlayMode playMode,
			   boolean singleDirection,
			   boolean addReverse,
			   boolean death,
			   int variations) {
		this(
				frameDuration,
				playMode,
				singleDirection,
				addReverse,
				death,
				variations,
				true);
	}

	public static int randomLightDeath( ) {
		return MathUtils.random(3);
	}
}
