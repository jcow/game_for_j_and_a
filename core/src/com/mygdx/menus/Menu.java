package com.mygdx.menus;

import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    protected List<MenuOptions> options = new ArrayList();
    protected int currentlySelectedIndex;

    protected Color selectedColor = Color.WHITE;
    protected Color nonSelectedColor = Color.LIGHT_GRAY;

    public void incrementMenuOption() {
        if(currentlySelectedIndex >= options.size() - 1) {
            currentlySelectedIndex = 0;
        }
        else {
            currentlySelectedIndex++;
        }
    }

    public void decrementMenuOption(){
        if(currentlySelectedIndex <= 0) {
            currentlySelectedIndex = options.size() - 1;
        }
        else {
            currentlySelectedIndex--;
        }
    }

    public Color getSelectedColor(){
        return selectedColor;
    }

    public Color getNonSelectedColor(){
        return nonSelectedColor;
    }

    public List<MenuOptions> getAllText() {
        return options;
    }

    public MenuOptions getCurrentOption(){
        return options.get(currentlySelectedIndex);
    }

    public boolean isCurrentlySelectedIndex(MenuOptions option) {
        return options.get(currentlySelectedIndex) == option;
    }
}
