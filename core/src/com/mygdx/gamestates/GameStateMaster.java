package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.managers.PlayerInputManager;

public abstract class GameStateMaster implements GameState {

    public void render(GameAssetsContainer gameAssetsContainer) {
        if(PlayerInputManager.getInstance().isQuitGamePressed()) {
            Gdx.app.exit();
        }
    }


}
