package com.mygdx.gamestates.gameplay;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.players.Player;

import java.util.List;

public class GameplayState {

    protected static GameplayState instance;

    char[][] rawLevel;

    EnemyDirectionMap enemyDirectionMap;
    Enemy enemies; // pool

    PlayerSpawn player1Spawn = new PlayerSpawn();
    PlayerSpawn player2Spawn = new PlayerSpawn();

    Array<Tower> towers = new Array<Tower>();

    LevelTiles[][] levelTiles;

    LevelGoal levelGoal;

    public void update() {

    }

    public void draw() {

    }

    public PlayerSpawn getPlayer1Spawn(){
        return player1Spawn;
    }

    public PlayerSpawn getPlayer2Spawn(){
        return player2Spawn;
    }





    /*
        Enemy spawn
        Level goal
        Enemy pathing arrays
        Towers
        Player1
        Player2


     */

    //    EnemySpawn
    char[][] enemyDirections;

//    Tower[] towers;



    Player player1;
    Player player2;

    public void setRawLevel(char[][] rawLevel) {
        this.rawLevel = rawLevel;
    }

    public void reset() {
        // TODO
    }

    public void build() {
        // TODO - raw level to stuff etc

        // TODO - validation, etc
    }




    protected GameplayState() {}

    public static GameplayState getInstance() {
        if(instance == null) {
            instance = new GameplayState();
        }

        return instance;
    }


}






class TowerPool extends Pool {

    @Override
    protected Tower newObject() {
        return new Tower();
    }

}

class TowerCreator {

    private static TowerCreator instance;

    private Pool<Tower> towerPool = new TowerPool();

    protected static TowerCreator getInstance() {
        if(instance == null) {
            instance = new TowerCreator();
        }

        return instance;
    }

    public Tower create(int x, int y) {
        Tower tower = towerPool.obtain();

        return tower;
    }

}

class Enemy {

}

class Towers {

    List<Tower> towers;

}

class Tower {

}

class EnemyDirectionMap {
    char[][] directionMap;

}

class LevelGoal {

}

class LevelTiles {

}

class Tile {

}

class PlayerSpawn {

    private int x;
    private int y;

    public PlayerSpawn() {}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

