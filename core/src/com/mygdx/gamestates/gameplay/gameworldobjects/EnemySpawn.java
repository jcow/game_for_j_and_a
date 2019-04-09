package com.mygdx.gamestates.gameplay.gameworldobjects;

import com.badlogic.gdx.utils.Pool;

public class EnemySpawn implements Pool.Poolable {

    private int x;
    private int y;

    public EnemySpawn() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void reset() {

    }


}
