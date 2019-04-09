package com.mygdx.gamestates.gameplay.pooling.enemyspawns;

import com.mygdx.gamestates.gameplay.gameworldobjects.EnemySpawn;
import com.mygdx.gamestates.gameplay.pooling.PoolWrapper;

public class EnemySpawnPool extends PoolWrapper<EnemySpawn> {

    public EnemySpawn create(int x, int y) {

        EnemySpawn enemySpawn = this.obtain();
        enemySpawn.setX(x);
        enemySpawn.setY(y);

        this.active.add(enemySpawn);

        return enemySpawn;
    }

    @Override
    protected EnemySpawn newObject() {
        return new EnemySpawn();
    }

}
