package com.mygdx.levels;

public enum LevelCharacterDefinition {

    WALL('#'),
    PLAYER_SPAWN('P'),
    ENEMY_SPAWN('E'),
    EMPTY_SPACE('.');

    private char definition;

    LevelCharacterDefinition(char definition) {
        this.definition = definition;
    }
}
