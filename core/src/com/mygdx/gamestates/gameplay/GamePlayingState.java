package com.mygdx.gamestates.gameplay;

import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.game.UpdateManager;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.levels.LevelDefinitionManager;
import com.mygdx.levels.leveldefinitions.Level1Definition;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;

public class GamePlayingState extends GameStateMaster {

    private UpdateManager updateManager;

    MyLevelDefinition currentLevel = LevelDefinitionManager.getInstance().getLevel(Level1Definition.class);


    // IDK if we should use this anymore


    public GamePlayingState() {
        updateManager = new UpdateManager();
    }

    public void load() {

//        // TODO - how to state which level we're on from the overworld?
//
//        PlayerInputManager.getInstance().resetStepDelay();
//
//        // load the level's needed assets
//        GameAssetsContainer.getInstance().load(currentLevel.getAssetConfiguration());
//
//        MABYE NOT DO IT THIS WAY.  MAYBE HAVE EACH LEVEL AS A GAME STATE THAT YOU CHANGE TO.
//        MAYBE HAVE THE PLAYING GAME STATE BE A GLOBAL THAT'S MODIFIED THROUGH EACH LEVEL... MAYBE.

    }

    public void unload() {
        // TODO reset the level
    }

    @Override
    public void render() {

        super.render();

        GameAssetsContainer.getInstance().getSpriteBatch().begin();

        GameAssetsContainer.getInstance().getFont().draw(GameAssetsContainer.getInstance().getSpriteBatch(), "Sup bro", 10, 10);


        GameAssetsContainer.getInstance().getSpriteBatch().end();

//
//        GameAssetsContainer.getInstance().getInstance().getSpriteBatch().begin();
//
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        GameAssetsContainer.getInstance().getSpriteBatch().draw(
//            GameAssetsContainer.getInstance().getTexture(currentLevel.getBackgroundDefinition()), 0,0
//        );
//
//        GameAssetsContainer.getInstance().getInstance().getSpriteBatch().end();




//        gameAssetsContainer.getSpriteBatch().begin();

//        gameAssetsContainer.getSpriteBatch().draw(
//            gameAssetsContainer.getTextures().get(TextureDefinition.SPRITE_SHEET),
//            players[0].getSprite().getXPos(), players[0].getSprite().getYPos(),
//            players[0].getSprite().getWidth(), players[0].getSprite().getHeight()
//        );


//        gameAssetsContainer.getSpriteBatch().end();

        // update
//        updateManager.update(null, players);

    }

    @Override
    public GameStatesEnum nextState() {

//        if(PlayerInputManager.getInstance().isCancelledPressed(PlayerID.PLAYER_1)){
//            return GameStatesEnum.GAME_PAUSED;
//        }

        return null;
    }
}
