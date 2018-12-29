package com.mygdx.levels;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.util.Pair;

import java.util.List;

public class MyLevel {

    private int levelNumber;
    private Pair<Integer, Integer> playerSpawn;
    private List<Pair<Integer, Integer>> enemySpawns;
    private Pair<Integer, Integer> levelExit;
    private List<Rectangle> collidables;

    public int getLevelNumber() {
        return levelNumber;
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

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setPlayerSpawn(Pair<Integer, Integer> playerSpawn) {
        this.playerSpawn = playerSpawn;
    }

    public void setEnemySpawns(List<Pair<Integer, Integer>> enemySpawns) {
        this.enemySpawns = enemySpawns;
    }

    public void setLevelExit(Pair<Integer, Integer> levelExit) {
        this.levelExit = levelExit;
    }

    public void setCollidables(List<Rectangle> collidables) {
        this.collidables = collidables;
    }

}
