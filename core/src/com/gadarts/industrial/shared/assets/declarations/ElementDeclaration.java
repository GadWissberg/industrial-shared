package com.gadarts.industrial.shared.assets.declarations;

import com.gadarts.industrial.shared.assets.Declaration;

public interface ElementDeclaration extends Declaration {
	String displayName( );
	String id( );

	String name( );

	default boolean hiddenFromMap( ) {
		return false;
	}

}
