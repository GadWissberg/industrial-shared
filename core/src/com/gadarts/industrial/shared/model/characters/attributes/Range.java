package com.gadarts.industrial.shared.model.characters.attributes;

import lombok.Getter;

@Getter
public enum Range {
	NONE(0), LOW(3), MED(6), HIGH(9);

	private final int maxDistance;

	Range(int maxDistance) {
		this.maxDistance = maxDistance;
	}
}
