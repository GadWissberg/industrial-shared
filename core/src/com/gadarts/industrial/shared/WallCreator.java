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
import com.gadarts.industrial.shared.assets.Assets.SurfaceTextures;
import com.gadarts.industrial.shared.assets.GameAssetsManager;
import com.gadarts.industrial.shared.model.Coords;
import com.gadarts.industrial.shared.model.map.MapNodeData;
import com.gadarts.industrial.shared.model.map.NodeWalls;
import com.gadarts.industrial.shared.model.map.Wall;
import lombok.Getter;

import java.util.Optional;

import static com.gadarts.industrial.shared.assets.Assets.SurfaceTextures.MISSING;

/**
 * A tool to generate walls for nodes.
 */
public class WallCreator implements Disposable {
	public static final int WORLD_UNIT_SIZE = 64;
	private static final Vector3 auxVector3_1 = new Vector3();
	private static final Vector3 auxVector3_2 = new Vector3();
	private final GameAssetsManager assetsManager;

	@Getter
	private Model eastWallModel, southWallModel, northWallModel, westWallModel;

	public WallCreator(final GameAssetsManager assetsManager) {
		this.assetsManager = assetsManager;
		createWestWallModel();
		createSouthWallModel();
		createNorthWallModel();
		createEastWallModel();
	}


	/**
	 * Creates a wall model instance for a given node.
	 *
	 * @param n             The target node.
	 * @param wallModel     The wall model used for creating the model instance.
	 * @param assetsManager Used to get the texture.
	 * @param definition    The texture definition for the wall.
	 */
	public static Wall createWall(final MapNodeData n,
								  final Model wallModel,
								  final GameAssetsManager assetsManager,
								  final SurfaceTextures definition) {
		ModelInstance modelInstance = new ModelInstance(wallModel);
		TextureAttribute textureAttr = (TextureAttribute) modelInstance.materials.get(0).get(TextureAttribute.Diffuse);
		textureAttr.textureDescription.texture = assetsManager.getTexture(definition);
		Wall northWall = new Wall(modelInstance, definition);
		Coords coords = n.getCoords();
		modelInstance.transform.setToTranslation(coords.getCol(), 0, coords.getRow());
		return northWall;
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
		textureAtt.offsetV = (1F - textureAtt.scaleV) + vOffset;
		modelInstance.transform.getTranslation(auxVector3_1).z = eastNode.getCoords().getRow();
		modelInstance.transform.getScale(auxVector3_2);
		modelInstance.transform.setToTranslationAndScaling(auxVector3_1, auxVector3_2);
	}

	private static float adjustWallBetweenTwoNodes(final MapNodeData eastOrSouthNode,
												   final MapNodeData westOrNorthNode,
												   final Wall wallBetween, int textureHeight) {
		Vector3 wallBetweenThemPos = wallBetween.getModelInstance().transform.getTranslation(auxVector3_1);
		float eastOrSouthHeight = eastOrSouthNode.getHeight();
		float westOrNorthHeight = westOrNorthNode.getHeight();
		float sizeHeight = Math.abs(westOrNorthHeight - eastOrSouthHeight);
		float y = Math.min(eastOrSouthHeight, westOrNorthHeight) + (eastOrSouthHeight > westOrNorthHeight ? sizeHeight : 0);
		wallBetween.getModelInstance().transform.setToTranslationAndScaling(wallBetweenThemPos.x, y, wallBetweenThemPos.z,
				1, sizeHeight, 1);
		return sizeHeight / textureHeight;
	}

	private static void adjustWallTextureAndPosition(Wall wall,
													 float wallNodeHeight,
													 MapNodeData neighborNode) {
		ModelInstance modelInstance = wall.getModelInstance();
		float neighborHeight = neighborNode.getHeight();
		float sizeHeight = Math.abs(wallNodeHeight - neighborHeight);
		adjustWallTexture(modelInstance, sizeHeight);
		float minHeight = Math.min(wallNodeHeight, neighborHeight);
		Coords neighborNodeCoords = neighborNode.getCoords();
		Vector3 position = auxVector3_1.set(neighborNodeCoords.getCol(), minHeight, neighborNodeCoords.getRow());
		modelInstance.transform.setToTranslationAndScaling(position, auxVector3_2.set(1, sizeHeight, 1));
	}

