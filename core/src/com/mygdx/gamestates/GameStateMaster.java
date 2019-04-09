package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.mygdx.managers.PlayerInputManager;

public abstract class GameStateMaster implements GameState {

    public void render() {
        if(PlayerInputManager.getInstance().isQuitGamePressed()) {
            Gdx.app.exit();
        }
    }

    public void unload(){

    }

}
