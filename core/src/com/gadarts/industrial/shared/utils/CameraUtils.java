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

@SuppressWarnings("ALL")
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
		Vector3 intersection = auxVector3;
		Intersector.intersectRayPlane(ray, floorPlane, intersection);
		return (ArrayDeque<Coord3D>) Bresenham.line3D(
				(int) ray.origin.x, (int) ray.origin.y, (int) ray.origin.z,
				(int) intersection.x, 0, (int) intersection.z);
	}
}
