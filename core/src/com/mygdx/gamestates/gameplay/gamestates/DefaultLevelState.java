package com.mygdx.gamestates.gameplay.gamestates;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.assets.TextureDefinition;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.gamestates.gameplay.GameplayState;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;

public abstract class DefaultLevelState extends GameStateMaster {

    public void load(MyLevelDefinition myLevelDefinition) {

        // load textures
        GameAssetsContainer.getInstance().load(myLevelDefinition.getAssetConfiguration());

        // load gameplay
        GameplayState.getInstance().load(myLevelDefinition.getRawLevel());
    }

    public void render(MyLevelDefinition myLevelDefinition) {
        super.render();

        GameplayState.getInstance().update();

        GameAssetsContainer.getInstance().getSpriteBatch().begin();

        // debug stuff for drawing things
        // Why aren't things aren't the scale I EXPECT!?
        for(int y = 0; y < GameplayState.getInstance().getRawLevel().length * 40; y+=40) {
            for(int x = 0; x < GameplayState.getInstance().getRawLevel()[0].length * 40; x+=40) {
                // draw background
                GameAssetsContainer.getInstance().getSpriteBatch().draw(
                        GameAssetsContainer.getInstance().getTexture(TextureDefinition.LEVEL_TILE),
                        x, y, 40, 40
                );
            }
        }

        // draw enemies - todo iterator
        for(int i = 0; i < GameplayState.getInstance().getEnemies().size; i++) {
            GameAssetsContainer.getInstance().getSpriteBatch().draw(
                    GameAssetsContainer.getInstance().getLoadingTexture(),
                    GameplayState.getInstance().getEnemies().get(i).getX(),
                    GameplayState.getInstance().getEnemies().get(i).getY(),
                    10, 10
            );
        }






//        // draw background
//        GameAssetsContainer.getInstance().getSpriteBatch().draw(
//                GameAssetsContainer.getInstance().getTexture(myLevelDefinition.getBackgroundDefinition()),
//                0f, 0f, 1920, 1080
//        );

        GameAssetsContainer.getInstance().getFont().setColor(Color.WHITE);
        GameAssetsContainer.getInstance().getFont().draw(GameAssetsContainer.getInstance().getSpriteBatch(), "Sup bro", 400, 400);

        GameAssetsContainer.getInstance().getSpriteBatch().end();
    }

    // draw manager...?
    protected void draw() {



    }

}
