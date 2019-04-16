package com.mygdx.gamestates.gameplay.resources.creators.pools;

import com.badlogic.gdx.utils.Pool;
import com.mygdx.gamestates.gameplay.resources.sprites.Enemy;

public class EnemyPool extends Pool {

    @Override
    protected Enemy newObject() {
        return new Enemy();
    }

}

