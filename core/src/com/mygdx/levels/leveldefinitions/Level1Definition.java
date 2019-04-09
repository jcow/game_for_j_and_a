package com.mygdx.levels.leveldefinitions;

import com.mygdx.assets.AssetConfiguration;
import com.mygdx.assets.TextureDefinition;

import java.util.HashSet;

public class Level1Definition extends MyLevelDefinition {

    public Level1Definition() {

        this.levelFileLocation = "levels/level-test.txt";
        this.backgroundDefinition = TextureDefinition.LEVEL_MY_TEST_LEVEL;

        this.assetConfiguration = new AssetConfiguration(new HashSet<TextureDefinition>(){{
            add(TextureDefinition.LEVEL_MY_TEST_LEVEL);
        }});

    }

}
