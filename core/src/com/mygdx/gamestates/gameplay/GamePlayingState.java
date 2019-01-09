package com.mygdx.gamestates.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.assets.GameAssetsContainer;
import com.mygdx.config.TextureDefinition;
import com.mygdx.creators.PlayerCreator;
import com.mygdx.game.UpdateManager;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.levels.LevelBuilder;
import com.mygdx.levels.MyLevel;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.Player;
import com.mygdx.players.PlayerID;
import java.util.List;

public class GamePlayingState extends GameStateMaster {

    UpdateManager updateManager;

    Player[] players;

    MyLevel currentLevel;
    List<MyLevel> levels;

    public GamePlayingState() {

        updateManager = new UpdateManager();
        PlayerCreator playerCreator = new PlayerCreator();
        Player player1 = playerCreator.createPlayer1();

        players = new Player[1];

        levels = new LevelBuilder().buildLevels();
        currentLevel = levels.get(0);

        player1.getSprite().setXPos(currentLevel.getPlayerSpawn().getFirst());
        player1.getSprite().setYPos(currentLevel.getPlayerSpawn().getSecond());

        players[0] = player1;
    }

    @Override
    public void render(GameAssetsContainer gameAssetsContainer) {

        super.render(gameAssetsContainer);

        PlayerInputManager.getInstance().setStepDelay(0);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameAssetsContainer.getSpriteBatch().begin();

        gameAssetsContainer.getSpriteBatch().draw(
            gameAssetsContainer.getTextures().get(TextureDefinition.SPRITE_SHEET),
            players[0].getSprite().getXPos(), players[0].getSprite().getYPos(),
            players[0].getSprite().getWidth(), players[0].getSprite().getHeight()
        );


        gameAssetsContainer.getSpriteBatch().end();

        // update
        updateManager.update(null, players);

    }

    @Override
    public GameStatesEnum nextState() {

        if(PlayerInputManager.getInstance().isCancelledPressed(PlayerID.PLAYER_1)){
            return GameStatesEnum.GAME_PAUSED;
        }

        return null;
    }
}
