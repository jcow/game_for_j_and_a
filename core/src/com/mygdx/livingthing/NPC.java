package com.mygdx.livingthing;

import com.mygdx.sprites.MySprite;

public class NPC {

    // todo health n such
    private MySprite mySprite;

    // AI?

    public NPC(MySprite mySprite) {
        this.mySprite = mySprite;
    }

    // probably not void... what about bullets and such...?
    public void action() {

    }

    public MySprite getMySprite() {
        return mySprite;
    }
}
