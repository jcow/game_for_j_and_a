package com.mygdx.gamestates.gameplay.pooling;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;


public abstract class PoolWrapper<T extends Pool.Poolable> extends Pool<T> {

    protected Array<T> active = new Array<T>();

    public PoolWrapper() {}

    protected void destroyObjectAt(int i) {

        T obj = active.removeIndex(i);

        obj.reset();

        this.free(obj);

    }

    public Array<T> getActive() {
        return active;
    }

}

