package com.mygdx.sprites;

public class MyTile extends MySprite {

    private boolean isCollidable;

    public void setCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
    }

    public boolean isCollidable() {
        return isCollidable;
    }
}
