package com.gadarts.industrial.shared.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter

public class Coords {
	@Setter(AccessLevel.NONE)
	private final int row;
	@Setter(AccessLevel.NONE)
	private final int col;

	public boolean equals(int row, int col) {
		return this.row == row && this.col == col;
	}
}
