package com.gadarts.industrial.shared.assets.data;

import com.gadarts.industrial.shared.assets.Assets;
import com.gadarts.industrial.shared.assets.Data;
import com.gadarts.industrial.shared.model.characters.attributes.Accuracy;
import com.gadarts.industrial.shared.model.characters.attributes.Sight;
import com.gadarts.industrial.shared.model.characters.enemies.WeaponsDefinitions;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Enemy extends Data {
	private final String displayName;
	private final Assets.Atlases atlasDefinition;
	private final float agility;
	private final Integer health;
	private final Accuracy accuracy;
	private final Sight sight;
	private final Integer engine;
	private final WeaponsDefinitions primaryAttack;
	private final int primaryAttackHitFrameIndex;
	private final boolean singleDeathAnimation;
	private final float height;
	private final Assets.Sounds awakeSound;
	private final Assets.Sounds meleeSound;
	private final Assets.Sounds painSound;
	private final Assets.Sounds deathSound;
	private final Assets.Sounds stepSound;
	private final Assets.ParticleEffects explosionEffectOnDestroy;
	private final float shadowRadius;
	private final boolean human;
	private final float bulletCreationHeight;

}
