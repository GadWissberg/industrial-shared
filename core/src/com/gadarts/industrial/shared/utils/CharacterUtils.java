package com.gadarts.industrial.shared.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.gadarts.industrial.shared.model.characters.Direction;

public class CharacterUtils {
	private final static Vector2 auxVector2_1 = new Vector2();
	private final static Vector2 auxVector2_2 = new Vector2();
	private final static Vector2 auxVector2_3 = new Vector2();
	private final static Vector3 auxVector3_1 = new Vector3();
	private final static Plane auxPlane = new Plane();

	public static Direction calculateDirectionSeenFromCamera(final Camera camera, final Direction facingDirection) {
		auxVector2_3.set(1, 0);
		float playerAngle = facingDirection.getDirection(auxVector2_1).angleDeg();
		Ray ray = camera.getPickRay(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
		Intersector.intersectRayPlane(ray, auxPlane, auxVector3_1);
		float cameraAngle = auxVector2_2.set(camera.position.x, camera.position.z)
				.sub(auxVector3_1.x, auxVector3_1.z)
				.angleDeg();
		auxVector2_3.setAngleDeg(playerAngle - cameraAngle);
		float angleDiff = auxVector2_3.angleDeg();
		Direction direction;
		if ((angleDiff >= 0 && angleDiff <= 22.5) || (angleDiff > 337.5f && angleDiff <= 360)) {
			direction = Direction.SOUTH;
		} else if (angleDiff > 22.5 && angleDiff <= 67.5) {
			direction = Direction.SOUTH_WEST;
		} else if (angleDiff > 67.5 && angleDiff <= 112.5) {
			direction = Direction.WEST;
		} else if (angleDiff > 112.5 && angleDiff <= 157.5) {
			direction = Direction.NORTH_WEST;
		} else if (angleDiff > 157.5 && angleDiff <= 202.5) {
			direction = Direction.NORTH;
		} else if (angleDiff > 202.5 && angleDiff <= 247.5) {
			direction = Direction.NORTH_EAST;
		} else if (angleDiff > 247.5 && angleDiff <= 292.5) {
			direction = Direction.EAST;
		} else {
			direction = Direction.SOUTH_EAST;
		}
		return direction;
	}
}
