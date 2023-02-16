package com.gadarts.industrial.shared.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TriggersDefinitions implements ElementDeclaration {
	EXIT_MAP("Exit Map");

	private final String displayName;


	@Override
	public String displayName( ) {
		return displayName;
	}

	@Override
	public String id( ) {
		return name();
	}
}
