package com.mygdx.gamestates.gameplay;

import com.mygdx.creators.PlayerCreator;
import com.mygdx.game.UpdateManager;
import com.mygdx.gamestates.GameStateMaster;
import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.levels.LevelBuilder;
import com.mygdx.levels.MyLevel;
import com.mygdx.managers.PlayerInputManager;
import com.mygdx.players.Player;
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

    public void load() {
        PlayerInputManager.getInstance().resetStepDelay();
    }

    @Override
    public void render() {

        super.render();




//        gameAssetsContainer.getSpriteBatch().begin();

//        gameAssetsContainer.getSpriteBatch().draw(
//            gameAssetsContainer.getTextures().get(TextureDefinition.SPRITE_SHEET),
//            players[0].getSprite().getXPos(), players[0].getSprite().getYPos(),
//            players[0].getSprite().getWidth(), players[0].getSprite().getHeight()
//        );


//        gameAssetsContainer.getSpriteBatch().end();

        // update
        updateManager.update(null, players);

    }

    @Override
    public GameStatesEnum nextState() {

//        if(PlayerInputManager.getInstance().isCancelledPressed(PlayerID.PLAYER_1)){
//            return GameStatesEnum.GAME_PAUSED;
//        }

        return null;
    }
}
