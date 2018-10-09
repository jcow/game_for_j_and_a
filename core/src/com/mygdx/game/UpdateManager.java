package com.mygdx.game;

import com.mygdx.levels.MyLevel;
import com.mygdx.players.Player;
import com.mygdx.managers.PlayerInputManager;

public class UpdateManager {


    public UpdateManager() {

    }

    public void update(MyLevel level, Player[] players){


        // TODO - all the updates for players / levels

        for(Player player : players) {
            int potentialXVel = 0;
            int potentialYVel = 0;

            if(PlayerInputManager.getInstance().isUpPressed(player.getID())) {
                potentialYVel = 5;
            }
            else if(PlayerInputManager.getInstance().isDownPressed(player.getID())) {
                potentialYVel = -5;
            }

            if(PlayerInputManager.getInstance().isRightPressed(player.getID())) {
                potentialXVel = 5;
            }
            else if(PlayerInputManager.getInstance().isLeftPressed(player.getID())) {
                potentialXVel = -5;
            }

            int newXPos = player.getSprite().getXPos() + potentialXVel;
            int newYPos = player.getSprite().getYPos() + potentialYVel;

            player.getSprite().setXPos(newXPos);
            player.getSprite().setYPos(newYPos);
        }
    }

}
