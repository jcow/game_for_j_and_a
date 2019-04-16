package com.mygdx.gamestates.menus;

import com.badlogic.gdx.Gdx;
import com.mygdx.assets.AssetConfiguration;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.assets.TextureDefinition;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.menus.MainMenuMenu;
import com.mygdx.menus.MenuOptions;
import com.mygdx.players.PlayerID;

import java.util.HashSet;
import java.util.Set;


public class MainMenuState extends GameStateMaster {

    MainMenuMenu mainMenuMenu = new MainMenuMenu();
    AssetConfiguration assetConfiguration;

    public MainMenuState() {

        Set<TextureDefinition> textures = new HashSet<TextureDefinition>();
        textures.add(TextureDefinition.MAIN_MENU);

        this.assetConfiguration = new AssetConfiguration(textures);
    }

    public void load(){
        GameAssetsContainer.getInstance().load(assetConfiguration);
        PlayerInputManager.getInstance().setStepDelay(30);
    }

    public void unload() {

    }

    public void render() {

        super.render();

        GameAssetsContainer.getInstance().getSpriteBatch().begin();

        // draw background
        GameAssetsContainer.getInstance().getSpriteBatch().draw(
            GameAssetsContainer.getInstance().getTexture(TextureDefinition.MAIN_MENU),
                0f, 0f, 1920, 1080
        );

        // draw menu
        int y = 400;
        for(MenuOptions options : mainMenuMenu.getAllText()) {

            if(mainMenuMenu.isCurrentlySelectedIndex(options)) {
                GameAssetsContainer.getInstance().getFont().setColor(mainMenuMenu.getSelectedColor());
            }
            else {
                GameAssetsContainer.getInstance().getFont().setColor(mainMenuMenu.getNonSelectedColor());
            }

            GameAssetsContainer.getInstance().getFont().draw(GameAssetsContainer.getInstance().getSpriteBatch(), options.getText(), 200, y);
            y -= 100;
        }


        GameAssetsContainer.getInstance().getSpriteBatch().end();


        if(getPlayerInputManager().isDownPressed(PlayerID.PLAYER_1)) {
            mainMenuMenu.incrementMenuOption();
        }
        else if(getPlayerInputManager().isUpPressed(PlayerID.PLAYER_1)) {
            mainMenuMenu.decrementMenuOption();
        }

        if(getPlayerInputManager().isCancelledPressed(PlayerID.PLAYER_1)) {
            Gdx.app.exit();
        }
    }

    public String getID(){
        return MainMenuState.class.getName();
    }

    public GameStatesEnum nextState() {
        if(mainMenuMenu.getCurrentOption() == MenuOptions.START_GAME && getPlayerInputManager().isActionPressed(PlayerID.PLAYER_1)) {
            return GameStatesEnum.OVERWORLD;
        }

        return null;
    }

    private PlayerInputManager getPlayerInputManager(){
        return PlayerInputManager.getInstance();
    }


}
