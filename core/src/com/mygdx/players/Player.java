package com.mygdx.players;

import com.mygdx.sprites.MySprite;

public class Player {

    protected PlayerID playerID;
    protected MySprite sprite;

    public PlayerID getID(){
        return playerID;
    }

    public MySprite getSprite() {
        return sprite;
    }

    public void setSprite(MySprite sprite) {
        this.sprite = sprite;
    }
}
