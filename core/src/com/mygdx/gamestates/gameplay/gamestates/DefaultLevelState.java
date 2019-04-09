package com.mygdx.gamestates.gameplay.gamestates;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.assets.TextureDefinition;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;

public abstract class DefaultLevelState extends GameStateMaster {

    public void load(MyLevelDefinition myLevelDefinition) {
        GameAssetsContainer.getInstance().load(myLevelDefinition.getAssetConfiguration());
    }

    public void render(MyLevelDefinition myLevelDefinition) {
        super.render();


        GameAssetsContainer.getInstance().getSpriteBatch().begin();

        // draw background
        GameAssetsContainer.getInstance().getSpriteBatch().draw(
                GameAssetsContainer.getInstance().getTexture(myLevelDefinition.getBackgroundDefinition()),
                0f, 0f, 1920, 1080
        );


        GameAssetsContainer.getInstance().getFont().setColor(Color.WHITE);
        GameAssetsContainer.getInstance().getFont().draw(GameAssetsContainer.getInstance().getSpriteBatch(), "Sup bro", 400, 400);

        GameAssetsContainer.getInstance().getSpriteBatch().end();

    }

    protected void drawBackground() {

    }

}
