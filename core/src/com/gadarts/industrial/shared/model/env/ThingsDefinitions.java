package com.gadarts.industrial.shared.model.env;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
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
public enum ThingsDefinitions implements EnvironmentObjectDefinition {
	WALL_SUPPORTER_1(new Vector3(-0.5F, 0F, 0.5F), Assets.Models.WALL_SUPPORTER_1, 1, 1, "Wall Supporter #1"),
	WALL_SUPPORTER_2(new Vector3(-0.5F, 0F, 0.5F), Assets.Models.WALL_SUPPORTER_2, 1, 1, "Wall Supporter #2"),
	WALL_SUPPORTER_3(new Vector3(-0.5F, 0F, 0.5F), Assets.Models.WALL_SUPPORTER_3, 1, 1, "Wall Supporter #3"),
	WALL_SUPPORTER_HIGH(new Vector3(-0.5F, 0F, 0.5F), Assets.Models.WALL_SUPPORTER_HIGH, 1, 1, "High Wall Supporter"),
	COMPUTER_WAGON(Assets.Models.COMPUTER_WAGON, 1, 1, "Computer Wagon", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN),
	CRATE_BIG_0(Assets.Models.CRATE_BIG_0, 1, 1, "Big Crate #1", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN, 0.9F),
	CRATE_BIG_1(Assets.Models.CRATE_BIG_1, 1, 1, "Big Crate #2", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN, 0.9F),
	CRATE_BIG_2(Assets.Models.CRATE_BIG_2, 1, 1, "Big Crate #3", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN, 0.9F),
	CRATE_SMALL(Assets.Models.CRATE_SMALL, 1, 1, "Small Crate", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED);

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
	private final float height;

	ThingsDefinitions(Assets.Models model,
					  int width,
					  int depth,
					  String displayName,
					  MapNodesTypes nodeType) {
		this(Vector3.Zero,
				model,
				width,
				depth,
				displayName,
				true,
				nodeType,
				null,
				null,
				0F);
	}

	ThingsDefinitions(Assets.Models model,
					  int width,
					  int depth,
					  String displayName,
					  MapNodesTypes nodeType,
					  float height) {
		this(Vector3.Zero,
				model,
				width,
				depth,
				displayName,
				true,
				nodeType,
				null,
				null,
				height);
	}

	ThingsDefinitions(Vector3 offset, Assets.Models model, int width, int depth, String displayName) {
		this(
				offset,
				model,
				width,
				depth,
				displayName,
				true,
				MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED,
				null,
				null,
				0F);
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
	public static void handleEvenSize(final ThingsDefinitions definition,
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

	@Override
	public EnvironmentObjectType getEnvironmentObjectType( ) {
		return EnvironmentObjectType.THING;
	}

	@Override
	public ModelDefinition getAppendixModelDefinition( ) {
		return null;
	}
}
