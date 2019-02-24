package com.mygdx.gamestates;

import com.mygdx.gamestates.gameplay.GamePlayingState;
import com.mygdx.gamestates.gameplay.Level1State;
import com.mygdx.gamestates.gameplay.OverworldState;
import com.mygdx.gamestates.menus.MainMenuState;

public enum GameStatesEnum {

    MAIN_MENU(new MainMenuState()),
    OVERWORLD(new OverworldState()),
    GAME_PLAYING(new GamePlayingState()),

    LEVEL_1(new Level1State());

    private GameState gameState;

    GameStatesEnum(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
