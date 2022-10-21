package com.gadarts.industrial.shared;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import com.gadarts.industrial.shared.assets.GameAssetsManager;
import com.gadarts.industrial.shared.model.Coords;
import com.gadarts.industrial.shared.model.map.MapNodeData;
import com.gadarts.industrial.shared.model.map.NodeWalls;
import com.gadarts.industrial.shared.model.map.Wall;
import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;

import java.util.Optional;

/**
 * A tool to generate walls for nodes.
 */
public class WallCreator implements Disposable {
	public static final int WORLD_UNIT_SIZE = 32;
	private static final Vector3 auxVector3_1 = new Vector3();
	private static final Vector3 auxVector3_2 = new Vector3();
	private final GameAssetsManager assetsManager;

	@Getter
	private Model wallModel;

	public WallCreator(final GameAssetsManager assetsManager) {
		this.assetsManager = assetsManager;
		createWallModel();
	}

	/**
	 * Creates a western wall model for a given node.
	 *
	 * @param n             The target node.
	 * @param wallModel     The wall model used for creating the model instance.
	 * @param assetsManager Used to get the texture.
	 * @param definition    The texture definition for the wall.
	 */
	public static Wall createWestWall(final MapNodeData n,
									  final Model wallModel,
									  final GameAssetsManager assetsManager,
									  final Assets.SurfaceTextures definition) {
		Wall westWall = createWall(wallModel, assetsManager, definition);
		ModelInstance modelInstance = westWall.getModelInstance();
		Coords coords = n.getCoords();
		modelInstance.transform.setToTranslation(coords.getCol(), 0, coords.getRow());
		return westWall;
	}

	/**
	 * Creates a southern wall model for a given node.
	 *
	 * @param n             The target node.
	 * @param wallModel     The wall model used for creating the model instance.
	 * @param assetsManager Used to get the texture.
	 * @param definition    The texture definition for the wall.
	 */
	public static Wall createSouthWall(final MapNodeData n,
									   final Model wallModel,
									   final GameAssetsManager assetsManager,
									   final Assets.SurfaceTextures definition) {
		Wall southWall = createWall(wallModel, assetsManager, definition);
		ModelInstance modelInstance = southWall.getModelInstance();
		Coords coords = n.getCoords();
		modelInstance.transform.setToTranslation(coords.getCol(), 0, coords.getRow() + 1);
		modelInstance.transform.rotate(Vector3.X, 90);
		return southWall;
	}

	/**
	 * Creates an eastern wall model for a given node.
	 *
	 * @param n             The target node.
	 * @param wallModel     The wall model used for creating the model instance.
	 * @param assetsManager Used to get the texture.
	 * @param definition    The texture definition for the wall.
	 */
	public static Wall createEastWall(final MapNodeData n,
									  final Model wallModel,
									  final GameAssetsManager assetsManager,
									  final Assets.SurfaceTextures definition) {
		Wall eastWall = createWall(wallModel, assetsManager, definition);
		ModelInstance modelInstance = eastWall.getModelInstance();
		Coords coords = n.getCoords();
		modelInstance.transform.setToTranslation(coords.getCol() + 1F, 0, coords.getRow());
		return eastWall;
	}

	/**
	 * Creates a northern wall model for a given node.
	 *
	 * @param n             The target node.
	 * @param wallModel     The wall model used for creating the model instance.
	 * @param assetsManager Used to get the texture.
	 * @param definition    The texture definition for the wall.
	 */
	public static Wall createNorthWall(final MapNodeData n,
									   final Model wallModel,
									   final GameAssetsManager assetsManager,
									   final Assets.SurfaceTextures definition) {
		Wall northWall = createWall(wallModel, assetsManager, definition);
		ModelInstance modelInstance = northWall.getModelInstance();
		Coords coords = n.getCoords();
		modelInstance.transform.setToTranslation(coords.getCol(), 0, coords.getRow());
		return northWall;
	}

	/**
	 * Creates a wall model.
	 *
	 * @param wallModel     The wall model used for creating the model instance.
	 * @param assetsManager Used to get the texture.
	 * @param definition    The texture definition for the wall.
	 * @return The new wall.
	 */
	public static Wall createWall(final Model wallModel,
								  final GameAssetsManager assetsManager,
								  final Assets.SurfaceTextures definition) {
		ModelInstance modelInstance = new ModelInstance(wallModel);
		TextureAttribute textureAttribute = (TextureAttribute) modelInstance.materials.get(0).get(TextureAttribute.Diffuse);
		textureAttribute.textureDescription.texture = assetsManager.getTexture(definition);
		return new Wall(modelInstance, definition);
	}

