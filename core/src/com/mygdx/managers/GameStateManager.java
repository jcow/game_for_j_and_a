package com.mygdx.managers;

import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.gamestates.GameState;

public class GameStateManager {

    GameState currentGameState;

    public GameStateManager() {
        currentGameState = GameStatesEnum.MAIN_MENU.getGameState();
    }

    public void render(GameAssetsContainer gameAssetsContainer) {
        currentGameState.render(gameAssetsContainer);

        GameStatesEnum newEnum = currentGameState.nextState();

        if(newEnum != null) {
            currentGameState = newEnum.getGameState();
        }

        PlayerInputManager.getInstance().step();
    }

}
