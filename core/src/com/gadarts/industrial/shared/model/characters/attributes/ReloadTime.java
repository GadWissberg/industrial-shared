package com.gadarts.industrial.shared.model.characters.attributes;

import lombok.Getter;

@Getter
public enum ReloadTime {
	NONE(0), FAST(1), MED(2), SLOW(4);

	private final int numberOfTurns;

	ReloadTime(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}
}
