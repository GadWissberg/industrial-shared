package com.gadarts.industrial.shared.assets.declarations;

import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets;

public interface ModelElementDeclaration extends ElementDeclaration {
	Assets.Models getModelDefinition( );

	default int getWidth( ) {
		return 1;
	}

	default int getDepth( ) {
		return 1;
	}

	default Vector3 getOffset(Vector3 output) {
		return output.setZero();
	}
}
