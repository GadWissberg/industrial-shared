package com.gadarts.industrial.shared.assets.loaders;

import com.gadarts.industrial.shared.assets.declarations.weapons.WeaponDeclaration;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class WeaponDeclarationDeserializer implements JsonDeserializer<WeaponDeclaration> {
	@Override
	public WeaponDeclaration deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return null;
	}
}
