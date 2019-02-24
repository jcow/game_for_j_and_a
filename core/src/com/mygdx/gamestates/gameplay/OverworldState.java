package com.mygdx.gamestates.gameplay;

import com.mygdx.assets.AssetConfiguration;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.assets.TextureDefinition;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.PlayerID;

import java.util.HashSet;
import java.util.Set;

public class OverworldState extends GameStateMaster {

    AssetConfiguration assetConfiguration;

    public OverworldState() {
        Set<TextureDefinition> textures = new HashSet<TextureDefinition>();
        textures.add(TextureDefinition.OVERWORLD);

        this.assetConfiguration = new AssetConfiguration(textures);
    }

    public void load() {
        GameAssetsContainer.getInstance().load(assetConfiguration);
        PlayerInputManager.getInstance().resetStepDelay();
    }

    @Override
    public void render() {

        GameAssetsContainer.getInstance().getSpriteBatch().begin();

        // draw background
        GameAssetsContainer.getInstance().getSpriteBatch().draw(
                GameAssetsContainer.getInstance().getTexture(TextureDefinition.OVERWORLD),
                0f, 0f, 1920, 1080
        );

        GameAssetsContainer.getInstance().getSpriteBatch().end();
    }

    @Override
    public GameStatesEnum nextState() {
        if(PlayerInputManager.getInstance().isActionPressed(PlayerID.PLAYER_1)){
            return GameStatesEnum.LEVEL_1;
        }

        return null;
    }
}
