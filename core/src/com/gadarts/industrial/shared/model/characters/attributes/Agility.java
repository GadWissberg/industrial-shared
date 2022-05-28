package com.gadarts.industrial.shared.model.characters.attributes;

import lombok.Getter;

@Getter
public enum Agility {
	LOW(3), MED(5), HIGH(7);

	private final int value;

	Agility(int value) {
		this.value = value;
	}
}
