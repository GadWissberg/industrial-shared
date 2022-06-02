package com.gadarts.industrial.shared.model.env;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.model.ModelElementDefinition;
import com.gadarts.industrial.shared.model.RelativeBillboard;
import com.gadarts.industrial.shared.model.characters.Direction;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;
import com.gadarts.industrial.shared.assets.Assets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Definitions of misc objects.
 */
@Getter
@RequiredArgsConstructor
public enum EnvironmentDefinitions implements ModelElementDefinition {
	WALL_SUPPORTER_1(Assets.Models.WALL_SUPPORTER_1, 1, 1, "Wall Supporter 1", new Vector3(-0.5F, 0F, 0.5F)),

	WALL_SUPPORTER_2(Assets.Models.WALL_SUPPORTER_2, 1, 1, "Wall Supporter 2", new Vector3(-0.5F, 0F, 0.5F)),

	WALL_SUPPORTER_3(Assets.Models.WALL_SUPPORTER_3, 1, 1, "Wall Supporter 3", new Vector3(-0.5F, 0F, 0.5F));

	@Getter(AccessLevel.NONE)
	private final Vector3 offset;

	@Getter(AccessLevel.NONE)
	private final Assets.Models model;

	private final int width;
	private final int depth;
	private final String displayName;
	private final boolean castShadow;
	private final MapNodesTypes nodeType;
	private final LightEmission lightEmission;
	private final RelativeBillboard relativeBillboard;

	EnvironmentDefinitions(Assets.Models model,
						   int width,
						   int depth,
						   String displayName) {
		this(
				model,
				width,
				depth,
				displayName,
				true,
				Vector3.Zero,
				MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED,
				null,
				null);
	}

	EnvironmentDefinitions(Assets.Models model, int width, int depth, String displayName, Vector3 offset) {
		this(
				model,
				width,
				depth,
				displayName,
				true,
				offset,
				MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED,
				null,
				null);
	}

	EnvironmentDefinitions(final Assets.Models model,
						   final int width,
						   final int depth,
						   final String displayName,
						   final boolean castShadow,
						   final Vector3 offset,
						   final MapNodesTypes nodeType,
						   final LightEmission lightEmission,
						   final RelativeBillboard relativeBillboard) {
		this.model = model;
		this.width = width;
		this.depth = depth;
		this.displayName = displayName;
		this.castShadow = castShadow;
		this.offset = offset;
		this.nodeType = nodeType;
		this.lightEmission = lightEmission;
		this.relativeBillboard = relativeBillboard;
	}

	public Vector3 getOffset(final Vector3 output) {
		return output.set(offset);
	}

	@Override
	public String getDisplayName( ) {
		return displayName;
	}

	@Override
	public Assets.Models getModelDefinition( ) {
		return model;
	}

	/**
	 * When objects have even width or depth, this method will correct their position.
	 *
	 * @param definition      The definition of the misc object.
	 * @param modelInstance   The model of the misc object.
	 * @param facingDirection The facing direction of the misc object.
	 */
	public static void handleEvenSize(final EnvironmentDefinitions definition,
									  final ModelInstance modelInstance,
									  final Direction facingDirection) {
		boolean handleEvenSize = facingDirection == Direction.EAST || facingDirection == Direction.NORTH;
		if (definition.getWidth() % 2 == 0) {
			modelInstance.transform.translate(0.5f * (handleEvenSize ? -1 : 1), 0, 0);
		}
		if (definition.getDepth() % 2 == 0) {
			modelInstance.transform.translate(0, 0, 0.5f * (handleEvenSize ? -1 : 1));
		}
	}
}
