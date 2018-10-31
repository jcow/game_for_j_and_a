package com.mygdx.creators;

import com.mygdx.players.Player;
import com.mygdx.players.Player1;
import com.mygdx.sprites.MySprite;

public class PlayerCreator {


    public PlayerCreator(){

    }

    public Player createPlayer1(){

        MySprite player1Sprite = new MySprite();
        player1Sprite.setHeight(40);
        player1Sprite.setWidth(40);

        Player player1 = new Player1();
        player1.setSprite(player1Sprite);

        return player1;
    }
}
