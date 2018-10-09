package com.mygdx.gamestates;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameStates {

    void render(Texture background, Texture sprites, SpriteBatch batch, BitmapFont font);

    String newState();

    String getID();
}
