package com.gadarts.industrial.shared.model;

import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets;

public interface ModelElementDefinition extends ElementDefinition {
	Assets.Models getModelDefinition( );

	int getWidth( );

	int getDepth( );

	default Vector3 getOffset(Vector3 output) {
		return output;
	}
}
