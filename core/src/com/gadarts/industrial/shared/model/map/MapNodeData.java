package com.gadarts.industrial.shared.model.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.math.Vector3;
import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.model.Coords;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import static com.badlogic.gdx.math.Matrix4.M13;

@Getter
@Setter
public class MapNodeData {

	private final static Vector3 auxVector = new Vector3();

	@Setter(AccessLevel.NONE)
	private Coords coords;

	@Setter(AccessLevel.NONE)
	private NodeWalls walls = new NodeWalls();

	private ModelInstance modelInstance;
	private MapNodesTypes mapNodeType;
	private Assets.SurfaceTextures textureDefinition;
	private float height;

	public MapNodeData(final int row, final int col, final MapNodesTypes type) {
		this(null, row, col, type);
	}

	public MapNodeData(final Model tileModel, final int row, final int col, final MapNodesTypes type) {
		initializeFields(row, col, type);
		if (tileModel != null) {
			initializeModelInstance(tileModel);
		}
	}

	public Assets.SurfaceTextures getTextureDefinition( ) {
		return textureDefinition;
	}

	private void initializeFields(final int row, final int col, final MapNodesTypes type) {
		this.mapNodeType = type;
		this.coords = new Coords(row, col);
	}

	public void initializeModelInstance(final Model tileModel) {
		this.modelInstance = new ModelInstance(tileModel);
		Material material = modelInstance.materials.get(0);
		material.remove(ColorAttribute.Diffuse);
		material.set(TextureAttribute.createDiffuse((Texture) null));
		modelInstance.transform.setTranslation(coords.col(), 0, coords.row());
	}

	public void lift(final float delta) {
		height += delta;
		if (modelInstance != null) {
			modelInstance.transform.translate(0, delta, 0);
		}
	}

	public void applyHeight(final float fixed) {
		height = fixed;
		if (modelInstance != null) {
			modelInstance.transform.val[M13] = fixed;
		}
	}

	public boolean equals(final int row, final int col) {
		return coords.equals(row, col);
	}

	public float getHeight( ) {
		return height;
	}
}
