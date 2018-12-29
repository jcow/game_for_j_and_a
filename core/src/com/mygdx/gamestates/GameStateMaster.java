package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.mygdx.managers.PlayerInputManager;

public abstract class GameStateMaster implements GameStates {

    public void render(GameAssetsContainer gameAssetsContainer) {
        if(PlayerInputManager.getInstance().isQuitGamePressed()) {
            Gdx.app.exit();
        }
    }


}
