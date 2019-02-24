package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.managers.PlayerInputManager;

public abstract class GameStateMaster implements GameState {

    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(PlayerInputManager.getInstance().isQuitGamePressed()) {
            Gdx.app.exit();
        }
    }

}
