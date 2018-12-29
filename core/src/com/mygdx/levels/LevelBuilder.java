package com.mygdx.levels;

import com.mygdx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {

    public List<MyLevel> buildLevels() {
        List<MyLevel> levels = new ArrayList<MyLevel>();
        levels.add(buildLevel1());
        return levels;
    }

    private MyLevel buildLevel1() {

        MyLevel level = new Level1();

        List<Pair<Integer, Integer>> enemySpawns = new ArrayList<Pair<Integer, Integer>>();
        enemySpawns.add(new Pair<Integer, Integer>(10, 10));

        level.setLevelNumber(1);
        level.setPlayerSpawn(new Pair<Integer, Integer>(100, 100));
        level.setEnemySpawns(enemySpawns);
        level.setLevelExit(new Pair<Integer, Integer> (200, 200));

        return level;
    }
}
