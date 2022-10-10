package com.gadarts.industrial.shared.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TriggersDefinitions implements ElementDefinition {
	EXIT_MAP("Exit Map");

	private final String displayName;


}
