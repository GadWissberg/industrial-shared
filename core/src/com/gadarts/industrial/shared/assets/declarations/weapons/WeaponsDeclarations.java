package com.gadarts.industrial.shared.assets.declarations.weapons;

import com.gadarts.industrial.shared.assets.Declaration;

import java.util.List;

public record WeaponsDeclarations(List<WeaponDeclaration> weaponsDeclarations) implements Declaration {

	public WeaponDeclaration parse(String id) {
		return weaponsDeclarations.stream()
				.filter(weaponDeclaration -> weaponDeclaration.getId().equalsIgnoreCase(id))
				.findFirst().orElse(null);
	}
}