	/**
	 * Adjusts the wall's attributes between a northern and southern node.
	 *
	 * @param southernN
	 * @param northernN
	 */
	@SuppressWarnings("JavaDoc")
	public static void adjustWallBetweenNorthAndSouth(final MapNodeData southernN,
													  final MapNodeData northernN) {
		adjustWallBetweenNorthAndSouth(southernN, northernN, 0, 0, 0);
	}

	/**
	 * Adjusts the wall's attributes between a northern and southern node.
	 *
	 * @param southernN
	 * @param northernN
	 */
	@SuppressWarnings("JavaDoc")
	public static void adjustWallBetweenNorthAndSouth(final MapNodeData southernN,
													  final MapNodeData northernN,
													  final float vScale,
													  final float hOffset,
													  final float vOffset) {
		NodeWalls southernWalls = southernN.getWalls();
		Wall wallBetween = Optional.ofNullable(southernWalls.getNorthWall()).orElse(northernN.getWalls().getSouthWall());
		ModelInstance modelInstance = wallBetween.getModelInstance();
		TextureAttribute textureAtt = (TextureAttribute) modelInstance.materials.get(0).get(TextureAttribute.Diffuse);
		int textureHeight = textureAtt.textureDescription.texture.getHeight() / WORLD_UNIT_SIZE;
		textureAtt.scaleV = adjustWallBetweenTwoNodes(southernN, northernN, wallBetween, textureHeight);
		textureAtt.scaleV = vScale != 0 ? vScale : textureAtt.scaleV;
		textureAtt.offsetU = hOffset;
		textureAtt.offsetV = vOffset;
		if (southernN.getHeight() > northernN.getHeight()) {
			textureAtt.scaleV *= -1;
			textureAtt.scaleU *= -1;
		}
		modelInstance.transform.rotate(Vector3.X, (southernN.getHeight() > northernN.getHeight() ? -1 : 1) * 90F);
	}

	/**
	 * Adjusts the wall's attributes between an eastern and western node.
	 *
	 * @param eastNode
	 * @param westNode
	 */
	public static void adjustWallBetweenEastAndWest(final MapNodeData eastNode,
													final MapNodeData westNode) {
		adjustWallBetweenEastAndWest(eastNode, westNode, 0, 0, 0);
	}

	/**
	 * Adjusts the wall's attributes between a eastern and western node.
	 *
	 * @param eastNode
	 * @param westNode
	 * @param vScale
	 * @param hOffset
	 * @param vOffset
	 */
	@SuppressWarnings("JavaDoc")
	public static void adjustWallBetweenEastAndWest(final MapNodeData eastNode,
													final MapNodeData westNode,
													final float vScale,
													final float hOffset,
													final float vOffset) {
		Wall wallBetween = Optional.ofNullable(eastNode.getWalls().getWestWall()).orElse(westNode.getWalls().getEastWall());
		ModelInstance modelInstance = wallBetween.getModelInstance();
		TextureAttribute textureAtt = (TextureAttribute) modelInstance.materials.get(0).get(TextureAttribute.Diffuse);
		int textureHeight = textureAtt.textureDescription.texture.getHeight() / WORLD_UNIT_SIZE;
		textureAtt.scaleV = adjustWallBetweenTwoNodes(eastNode, westNode, wallBetween, textureHeight);
		textureAtt.scaleV = vScale != 0 ? vScale : textureAtt.scaleV;
		textureAtt.offsetU = hOffset;
		textureAtt.offsetV = vOffset;
		boolean eastHigherThanWest = eastNode.getHeight() > westNode.getHeight();
		modelInstance.transform.getTranslation(auxVector3_1).z = eastNode.getCoords().getRow();
		modelInstance.transform.getScale(auxVector3_2);
		modelInstance.transform.setToTranslationAndScaling(auxVector3_1, auxVector3_2);
		modelInstance.transform.rotate(Vector3.Y, (eastHigherThanWest ? -1 : 1) * 90F);
		modelInstance.transform.rotate(Vector3.X, 90F);
		if (eastHigherThanWest) {
			modelInstance.transform.translate(0F, 0F, -1F);
		} else {
			modelInstance.transform.translate(-1F, 0F, 0F);
		}
	}

	private static float adjustWallBetweenTwoNodes(final MapNodeData eastOrSouthNode,
												   final MapNodeData westOrNorthNode,
												   final Wall wallBetween, int textureHeight) {
		Vector3 wallBetweenThemPos = wallBetween.getModelInstance().transform.getTranslation(auxVector3_1);
		float eastOrSouthHeight = eastOrSouthNode.getHeight();
		float westOrNorthHeight = westOrNorthNode.getHeight();
		float sizeHeight = Math.abs(westOrNorthHeight - eastOrSouthHeight);
		float y = Math.min(eastOrSouthHeight, westOrNorthHeight) + (eastOrSouthHeight > westOrNorthHeight ? 0 : sizeHeight);
		wallBetween.getModelInstance().transform.setToTranslationAndScaling(wallBetweenThemPos.x, y, wallBetweenThemPos.z,
				1, sizeHeight, 1);
		return sizeHeight / textureHeight;
	}

