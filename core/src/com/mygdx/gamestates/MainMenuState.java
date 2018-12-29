package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.config.TextureDefinition;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.menus.MainMenuMenu;
import com.mygdx.menus.MenuOptions;
import com.mygdx.players.PlayerID;


public class MainMenuState extends GameStateMaster {

    MainMenuMenu mainMenuMenu = new MainMenuMenu();

    public MainMenuState() {

    }

    public void render(GameAssetsContainer gameAssetsContainer) {

        super.render(gameAssetsContainer);

        PlayerInputManager.getInstance().setStepDelay(30);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameAssetsContainer.getSpriteBatch().begin();

        // draw background
        gameAssetsContainer.getSpriteBatch().draw(
            gameAssetsContainer.getTextures().get(TextureDefinition.MAIN_MENU),
                0f, 0f, 1920, 1080
        );

        // draw menu
        int y = 400;
        for(MenuOptions options : mainMenuMenu.getAllText()) {

            if(mainMenuMenu.isCurrentlySelectedIndex(options)) {
                gameAssetsContainer.getFont().setColor(mainMenuMenu.getSelectedColor());
            }
            else {
                gameAssetsContainer.getFont().setColor(mainMenuMenu.getNonSelectedColor());
            }

            gameAssetsContainer.getFont().draw(gameAssetsContainer.getSpriteBatch(), options.getText(), 200, y);
            y -= 100;
        }

        y = 400;

        gameAssetsContainer.getSpriteBatch().end();


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

    public String newState() {
        if(mainMenuMenu.getCurrentOption() == MenuOptions.START_GAME && getPlayerInputManager().isActionPressed(PlayerID.PLAYER_1)) {
            return GamePlayingState.class.getName();
        }
        // TODO quit game

        return null;
    }

    private PlayerInputManager getPlayerInputManager(){
        return PlayerInputManager.getInstance();
    }


}
