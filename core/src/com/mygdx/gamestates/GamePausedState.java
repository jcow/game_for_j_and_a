package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.PlayerID;

public class GamePausedState implements GameStates {

    public void render(Texture background, Texture sprites, SpriteBatch batch, BitmapFont font) {

        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public String getID(){
        return GamePausedState.class.getName();
    }

    public String newState() {
        // todo - maybe have a player manager...
        if(PlayerInputManager.getInstance().isActionPressed(PlayerID.PLAYER_1)){
            return GamePlayingState.class.getName();
        }

        return null;
    }

}
