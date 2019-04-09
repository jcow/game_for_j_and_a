package com.mygdx.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mygdx.levels.leveldefinitions.MyLevelDefinition;

import java.io.IOException;
import java.io.Reader;


public class LevelReader {

    private int totalRows = 1080 / MyLevelDefinition.CELL_SIZE;
    private int totalCols = 1920 / MyLevelDefinition.CELL_SIZE;

    public char[][] read(String filename) throws IOException {
        FileHandle handle = Gdx.files.local(filename);

        char[][] raw = new char[totalRows][totalCols];

        Reader buffer = handle.reader();

        int c = 0, row = 0, col = 0;
        while((c = buffer.read()) != -1) {
            char character = (char) c;

            if(character == '\n') {
                row++;
                col = 0;
            }
            else {
                raw[row][col] = character;
                col++;
            }
        }

        return raw;
    }

}