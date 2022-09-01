package com.gadarts.industrial.shared.model.env;

import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
import com.gadarts.industrial.shared.model.ModelElementDefinition;
import com.gadarts.industrial.shared.model.RelativeBillboard;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;

public interface EnvironmentObjectDefinition extends ModelElementDefinition {
	EnvironmentObjectType getEnvironmentObjectType( );

	default RelativeBillboard getRelativeBillboard( ) {
		return null;
	}

	default LightEmission getLightEmission( ) {
		return null;
	}

	ModelDefinition getAppendixModelDefinition( );

	default boolean isCastShadow( ) {
		return true;
	}

	default float getHeight( ) {
		return 0;
	}

	MapNodesTypes getNodeType( );
}
