package com.mygdx.levels;

import com.mygdx.levels.leveldefinitions.Level1Definition;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LevelDefinitionManager {

    private static LevelDefinitionManager instance;

    private LevelReader levelReader = new LevelReader();

    private Map<Class<? extends MyLevelDefinition>, MyLevelDefinition> levels = new HashMap() {{
        put(Level1Definition.class, new Level1Definition());
    }};

    public static LevelDefinitionManager getInstance() {
        if(instance == null) {
            instance = new LevelDefinitionManager();
        }

        return instance;
    }

    protected LevelDefinitionManager() {}

    public MyLevelDefinition getLevel(Class<? extends MyLevelDefinition> levelClass) {
        return levels.get(levelClass);
    }

    public void loadLevels() throws IOException {
        for(Map.Entry<Class<? extends MyLevelDefinition>, MyLevelDefinition> myLevelEntry : levels.entrySet()) {
            loadLevel(myLevelEntry.getValue());
        }
    }

    protected void loadLevel(MyLevelDefinition level) throws IOException {
        char[][] rawLevel = levelReader.read(level.getLevelFileLocation());
        level.setRawLevel(rawLevel);
    }

}
