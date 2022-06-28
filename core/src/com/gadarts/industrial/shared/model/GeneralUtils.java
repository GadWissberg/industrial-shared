package com.gadarts.industrial.shared.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.gadarts.industrial.shared.assets.GameAssetsManager;
import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;

import java.util.Optional;

public final class GeneralUtils {
	private static final Plane groundPlane = new Plane(new Vector3(0, 1, 0), 0);

	public static Vector3 defineRotationPoint(final Vector3 output, final Camera camera) {
		return defineRotationPoint(output, camera, 0F);
	}

	public static Vector3 defineRotationPoint(Vector3 output, Camera camera, float planeHeight) {
		Ray ray = camera.getPickRay(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
		groundPlane.d = planeHeight;
		Intersector.intersectRayPlane(ray, groundPlane, output);
		return output;
	}

	public static void applyExplicitModelTexture(ModelDefinition modelDefinition,
												 ModelInstance modelInstance,
												 GameAssetsManager assetsManager) {
		Optional.ofNullable(modelDefinition.getTextureFileName()).ifPresent(t -> {
			for (Material material : modelInstance.materials) {
				if (material.has(TextureAttribute.Diffuse)) {
					TextureAttribute attribute = (TextureAttribute) material.get(TextureAttribute.Diffuse);
					attribute.textureDescription.texture = assetsManager.getModelExplicitTexture(modelDefinition);
				}
			}
		});
	}
}
