package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.levels.LevelDefinitionManager;
import com.mygdx.managers.GameStateManager;

import java.io.IOException;

public class MyGdxGame extends ApplicationAdapter {

	GameStateManager gameStateManager;

    private SpriteBatch batch;
    private Texture background;
    private Texture sprites;
    private BitmapFont font;
    Viewport viewport;
    Camera camera;
	
	@Override
	public void create () {

        try {
            // TODO make generic game-killing runtime exception
            gameStateManager = new GameStateManager();
        } catch (IOException e) {
            throw new RuntimeException("bleh 1", e);
        }


        sprites = new Texture("mainmenu.png");
        batch = new SpriteBatch();

        try {
            LevelDefinitionManager.getInstance().loadLevels();
        } catch (IOException e) {
            // TODO make generic game-killing runtime exception
            throw new RuntimeException("bleh 2", e);
        }
	}

	@Override
	public void render () {
	    clearScreen();

	    // Test block
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(sprites, 0, 0);
//		batch.end();


        try {
            gameStateManager.render();
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
	
	@Override
	public void dispose () {
		GameAssetsContainer.getInstance().dispose();
	}

    /**
     * You need to make sure to always to call super.render and to clear every time you draw.
     * If you don't, you get screen flickering
     */
	private void clearScreen() {
        super.render();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
