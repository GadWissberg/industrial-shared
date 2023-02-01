package com.gadarts.industrial.shared.assets.declarations;

import com.gadarts.industrial.shared.assets.Declaration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Enemies extends Declaration {
	private final List<Enemy> enemies;

}
