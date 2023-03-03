package com.gadarts.industrial.shared.utils;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import squidpony.squidmath.Bresenham;
import squidpony.squidmath.Coord3D;

import java.util.ArrayDeque;

public final class CameraUtils {
	public static final int CAMERA_ROTATION_AROUND_X = -55;
	public static final float START_OFFSET_X = 9;
	public static final float START_OFFSET_Z = 9;
	public static final int CAMERA_HEIGHT = 16;
	public static final float INITIAL_CAMERA_ANGLE_AROUND_Y = 45;
	private static final Plane floorPlane = new Plane(new Vector3(0, 1, 0), 0);
	private static final Vector3 auxVector3 = new Vector3();

	public static void initializeCameraAngle(OrthographicCamera camera) {
		camera.direction.rotate(Vector3.X, CAMERA_ROTATION_AROUND_X);
		camera.direction.rotate(Vector3.Y, INITIAL_CAMERA_ANGLE_AROUND_Y);
	}

	public static ArrayDeque<Coord3D> findAllCoordsOnRay(int screenX, int screenY, Camera camera) {
		Ray ray = camera.getPickRay(screenX, screenY);
		Intersector.intersectRayPlane(ray, floorPlane, auxVector3);
		Vector3 pos = camera.position;
		return (ArrayDeque<Coord3D>) Bresenham.line3D(
				(int) Math.round((double) pos.x), (int) Math.round((double) pos.y), (int) Math.round((double) pos.z),
				(int) Math.floor(auxVector3.x), 0, (int) Math.floor(auxVector3.z));
	}
}