	private void createWallModel( ) {
		ModelBuilder modelBuilder = new ModelBuilder();
		wallModel = modelBuilder.createRect(
				0, 0, 1,
				1, 0, 1,
				1, 0, 0,
				0, 0, 0,
				0, 1, 0,
				new Material(TextureAttribute.createDiffuse((Texture) null)),
				Usage.Position | Usage.Normal | Usage.TextureCoordinates);
	}

	/**
	 * Creates a wall between the two nodes if missing and adjusts it.
	 *
	 * @param southernNode
	 * @param northernNode
	 */
	@SuppressWarnings("JavaDoc")
	public void adjustNorthWall(final MapNodeData southernNode,
								final MapNodeData northernNode) {
		if (northernNode.getHeight() != southernNode.getHeight()) {
			if (northernNode.getWalls().getSouthWall() == null && southernNode.getWalls().getNorthWall() == null) {
				southernNode.getWalls().setNorthWall(createNorthWall(southernNode, wallModel, assetsManager, Assets.SurfaceTextures.MISSING));
			}
			adjustWallBetweenNorthAndSouth(southernNode, northernNode);
		} else {
			clearWallBetweenNorthAndSouthNodes(northernNode, southernNode);
		}
	}

	/**
	 * Creates a wall between the two nodes if missing and adjusts it.
	 *
	 * @param northernNode
	 * @param southernNode
	 */
	@SuppressWarnings("JavaDoc")
	public void adjustSouthWall(final MapNodeData northernNode,
								final MapNodeData southernNode) {
		if (northernNode.getHeight() != southernNode.getHeight()) {
			if (southernNode.getWalls().getNorthWall() == null && northernNode.getWalls().getSouthWall() == null) {
				northernNode.getWalls().setSouthWall(createSouthWall(northernNode, wallModel, assetsManager, Assets.SurfaceTextures.MISSING));
			}
			adjustWallBetweenNorthAndSouth(southernNode, northernNode, 0, 0, 0);
		} else {
			clearWallBetweenNorthAndSouthNodes(northernNode, southernNode);
		}
	}

	/**
	 * Creates a wall between the two nodes if missing and adjusts it.
	 *
	 * @param westernNode
	 * @param easternNode
	 */
	@SuppressWarnings("JavaDoc")
	public void adjustEastWall(final MapNodeData westernNode,
							   final MapNodeData easternNode) {
		if (easternNode.getHeight() != westernNode.getHeight()) {
			if (westernNode.getWalls().getEastWall() == null && easternNode.getWalls().getWestWall() == null) {
				westernNode.getWalls().setEastWall(createEastWall(westernNode, wallModel, assetsManager, Assets.SurfaceTextures.MISSING));
			}
			adjustWallBetweenEastAndWest(easternNode, westernNode, 0, 0, 0);
		} else {
			clearWallBetweenWestAndEastNodes(westernNode, easternNode);
		}
	}

	private void clearWallBetweenWestAndEastNodes(MapNodeData westernNode, MapNodeData easternNode) {
		easternNode.getWalls().setWestWall(null);
		westernNode.getWalls().setEastWall(null);
	}

	private void clearWallBetweenNorthAndSouthNodes(MapNodeData northernNode, MapNodeData southernNode) {
		southernNode.getWalls().setNorthWall(null);
		northernNode.getWalls().setSouthWall(null);
	}

	/**
	 * Creates a wall between the two nodes if missing and adjusts it.
	 *
	 * @param easternNode
	 * @param westernNode
	 */
	@SuppressWarnings("JavaDoc")
	public void adjustWestWall(final MapNodeData easternNode, final MapNodeData westernNode) {
		if (easternNode.getHeight() != westernNode.getHeight()) {
			if (westernNode.getWalls().getEastWall() == null && easternNode.getWalls().getWestWall() == null) {
				easternNode.getWalls().setWestWall(createWestWall(easternNode, wallModel, assetsManager, Assets.SurfaceTextures.MISSING));
			}
			adjustWallBetweenEastAndWest(easternNode, westernNode, 0, 0, 0);
		} else {
			clearWallBetweenWestAndEastNodes(westernNode, easternNode);
		}
	}

	@Override
	public void dispose( ) {
		wallModel.dispose();
	}
}
