package com.mygdx.managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gamestates.GameAssetsContainer;
import com.mygdx.gamestates.GamePausedState;
import com.mygdx.gamestates.GamePlayingState;
import com.mygdx.gamestates.GameStates;
import com.mygdx.gamestates.MainMenuState;

import java.util.HashMap;

public class GameStateManager {


    private GameStates mainMenuState;
    private GameStates gamePlayingState;
    private GameStates gamePausedState;
    private GameStates currentGameState;

    private HashMap<String, GameStates> gameStatesHashMap;

    public GameStateManager() {
        mainMenuState = new MainMenuState();
        gamePlayingState = new GamePlayingState();
        gamePausedState = new GamePausedState();
        currentGameState = mainMenuState;

        gameStatesHashMap = new HashMap<String, GameStates>();
        gameStatesHashMap.put(mainMenuState.getID(), mainMenuState);
        gameStatesHashMap.put(gamePlayingState.getID(), gamePlayingState);
        gameStatesHashMap.put(gamePausedState.getID(), gamePausedState);
    }

    public void render(GameAssetsContainer gameAssetsContainer) throws Exception {
        currentGameState.render(gameAssetsContainer);

        String newState = currentGameState.newState();

        PlayerInputManager.getInstance().step();

        // move to new state
        if(newState != null && newState != currentGameState.getID()) {
            if(gameStatesHashMap.containsKey(currentGameState.getID()) == false) {
                // TODO
                throw new Exception("GameState transitions are borked");
            }
            else {
                currentGameState = gameStatesHashMap.get(newState);
            }
        }
    }

}
