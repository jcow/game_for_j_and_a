package com.mygdx.gamestates;


public interface GameState {

    void load();

    void render();

    GameStatesEnum nextState();

}
