package com.mygdx.gamestates;

import com.mygdx.gamestates.gameplay.GamePausedState;
import com.mygdx.gamestates.gameplay.GamePlayingState;
import com.mygdx.gamestates.gameplay.OverworldState;
import com.mygdx.gamestates.loaders.GameLoadingState;
import com.mygdx.gamestates.menus.MainMenuState;

public enum GameStatesEnum {

    MAIN_MENU(new MainMenuState()),
    GAME_LOADING(new GameLoadingState()),
    OVERWORLD(new OverworldState()),
    GAME_PLAYING(new GamePlayingState()),
    GAME_PAUSED(new GamePausedState());

    private GameState gameState;

    GameStatesEnum(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
