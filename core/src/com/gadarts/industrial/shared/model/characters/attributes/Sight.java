package com.gadarts.industrial.shared.model.characters.attributes;

import lombok.Getter;

@Getter
public enum Sight {
	LOW(3), MED(6), HIGH(9);

	private final int maxDistance;

	Sight(int maxDistance) {
		this.maxDistance = maxDistance;
	}
}
