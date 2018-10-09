package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.managers.GameStateManager;
import com.mygdx.managers.PlayerInputManager;

public class MyGdxGame extends ApplicationAdapter {


	GameStateManager gameStateManager;

    private SpriteBatch batch;
    private Texture background;
    private Texture sprites;
    private BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		sprites = new Texture("badlogic.jpg");
		gameStateManager = new GameStateManager();
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();

		PlayerInputManager.getInstance().step();

        try {
            gameStateManager.render(background, sprites, batch, font);
        } catch (Exception e) {
            // TODO
        }
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
        font.dispose();
	}
}
