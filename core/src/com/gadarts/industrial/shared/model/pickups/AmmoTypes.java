package com.gadarts.industrial.shared.model.pickups;

import com.gadarts.industrial.shared.assets.Assets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AmmoTypes {
	BULLET(Assets.UiTextures.HUD_AMMO_BULLET_ICON),
	SHELL(Assets.UiTextures.HUD_AMMO_BULLET_ICON),
	ROCKET(Assets.UiTextures.HUD_AMMO_BULLET_ICON),
	ENERGY_CELL(Assets.UiTextures.HUD_AMMO_BULLET_ICON);

	private final Assets.UiTextures hudIcon;
}
