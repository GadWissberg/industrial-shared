package com.gadarts.industrial.shared.assets.declarations.enemies;

import com.gadarts.industrial.shared.assets.Declaration;

import java.util.List;

public record EnemiesDeclarations(List<EnemyDeclaration> enemies) implements Declaration {
}
