package com.gadarts.industrial.shared.model.env;

import com.gadarts.industrial.shared.assets.declarations.EnvironmentObjectDeclaration;
import com.gadarts.industrial.shared.model.ElementType;
import com.gadarts.industrial.shared.model.env.door.DoorsDefinitions;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum EnvironmentObjectType implements ElementType {
	THING(ThingsDefinitions.values()), DOOR(DoorsDefinitions.values());

	private final EnvironmentObjectDeclaration[] definitions;

	public static List<EnvironmentObjectDeclaration> collectAndGetAllDefinitions( ) {
		List<EnvironmentObjectDeclaration> result = new ArrayList<>();
		Arrays.stream(values()).forEach(t -> result.addAll(List.of(t.getDefinitions())));
		return result;
	}

}
