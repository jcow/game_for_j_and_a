package com.mygdx.managers;

import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.gamestates.GameState;

public class GameStateManager {

    GameState currentGameState;

    public GameStateManager() {
        setCurrentGameState(GameStatesEnum.MAIN_MENU);
    }

    public void render() {
        currentGameState.render();

        GameStatesEnum newGameState = currentGameState.nextState();

        if (newGameState != null) {
            setCurrentGameState(newGameState);
        }

        PlayerInputManager.getInstance().step();
    }

    protected void setCurrentGameState(GameStatesEnum gameStatesEnum) {
        currentGameState = gameStatesEnum.getGameState();
        currentGameState.load();
    }

}
