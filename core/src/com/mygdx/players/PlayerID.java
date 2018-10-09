package com.mygdx.players;

public enum PlayerID {

    PLAYER_1(1),
    PLAYER_2(2);

    private final int id;

    PlayerID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
