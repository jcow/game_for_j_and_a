package com.mygdx.levels;

public enum Levels {

    LEVEL_1("level1");

    private final String filename;

    Levels(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

}
