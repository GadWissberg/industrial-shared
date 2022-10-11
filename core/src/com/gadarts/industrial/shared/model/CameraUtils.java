package com.gadarts.industrial.shared.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public final class CameraUtils {
	public static final int CAMERA_ROTATION_AROUND_X = -55;
	public static final float START_OFFSET_X = 9;
	public static final float START_OFFSET_Z = 9;
	public static final int CAMERA_HEIGHT = 16;
	public static final float INITIAL_CAMERA_ANGLE_AROUND_Y = 45;

	public static void initializeCameraAngle(OrthographicCamera camera) {
		camera.direction.rotate(Vector3.X, CAMERA_ROTATION_AROUND_X);
		camera.direction.rotate(Vector3.Y, INITIAL_CAMERA_ANGLE_AROUND_Y);
	}
}
