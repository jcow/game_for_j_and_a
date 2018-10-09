package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.UpdateManager;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.Player;
import com.mygdx.players.Player1;
import com.mygdx.players.PlayerID;
import com.mygdx.sprites.MySprite;

public class GamePlayingState implements GameStates {

    UpdateManager updateManager;
    Player[] players;

    public GamePlayingState() {

        updateManager = new UpdateManager();

        players = new Player[1];

        Player player1 = new Player1();

        MySprite player1Sprite = new MySprite();

//        Player player2 = new Player2();

        player1.setSprite(player1Sprite);
        player1.getSprite().setXPos(100);
        player1.getSprite().setYPos(100);
        player1.getSprite().setWidth(40);
        player1.getSprite().setHeight(40);

        players[0] = player1;
//        players[1] = player2;
    }

    public void render(Texture background, Texture sprites, SpriteBatch batch, BitmapFont font) {

        PlayerInputManager.getInstance().setStepDelay(0);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for(int i = 0; i < 48; i++) {
            for(int j = 0; j < 27; j++) {
//                batch.draw(sprites, i * 40, j * 40, 40, 40);
//                batch.draw(sprites, i * 32, j * 32, 32, 32, 255, )
            }
        }

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
        if(getPlayerInputManager().isCancelledPressed(PlayerID.PLAYER_1)){
            return GamePausedState.class.getName();
        }

        return null;
    }

    private PlayerInputManager getPlayerInputManager(){
        return PlayerInputManager.getInstance();
    }
}
