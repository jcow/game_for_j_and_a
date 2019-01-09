package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.managers.GameStateManager;

public class MyGdxGame extends ApplicationAdapter {

	GameAssetsContainer gameAssetsContainer;
	GameStateManager gameStateManager;

    private SpriteBatch batch;
    private Texture background;
    private Texture sprites;
    private BitmapFont font;
    Viewport viewport;
    Camera camera;
	
	@Override
	public void create () {

		gameStateManager = new GameStateManager();
		gameAssetsContainer = new GameAssetsContainer();

        sprites = new Texture("mainmenu.png");
        batch = new SpriteBatch();
	}

	@Override
	public void render () {

	    // Test block
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(sprites, 0, 0);
//		batch.end();
//
//
//
//		PlayerInputManager.getInstance().step();
//
//        if(PlayerInputManager.getInstance().isCancelledPressed(PlayerID.PLAYER_1)) {
//            Gdx.app.exit();
//        }



        try {
            gameStateManager.render(gameAssetsContainer);
        } catch (Exception e) {
            // TODO
        }
    }
	
	@Override
	public void dispose () {
		gameAssetsContainer.dispose();
	}
}
