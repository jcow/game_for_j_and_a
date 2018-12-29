package com.mygdx.creators;

import com.mygdx.enemies.Enemy;

public class EnemyCreator {

    public EnemyCreator(){

    }

    public Enemy createEnemy(int x, int y) {
        Enemy enemy = new Enemy();

        return enemy;
    }
}
