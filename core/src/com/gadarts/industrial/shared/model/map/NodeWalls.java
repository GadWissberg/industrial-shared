package com.gadarts.industrial.shared.model.map;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeWalls {
	private Wall eastWall;
	private Wall southWall;
	private Wall westWall;
	private Wall northWall;

	public boolean isEmpty( ) {
		return isWallEmpty(eastWall) && isWallEmpty(southWall) && isWallEmpty(westWall) && isWallEmpty(northWall);
	}

	private boolean isWallEmpty(Wall wall) {
		return wall == null || wall.getDefinition() == Assets.SurfaceTextures.MISSING;
	}
}
