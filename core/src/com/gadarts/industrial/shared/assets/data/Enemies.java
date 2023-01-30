package com.gadarts.industrial.shared.assets.data;

import com.gadarts.industrial.shared.assets.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Enemies extends Data {
	private final List<Enemy> enemies;

}
