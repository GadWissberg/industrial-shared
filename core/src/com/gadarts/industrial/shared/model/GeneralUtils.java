package com.gadarts.industrial.shared.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public final class GeneralUtils {
	private static final Plane groundPlane = new Plane(new Vector3(0, 1, 0), 0);

	public static Vector3 defineRotationPoint(final Vector3 output, final Camera camera) {
		Ray ray = camera.getPickRay(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
		Intersector.intersectRayPlane(ray, groundPlane, output);
		return output;
	}
}
