package com.mygdx.game;

import com.mygdx.collisions.CollisionManager;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;
import com.mygdx.players.Player;
import com.mygdx.managers.PlayerInputManager;

public class UpdateManager {

    private CollisionManager collisionManager;

    public UpdateManager() {
        collisionManager = new CollisionManager();
    }

    public void update(MyLevelDefinition level, Player[] players) {

//        for(Player player : players) {
//            collisionManager.getNewUserToWorldCollisionRectangles(
//                    level.getRectangles(),
//                    player.getSprite().getRectangle(),
//                    player.getSprite().getXVel(),
//                    player.getSprite().getYVel()
//            );
//        }


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
