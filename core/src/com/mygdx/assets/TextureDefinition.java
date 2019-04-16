package com.mygdx.assets;

public enum TextureDefinition {

    MAIN_MENU("mainmenu.png"),
    LOADING_SCREEN("loading_screen.png"),
    OVERWORLD("overworld.png"),

    LEVEL_MY_TEST_LEVEL("levels/level-test.png"),
    LEVEL_TILE("tile.png");


    private String path;

    TextureDefinition(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
