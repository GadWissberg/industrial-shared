package com.gadarts.industrial.shared.model.env;

import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.gadarts.industrial.shared.model.env.EnvironmentObjectType.DOOR;

/**
 * Definitions of doors objects.
 */
@Getter
@RequiredArgsConstructor
public enum DoorsDefinitions implements EnvironmentObjectDefinition {
	INDUSTRIAL_DOOR(Assets.Models.INDUSTRY_DOOR_0, Assets.Models.DOOR_FRAME_WARNING, "Industrial Door");


	private final Assets.Models modelDefinition;
	@Getter(AccessLevel.NONE)
	private final Assets.Models frameModelDefinition;
	private final String displayName;

	@Override
	public String getDisplayName( ) {
		return displayName;
	}

	@Override
	public Assets.Models getModelDefinition( ) {
		return modelDefinition;
	}

	@Override
	public int getWidth( ) {
		return 1;
	}

	@Override
	public int getDepth( ) {
		return 1;
	}

	@Override
	public Vector3 getOffset(Vector3 output) {
		return output.setZero();
	}

	@Override
	public EnvironmentObjectType getEnvironmentObjectType( ) {
		return DOOR;
	}

	@Override
	public MapNodesTypes getNodeType( ) {
		return MapNodesTypes.OBSTACLE_KEY_DIAGONAL_ALLOWED;
	}
}
