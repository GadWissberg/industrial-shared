package com.gadarts.industrial.shared.model.env;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum EnvironmentObjectType {
	THING(ThingsDefinitions.values()), DOOR(DoorsDefinitions.values());

	private final EnvironmentObjectDeclaration[] definitions;

	public static List<EnvironmentObjectDeclaration> collectAndGetAllDefinitions( ) {
		List<EnvironmentObjectDeclaration> result = new ArrayList<>();
		Arrays.stream(values()).forEach(t -> result.addAll(List.of(t.getDefinitions())));
		return result;
	}

}
