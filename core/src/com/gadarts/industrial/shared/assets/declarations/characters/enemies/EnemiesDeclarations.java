package com.gadarts.industrial.shared.assets.declarations.characters.enemies;

import com.gadarts.industrial.shared.assets.Declaration;

import java.util.List;

public record EnemiesDeclarations(List<EnemyDeclaration> enemiesDeclarations) implements Declaration {
}
