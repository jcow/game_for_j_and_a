package com.mygdx.config;

public enum TextureDefinition {

    SPRITE_SHEET("badlogic.jpg"),
    MAIN_MENU("mainmenu.png");

    private String path;

    TextureDefinition(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
