package com.gadarts.industrial.shared.assets.declarations.weapons;

import com.gadarts.industrial.shared.assets.Declaration;
import com.gadarts.industrial.shared.model.ItemDeclaration;

import java.util.List;

public record WeaponsDeclarations(List<WeaponDeclaration> weaponsDeclarations,
								  List<PlayerWeaponDeclaration> playerWeaponsDeclarations) implements Declaration {
	public PlayerWeaponDeclaration parsePlayerWeaponDeclaration(String id) {
		return (PlayerWeaponDeclaration) parse(id, playerWeaponsDeclarations);
	}

	private ItemDeclaration parse(String id, List<? extends ItemDeclaration> declarations) {
		return declarations.stream()
				.filter(playerWeaponDeclaration -> playerWeaponDeclaration.getId().equalsIgnoreCase(id))
				.findFirst().orElse(null);
	}

	public WeaponDeclaration parseWeaponDeclaration(String id) {
		return (WeaponDeclaration) parse(id, weaponsDeclarations);
	}
}
