package com.mygdx.assets;

public enum TextureDefinition {

    MAIN_MENU("mainmenu.png"),
    LOADING_SCREEN("loading_screen.png"),
    OVERWORLD("overworld.png");

    private String path;

    TextureDefinition(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
