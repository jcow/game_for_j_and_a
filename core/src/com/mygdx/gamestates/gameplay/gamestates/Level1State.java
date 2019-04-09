package com.mygdx.gamestates.gameplay.gamestates;

import com.mygdx.gamestates.GameStatesEnum;
import com.mygdx.levels.LevelDefinitionManager;
import com.mygdx.levels.leveldefinitions.Level1Definition;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;

import java.io.IOException;

// https://github.com/libgdx/libgdx/wiki/Memory-management
// https://github.com/libgdx/libgdx/wiki/Collections

public class Level1State extends DefaultLevelState {

    public Level1State() {

    }

    public void load() {
        super.load(LevelDefinitionManager.getInstance().getLevel(Level1Definition.class));
    }

    public void render() {
        super.render(LevelDefinitionManager.getInstance().getLevel(Level1Definition.class));
    }

    public void unload() {
        // todo
    }

    public GameStatesEnum nextState() {
//        if() {
//            return GameStatesEnum.OVERWORLD;
//        }

        return null;
    }

}


