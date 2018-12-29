package com.mygdx.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.players.PlayerID;

public class PlayerInputManager {

    private static PlayerInputManager instance = null;

    private int stepDelay = 1;
    private int steps = 0;

    public static PlayerInputManager getInstance() {
        if(instance == null) {
            instance = new PlayerInputManager();
        }
        
        return instance;
    }

    private PlayerInputManager() {}

    public void step() {
        steps++;
    }

    public void setStepDelay(int stepDelay) {
        this.stepDelay = stepDelay;
    }

    public boolean isUpPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.UP) && tryDoAction()) {
            return true;
        }

        return false;
    }

    public boolean isDownPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.DOWN) && tryDoAction()) {
            return true;
        }

        return false;
    }

    public boolean isLeftPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.LEFT) && tryDoAction()) {
            return true;
        }
        return false;
    }

    public boolean isRightPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tryDoAction()) {
            return true;
        }

        return false;
    }

    public boolean isActionPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.SPACE) && tryDoAction()) {
            return true;
        }

        return false;
    }

    public boolean isSecondaryActionPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.F) && tryDoAction()) {
            return true;
        }

        return false;
    }

    public boolean isCancelledPressed(PlayerID playerID) {
        if(playerID == PlayerID.PLAYER_1 && Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && tryDoAction()) {
            return true;
        }

        return false;
    }

    public boolean isQuitGamePressed() {
        if(Gdx.input.isKeyPressed(Input.Keys.Q) && Gdx.input.isKeyPressed(Input.Keys.P)) {
            return true;
        }

        return false;
    }

    private boolean tryDoAction(){
        if(steps >= stepDelay) {
            steps = 0;
            return true;
        }
        else {
            return false;
        }
    }

}
