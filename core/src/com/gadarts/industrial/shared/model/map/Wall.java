package com.gadarts.industrial.shared.model.map;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.gadarts.industrial.shared.assets.Assets;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wall {

	@Setter(AccessLevel.NONE)
	private final ModelInstance modelInstance;
	private Assets.SurfaceTextures definition;
	private Float vScale;
	private Float hOffset;
	private Float vOffset;

	public Wall(ModelInstance modelInstance, Assets.SurfaceTextures definition) {
		this.modelInstance = modelInstance;
		this.definition = definition;
	}
}

