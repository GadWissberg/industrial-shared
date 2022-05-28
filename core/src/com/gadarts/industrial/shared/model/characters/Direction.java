package com.gadarts.industrial.shared.model.characters;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;

public enum Direction {
	SOUTH(0, 1, 0B00000010),
	SOUTH_EAST(1, 1, 0B00000001),
	EAST(1, 0, 0B00001000),
	NORTH_EAST(1, -1, 0B001000000),
	NORTH(0, -1, 0B010000000),
	NORTH_WEST(-1, -1, 0B100000000),
	WEST(-1, 0, 0B000100000),
	SOUTH_WEST(-1, 1, 0B00000100);

	private static final float DIR_ANGLE_SIZE = 45;
	private final Vector2 directionVector;
	private final float bottomBound;
	private final float upperBound;

	@Getter
	private final int mask;

	Direction(final int x, final int z, int mask) {
		directionVector = new Vector2(x, z);
		float angleDeg = directionVector.angleDeg();
		Vector2 auxVector = new Vector2();
		bottomBound = auxVector.set(1, 0).setAngleDeg(angleDeg - DIR_ANGLE_SIZE / 2).angleDeg();
		upperBound = angleDeg + DIR_ANGLE_SIZE / 2;
		this.mask = mask;
	}

	public static Direction findDirection(final Vector2 direction) {
		Direction[] values = values();
		Direction result = SOUTH;
		float angleDeg = direction.angleDeg();
		for (Direction dir : values) {
			boolean isBottomLessThanUpper = dir.bottomBound < dir.upperBound;
			boolean firstOpt = isBottomLessThanUpper && angleDeg >= dir.bottomBound && angleDeg < dir.upperBound;
			boolean secondOpt = !isBottomLessThanUpper && (angleDeg >= dir.bottomBound || angleDeg < dir.upperBound);
			if (firstOpt || secondOpt) {
				result = dir;
				break;
			}
		}
		return result;
	}

	public Vector2 getDirection(final Vector2 output) {
		return output.set(directionVector);
	}
}
