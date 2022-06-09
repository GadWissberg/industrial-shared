package com.gadarts.industrial.shared.model.env;

import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
import com.gadarts.industrial.shared.model.ModelElementDefinition;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;

public interface EnvironmentObjectDefinition extends ModelElementDefinition {
	EnvironmentObjectType getEnvironmentObjectType( );

	ModelDefinition getAppendixModelDefinition( );

	MapNodesTypes getNodeType( );
}
