package com.mygdx.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.List;

public class LevelLoader {

    private static LevelLoader instance = null;

    private List<MyLevel> levels = new ArrayList<MyLevel>();

    public static LevelLoader getInstance() {
        if(instance == null) {
            instance = new LevelLoader();
        }

        return instance;
    }

    public void loadLevels() {

    }

    public MyLevel load() {
        FileHandle handle = Gdx.files.internal("levels/level1.txt");
        String contents = handle.readString();

        return null;
    }

}
