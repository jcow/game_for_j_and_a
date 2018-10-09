package com.mygdx.menus;

public enum MenuOptions {

    START_GAME("Start Game"),
    END_GAME("End Game");

    private final String text;

    MenuOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
