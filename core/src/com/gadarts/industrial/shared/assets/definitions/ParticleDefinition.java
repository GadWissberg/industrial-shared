package com.gadarts.industrial.shared.assets.definitions;


import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;

public interface ParticleDefinition extends AssetDefinition {
	String FOLDER = "particles";
	String FORMAT = "pfx";
	
	String getSubFolderName();

	@Override
	default Class<ParticleEffect> getTypeClass() {
		return ParticleEffect.class;
	}

	String getName();
}
