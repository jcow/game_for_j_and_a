package com.mygdx.levels.leveldefinitions;


import com.mygdx.assets.AssetConfiguration;
import com.mygdx.assets.TextureDefinition;

public abstract class MyLevelDefinition {

    public static final int CELL_SIZE = 40;

    protected String levelFileLocation;
    protected AssetConfiguration assetConfiguration;
    protected TextureDefinition backgroundDefinition;
    protected char[][] rawLevel;

    public String getLevelFileLocation(){
        return levelFileLocation;
    }

    public AssetConfiguration getAssetConfiguration() {
        return assetConfiguration;
    }

    public TextureDefinition getBackgroundDefinition(){
        return backgroundDefinition;
    }

    public char[][] getRawLevel(){
        return rawLevel;
    }

    public void setRawLevel(char[][] rawLevel) {
        this.rawLevel = rawLevel;
    }

}