	private static void adjustWallTexture(ModelInstance modelInstance, float sizeHeight) {
		TextureAttribute textureAtt = (TextureAttribute) modelInstance.materials.get(0).get(TextureAttribute.Diffuse);
		int textureHeight = textureAtt.textureDescription.texture.getHeight() / WORLD_UNIT_SIZE;
		textureAtt.scaleV = sizeHeight / textureHeight;
		textureAtt.offsetV = (1F - textureAtt.scaleV);
	}

	private void createWestWallModel( ) {
		ModelBuilder modelBuilder = new ModelBuilder();
		westWallModel = modelBuilder.createRect(
				0, 0, 1,
				0, 0, 0,
				0, 1, 0,
				0, 1, 1,
				1, 0, 0,
				new Material(TextureAttribute.createDiffuse((Texture) null)),
				Usage.Position | Usage.Normal | Usage.TextureCoordinates);
	}

	private void createSouthWallModel( ) {
		ModelBuilder modelBuilder = new ModelBuilder();
		southWallModel = modelBuilder.createRect(
				1, 0, 1,
				0, 0, 1,
				0, 1, 1,
				1, 1, 1,
				0, 0, -1,
				new Material(TextureAttribute.createDiffuse((Texture) null)),
				Usage.Position | Usage.Normal | Usage.TextureCoordinates);
	}

	private void createEastWallModel( ) {
		ModelBuilder modelBuilder = new ModelBuilder();
		eastWallModel = modelBuilder.createRect(
				1, 0, 0,
				1, 0, 1,
				1, 1, 1,
				1, 1, 0,
				-1, 0, 0,
				new Material(TextureAttribute.createDiffuse((Texture) null)),
				Usage.Position | Usage.Normal | Usage.TextureCoordinates);
	}

	private void createNorthWallModel( ) {
		ModelBuilder modelBuilder = new ModelBuilder();
		northWallModel = modelBuilder.createRect(
				0, 0, 0,
				1, 0, 0,
				1, 1, 0,
				0, 1, 0,
				0, 0, 1,
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
			NodeWalls southernNodeWalls = southernNode.getWalls();
			if (southernNodeWalls.getNorthWall() == null) {
				southernNodeWalls.setNorthWall(createWall(southernNode, northWallModel, assetsManager, MISSING));
			}
			adjustWallTextureAndPosition(southernNodeWalls.getNorthWall(), northernNode.getHeight(), southernNode);
		} else {
			clearWallBetweenNorthAndSouthNodes(northernNode, southernNode);
		}
	}

	/**
	 * Creates a wall between the two nodes if missing and adjusts it.
	 *
	 * @param southernNode
	 * @param northernNode
	 */
	public void adjustSouthWall(final MapNodeData southernNode,
								final MapNodeData northernNode) {
		if (northernNode.getHeight() != southernNode.getHeight()) {
			NodeWalls northernNodeWalls = northernNode.getWalls();
			if (northernNodeWalls.getSouthWall() == null) {
				northernNodeWalls.setSouthWall(createWall(northernNode, southWallModel, assetsManager, MISSING));
			}
			adjustWallTextureAndPosition(northernNodeWalls.getSouthWall(), southernNode.getHeight(), northernNode);
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
	public void adjustWestWall(final MapNodeData westernNode,
							   final MapNodeData easternNode) {
		if (easternNode.getHeight() != westernNode.getHeight()) {
			NodeWalls easternNodeWalls = easternNode.getWalls();
			if (easternNodeWalls.getWestWall() == null) {
				easternNodeWalls.setWestWall(createWall(easternNode, westWallModel, assetsManager, MISSING));
			}
			adjustWallTextureAndPosition(easternNodeWalls.getWestWall(), westernNode.getHeight(), easternNode);
		} else {
			clearWallBetweenWestAndEastNodes(westernNode, easternNode);
		}
	}

	/**
	 * Creates a wall between the two nodes if missing and adjusts it.
	 *
	 * @param westernNode
	 * @param easternNode
	 */
	public void adjustEastWall(final MapNodeData westernNode,
							   final MapNodeData easternNode) {
		if (easternNode.getHeight() != westernNode.getHeight()) {
			NodeWalls westernNodeWalls = westernNode.getWalls();
			if (westernNodeWalls.getEastWall() == null) {
				westernNodeWalls.setEastWall(createWall(westernNode, eastWallModel, assetsManager, MISSING));
			}
			adjustWallTextureAndPosition(westernNodeWalls.getEastWall(), easternNode.getHeight(), westernNode);
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

	@Override
	public void dispose( ) {
		eastWallModel.dispose();
		westWallModel.dispose();
		northWallModel.dispose();
		southWallModel.dispose();
	}
}
