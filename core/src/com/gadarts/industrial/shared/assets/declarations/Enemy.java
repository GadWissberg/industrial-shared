package com.gadarts.industrial.shared.assets.declarations;

import com.gadarts.industrial.shared.assets.Declaration;
import com.gadarts.industrial.shared.model.characters.attributes.Accuracy;
import com.gadarts.industrial.shared.model.characters.attributes.Sight;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Enemy extends Declaration {
	private final String displayName;
	private final String atlasDefinition;
	private final float agility;
	private final Integer health;
	private final Accuracy accuracy;
	private final Sight sight;
	private final Integer engine;
	private final String attackPrimary;
	private final int attackPrimaryHitFrameIndex;
	private final boolean singleDeathAnimation;
	private final float height;
	private final String soundAwake;
	private final String soundMelee;
	private final String soundPain;
	private final String soundDeath;
	private final String soundStep;
	private final String explosionEffectOnDestroy;
	private final float shadowRadius;
	private final boolean human;
	private final float bulletCreationHeight;

}
