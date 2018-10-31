package com.mygdx.levels;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public enum MyLevel {

    LEVEL_1(
            1,
            new Pair<Integer, Integer>(100, 100),
            new ArrayList<Pair<Integer, Integer>>() {{
                add(new Pair(1, 1));
            }},
            new Pair(1000, 1000),
            new ArrayList<Rectangle>() {{
                add(new Rectangle(0, 0, 10 ,10));
            }}
    );

    int identifier;
    Pair<Integer, Integer> playerSpawn;
    List<Pair<Integer, Integer>> enemySpawns;
    Pair<Integer, Integer> levelExit;
    List<Rectangle> collidables;

    MyLevel(
        int identifier,
        Pair<Integer, Integer> playerSpawn,
        List<Pair<Integer, Integer>> enemySpawns,
        Pair<Integer, Integer> levelExit,
        List<Rectangle> collidables
    ) {
        this.identifier = identifier;
        this.playerSpawn = playerSpawn;
        this.enemySpawns = enemySpawns;
        this.levelExit = levelExit;
        this.collidables = collidables;
    }

    public int getIdentifier() {
        return identifier;
    }

    public Pair<Integer, Integer> getPlayerSpawn() {
        return playerSpawn;
    }

    public List<Pair<Integer, Integer>> getEnemySpawns() {
        return enemySpawns;
    }

    public Pair<Integer, Integer> getLevelExit() {
        return levelExit;
    }

    public List<Rectangle> getCollidables() {
        return collidables;
    }

    public static List<MyLevel> getLevels() {
        List<MyLevel> levels = new ArrayList<MyLevel>();
        levels.add(LEVEL_1);
        return levels;
    }
}
