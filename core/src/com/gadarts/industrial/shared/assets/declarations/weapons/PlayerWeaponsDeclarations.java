package com.gadarts.industrial.shared.assets.declarations.weapons;

import com.gadarts.industrial.shared.assets.Declaration;

import java.util.List;

public record PlayerWeaponsDeclarations(
		List<PlayerWeaponDeclaration> playerWeaponsDeclarations) implements Declaration {

	public PlayerWeaponDeclaration parse(String id) {
		return playerWeaponsDeclarations.stream()
				.filter(playerWeaponDeclaration -> playerWeaponDeclaration.getId().equalsIgnoreCase(id))
				.findFirst().orElse(null);
	}
}
