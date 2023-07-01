package com.gadarts.industrial.shared.assets.declarations;

import com.gadarts.industrial.shared.assets.definitions.ModelDefinition;
import com.gadarts.industrial.shared.assets.declarations.ModelElementDeclaration;
import com.gadarts.industrial.shared.model.RelativeBillboard;
import com.gadarts.industrial.shared.model.env.EnvironmentObjectType;
import com.gadarts.industrial.shared.model.env.light.LightEmission;
import com.gadarts.industrial.shared.model.map.MapNodesTypes;

public interface EnvironmentObjectDeclaration extends ModelElementDeclaration {
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
