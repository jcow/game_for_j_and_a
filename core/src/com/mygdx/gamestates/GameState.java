package com.mygdx.gamestates;


import java.io.IOException;

public interface GameState {

    void load() throws IOException;

    void render();

    void unload();

    GameStatesEnum nextState();

}
