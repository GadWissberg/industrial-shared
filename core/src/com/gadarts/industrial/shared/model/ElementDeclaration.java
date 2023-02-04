package com.gadarts.industrial.shared.model;

import com.gadarts.industrial.shared.assets.Declaration;

public interface ElementDeclaration extends Declaration {
	String displayName( );

	String name( );

	default boolean hiddenFromMap( ) {
		return false;
	}

}
