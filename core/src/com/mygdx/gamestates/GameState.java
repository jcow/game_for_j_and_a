package com.mygdx.gamestates;

import com.mygdx.assets.GameAssetsContainer;

public interface GameState {

    void render(GameAssetsContainer gameAssetsContainer);

    GameStatesEnum nextState();

}
