package com.gadarts.industrial.shared.model.env.door;

import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets.Models;
import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
import com.gadarts.industrial.shared.model.env.EnvironmentObjectDeclaration;
import com.gadarts.industrial.shared.model.env.EnvironmentObjectType;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.gadarts.industrial.shared.model.env.EnvironmentObjectType.DOOR;

/**
 * Definitions of doors objects.
 */
@Getter
@RequiredArgsConstructor
public enum DoorsDefinitions implements EnvironmentObjectDeclaration {
	AUTO_DOOR(Models.AUTO_DOOR_0, Models.DOOR_FRAME_WARNING, "Auto Door", DoorTypes.SLIDE, new Vector3(0F, -0.01F, 0F)),
	INDUSTRIAL_DOOR_0(Models.INDUSTRIAL_DOOR_0, Models.INDUSTRIAL_DOOR_FRAME, "Door", DoorTypes.ROTATE, new Vector3(0F, 0F, 0.5F)),
	INDUSTRIAL_DOOR_1(Models.INDUSTRIAL_DOOR_1, Models.INDUSTRIAL_DOOR_FRAME, "Door with Vent", DoorTypes.ROTATE, new Vector3(0F, 0F, 0.5F)),
	INDUSTRIAL_DOOR_2(Models.INDUSTRIAL_DOOR_2, Models.INDUSTRIAL_DOOR_FRAME, "WC Door", DoorTypes.ROTATE, new Vector3(0F, 0F, 0.5F));


	private final Models doorModelDefinition;
	private final Models frameModelDefinition;
	private final String displayName;
	private final DoorTypes type;
	private final Vector3 offset;

	@Override
	public String displayName( ) {
		return displayName;
	}

	@Override
	public String id( ) {
		return name();
	}

	public Models getModelDefinition( ) {
		return frameModelDefinition;
	}

	@Override
	public Vector3 getOffset(Vector3 output) {
		return output.set(offset);
	}

	@Override
	public EnvironmentObjectType getEnvironmentObjectType( ) {
		return DOOR;
	}

	@Override
	public ModelDefinition getAppendixModelDefinition( ) {
		return doorModelDefinition;
	}

	@Override
	public MapNodesTypes getNodeType( ) {
		return MapNodesTypes.PASSABLE_NODE;
	}
}
