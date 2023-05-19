package com.gadarts.industrial.shared.utils;

import com.badlogic.gdx.math.Vector3;

public class ImmutableVector3 extends Vector3 {

	private static final String EXCEPTION_MESSAGE_IMMUTABLE_VECTORS_CANNOT_BE_MODIFIED = "Immutable vectors cannot be modified";

	@Override
	public Vector3 set(float x, float y, float z) {
		throw new GameException(EXCEPTION_MESSAGE_IMMUTABLE_VECTORS_CANNOT_BE_MODIFIED);
	}

	@Override
	public Vector3 lerp(Vector3 target, float alpha) {
		throw new GameException(EXCEPTION_MESSAGE_IMMUTABLE_VECTORS_CANNOT_BE_MODIFIED);
	}

	@Override
	public Vector3 setZero( ) {
		throw new GameException(EXCEPTION_MESSAGE_IMMUTABLE_VECTORS_CANNOT_BE_MODIFIED);
	}

	@Override
	public Vector3 mulAdd(Vector3 vec, Vector3 mulVec) {
		throw new GameException(EXCEPTION_MESSAGE_IMMUTABLE_VECTORS_CANNOT_BE_MODIFIED);
	}

	@Override
	public Vector3 mulAdd(Vector3 vec, float scalar) {
		throw new GameException(EXCEPTION_MESSAGE_IMMUTABLE_VECTORS_CANNOT_BE_MODIFIED);
	}
}
