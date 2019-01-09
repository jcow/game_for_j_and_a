package com.mygdx.gamestates.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.gamestates.GameState;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.PlayerID;

public class GamePausedState implements GameState {

    public void render(GameAssetsContainer gameAssetsContainer) {

        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public String getID(){
        return GamePausedState.class.getName();
    }

    public GameStatesEnum nextState() {

        if(PlayerInputManager.getInstance().isActionPressed(PlayerID.PLAYER_1)){
            return GameStatesEnum.GAME_PLAYING;
        }

        return null;
    }

}
