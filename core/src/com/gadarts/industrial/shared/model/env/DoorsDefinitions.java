package com.gadarts.industrial.shared.model.env;

import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.Assets.Models;
import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
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
	INDUSTRIAL_DOOR(Models.INDUSTRY_DOOR_0, Models.DOOR_FRAME_WARNING, "Industrial Door");


	private final Models modelDefinition;
	private final Models frameModelDefinition;
	private final String displayName;

	@Override
	public String getDisplayName( ) {
		return displayName;
	}

	@Override
	public Models getModelDefinition( ) {
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
	public ModelDefinition getAppendixModelDefinition( ) {
		return frameModelDefinition;
	}

	@Override
	public MapNodesTypes getNodeType( ) {
		return MapNodesTypes.PASSABLE_NODE;
	}
}
