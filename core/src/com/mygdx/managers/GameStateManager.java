package com.mygdx.managers;

import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.gamestates.GameState;

import java.io.IOException;

public class GameStateManager {

    GameState currentGameState;

    public GameStateManager() throws IOException {
        setCurrentGameState(GameStatesEnum.MAIN_MENU);
    }

    public void render() throws IOException {
        currentGameState.render();

        GameStatesEnum newGameState = currentGameState.nextState();

        if (newGameState != null) {
            setCurrentGameState(newGameState);
        }

        PlayerInputManager.getInstance().step();
    }

    protected void setCurrentGameState(GameStatesEnum gameStatesEnum) throws IOException {
        currentGameState = gameStatesEnum.getGameState();
        currentGameState.load();
    }

}
