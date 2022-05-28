package com.gadarts.industrial.shared.model.characters.attributes;

import lombok.Getter;

@Getter
public enum Accuracy {
	NONE(0), LOW(13), MED(10), HIGH(8);

	private final int maxAngle;

	Accuracy(int maxAngle) {
		this.maxAngle = maxAngle;
	}
}
