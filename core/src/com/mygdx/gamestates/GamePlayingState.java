package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.creators.PlayerCreator;
import com.mygdx.game.UpdateManager;
import com.mygdx.levels.MyLevel;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.Player;
import com.mygdx.players.Player1;
import com.mygdx.players.PlayerID;
import com.mygdx.sprites.MySprite;

import java.util.ArrayList;
import java.util.List;

public class GamePlayingState implements GameStates {

    UpdateManager updateManager;

    Player[] players;

    MyLevel currentLevel;
    List<MyLevel> levels;

    public GamePlayingState() {

        updateManager = new UpdateManager();
        PlayerCreator playerCreator = new PlayerCreator();
        Player player1 = playerCreator.createPlayer1();

        players = new Player[1];

        levels = MyLevel.getLevels();
        currentLevel = levels.get(0);

        player1.getSprite().setXPos(currentLevel.getPlayerSpawn().getFirst());
        player1.getSprite().setYPos(currentLevel.getPlayerSpawn().getSecond());


        players[0] = player1;
    }

    public void render(Texture background, Texture sprites, SpriteBatch batch, BitmapFont font) {

        PlayerInputManager.getInstance().setStepDelay(0);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(sprites, players[0].getSprite().getXPos(), players[0].getSprite().getYPos(), players[0].getSprite().getWidth(), players[0].getSprite().getHeight());


        batch.end();

        // update
        updateManager.update(null, players);

    }

    public String getID(){
        return GamePlayingState.class.getName();
    }

    public String newState() {
        // TODO
        if(PlayerInputManager.getInstance().isCancelledPressed(PlayerID.PLAYER_1)){
            return GamePausedState.class.getName();
        }

        return null;
    }
}
