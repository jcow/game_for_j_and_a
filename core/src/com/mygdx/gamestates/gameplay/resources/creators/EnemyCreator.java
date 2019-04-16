package com.mygdx.gamestates.gameplay.resources.creators;

import com.badlogic.gdx.utils.Pool;
import com.mygdx.gamestates.gameplay.resources.sprites.Enemy;
import com.mygdx.gamestates.gameplay.resources.creators.pools.EnemyPool;

public class EnemyCreator {

    private static EnemyCreator instance;

    public static EnemyCreator getInstance() {
        if(instance == null) {
            instance = new EnemyCreator();
        }

        return instance;
    }

    private Pool<Enemy> enemyPool = new EnemyPool();

    public Enemy create(int x, int y) {
        Enemy enemy = enemyPool.obtain();

        return enemy;
    }

}
