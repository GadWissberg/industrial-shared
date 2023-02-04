package com.gadarts.industrial.shared.model.env;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets.Models;
import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
import com.gadarts.industrial.shared.model.RelativeBillboard;
import com.gadarts.industrial.shared.model.characters.Direction;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Definitions of misc objects.
 */
@Getter
@RequiredArgsConstructor
public enum ThingsDefinitions implements EnvironmentObjectDeclaration {
	WALL_SUPPORTER_1(new Vector3(-0.5F, 0F, 0.5F), Models.WALL_SUPPORTER_1, 1, 1, "Wall Supporter #1", MapNodesTypes.PASSABLE_NODE),
	WALL_SUPPORTER_2(new Vector3(-0.5F, 0F, 0.5F), Models.WALL_SUPPORTER_2, 1, 1, "Wall Supporter #2", MapNodesTypes.PASSABLE_NODE),
	WALL_SUPPORTER_3(new Vector3(-0.5F, 0F, 0.5F), Models.WALL_SUPPORTER_3, 1, 1, "Wall Supporter #3", MapNodesTypes.PASSABLE_NODE),
	WALL_SUPPORTER_HIGH(new Vector3(-0.5F, 0F, 0.5F), Models.WALL_SUPPORTER_HIGH, 1, 1, "High Wall Supporter", MapNodesTypes.PASSABLE_NODE),
	COMPUTER_WAGON(Models.COMPUTER_WAGON, 1, 1, "Computer Wagon", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN),
	CRATE_BIG_0(Models.CRATE_BIG_0, 1, 1, "Big Crate #1", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN, 0.9F),
	CRATE_BIG_1(Models.CRATE_BIG_1, 1, 1, "Big Crate #2", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN, 0.9F),
	CRATE_BIG_2(Models.CRATE_BIG_2, 1, 1, "Big Crate #3", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN, 0.9F),
	CRATE_SMALL(Models.CRATE_SMALL, 1, 1, "Small Crate", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	OFFICE_DESK(Models.OFFICE_DESK, 1, 1, "Office Desk #1", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	OFFICE_DESK_DRAWERS(Models.OFFICE_DESK_DRAWERS, 1, 1, "Office Desk #2", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	OFFICE_DESK_LIGHT(Models.OFFICE_DESK_LIGHT, 1, 1, "Office Desk #3", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	RUINS_0(Models.RUINS_0, 1, 1, "Ruins #1", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN),
	RUINS_1(Models.RUINS_1, 1, 1, "Ruins #2", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN),
	MONITOR(new Vector3(-0.2F, 0F, 0F), Models.MONITOR, 1, 1, "PC Monitor", MapNodesTypes.PASSABLE_NODE),
	KEYBOARD(new Vector3(0.2F, 0F, 0F), Models.KEYBOARD, 1, 1, "Keyboard", MapNodesTypes.PASSABLE_NODE),
	PC(Models.PC, 1, 1, "PC", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	EXIT_SIGN(new Vector3(-0.5F, 2F, 0F), Models.EXIT_SIGN, 1, 1, "Exit", MapNodesTypes.PASSABLE_NODE, new LightEmission(new Vector3(-0.4F, 2F, 0F), 1F, 1F, false, Color.RED)),
	EDGE_SAFETY_0(new Vector3(0.4F, 0F, 0F), Models.EDGE_SAFETY_0, 1, 1, "Edge Safety", MapNodesTypes.PASSABLE_NODE),
	EDGE_SAFETY_1(new Vector3(0.4F, 0F, 0F), Models.EDGE_SAFETY_1, 1, 1, "Warning Edge Safety", MapNodesTypes.PASSABLE_NODE),
	EDGE_SAFETY_BROKEN(new Vector3(0.4F, 0F, 0F), Models.EDGE_SAFETY_BROKEN, 1, 1, "Broken Edge Safety", MapNodesTypes.PASSABLE_NODE),
	ELECTRIC_BOX_0(new Vector3(-0.45F, 0F, 0F), Models.ELECTRIC_BOX_0, 1, 1, "Electric Box #1", MapNodesTypes.PASSABLE_NODE),
	ELECTRIC_BOX_1(new Vector3(-0.45F, 0F, 0F), Models.ELECTRIC_BOX_1, 1, 1, "Electric Box #2", MapNodesTypes.PASSABLE_NODE),
	SMALL_ELECTRIC_BOX_0(new Vector3(-0.4F, 0F, 0F), Models.SMALL_ELECTRIC_BOX_0, 1, 1, "Small Electric Box #1", MapNodesTypes.PASSABLE_NODE),
	SMALL_ELECTRIC_BOX_1(new Vector3(-0.4F, 0F, 0F), Models.SMALL_ELECTRIC_BOX_1, 1, 1, "Small Electric Box #2", MapNodesTypes.PASSABLE_NODE),
	ELECTRIC_CLOSET_0(Models.ELECTRIC_CLOSET_0, 1, 1, "Electric Closet #1", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN),
	ELECTRIC_CLOSET_1(Models.ELECTRIC_CLOSET_1, 1, 1, "Electric Closet #2", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_FORBIDDEN),
	OFFICE_CHAIR_0(Models.OFFICE_CHAIR_0, 1, 1, "Office Chair #1", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	OFFICE_CHAIR_1(Models.OFFICE_CHAIR_1, 1, 1, "Office Chair #2", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	SINK_0(new Vector3(-0.5F, 0.7F, 0F), Models.SINK_0, 1, 1, "Sink #1", MapNodesTypes.PASSABLE_NODE),
	SINK_1(new Vector3(-0.5F, 0.7F, 0F), Models.SINK_1, 1, 1, "Sink #2", MapNodesTypes.PASSABLE_NODE),
	TRASH_CAN(Models.TRASH_CAN, 1, 1, "Trash-Can", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED),
	TOILET(Models.TOILET, 1, 1, "Toilet", MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED);

	@Getter(AccessLevel.NONE)
	private final Vector3 offset;

	@Getter(AccessLevel.NONE)
	private final Models model;

	private final int width;
	private final int depth;
	private final String displayName;
	private final boolean castShadow;
	private final MapNodesTypes nodeType;
	private final LightEmission lightEmission;
	private final RelativeBillboard relativeBillboard;
	private final float height;

	ThingsDefinitions(Models model,
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

	ThingsDefinitions(Models model,
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

	ThingsDefinitions(Vector3 offset,
					  Models model,
					  int width, int depth,
					  String displayName,
					  MapNodesTypes nodeType) {
		this(
				offset,
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

	ThingsDefinitions(Vector3 offset,
					  Models model,
					  int width, int depth,
					  String displayName,
					  MapNodesTypes nodeType,
					  LightEmission lightEmission) {
		this(
				offset,
				model,
				width,
				depth,
				displayName,
				true,
				nodeType,
				lightEmission,
				null,
				0F);
	}

	/**
	 * When objects have even width or depth, this method will correct their position.
	 *
	 * @param definition      The declaration of the misc object.
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

	public Vector3 getOffset(final Vector3 output) {
		return output.set(offset);
	}

	@Override
	public String displayName( ) {
		return displayName;
	}

	@Override
	public Models getModelDefinition( ) {
		return model;
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
