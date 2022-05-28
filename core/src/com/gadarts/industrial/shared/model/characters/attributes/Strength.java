package com.gadarts.industrial.shared.model.characters.attributes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Strength {
	private final int minDamage;
	private final int maxDamage;

	private Strength(final int damage) {
		this.minDamage = damage;
		this.maxDamage = damage;
	}

	public static Strength of(final int damage) {
		return new Strength(damage);
	}
	
	public static Strength of(final int minDamage, final int maxDamage) {
		return new Strength(minDamage, maxDamage);
	}
}
