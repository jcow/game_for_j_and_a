package com.mygdx.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.menus.MainMenuMenu;
import com.mygdx.menus.MenuOptions;
import com.mygdx.players.PlayerID;


public class MainMenuState implements GameStates {

    MainMenuMenu mainMenuMenu = new MainMenuMenu();

    public MainMenuState() {

    }

    public void render(Texture background, Texture sprites, SpriteBatch batch, BitmapFont font) {

        PlayerInputManager.getInstance().setStepDelay(30);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // draw menu
        int y = 400;
        for(MenuOptions options : mainMenuMenu.getAllText()) {

            if(mainMenuMenu.isCurrentlySelectedIndex(options)) {
                font.setColor(mainMenuMenu.getSelectedColor());
            }
            else {
                font.setColor(mainMenuMenu.getNonSelectedColor());
            }

            font.draw(batch, options.getText(), 200, y);
            y -= 100;
        }

        y = 400;

        batch.end();


        if(getPlayerInputManager().isDownPressed(PlayerID.PLAYER_1)) {
            mainMenuMenu.incrementMenuOption();
        }
        else if(getPlayerInputManager().isUpPressed(PlayerID.PLAYER_1)) {
            mainMenuMenu.decrementMenuOption();
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
