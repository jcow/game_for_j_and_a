package com.mygdx.gamestates.gameplay;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.gamestates.gameplay.resources.sprites.Enemy;
import com.mygdx.gamestates.gameplay.resources.creators.EnemyCreator;
import com.mygdx.players.Player;

import java.util.List;

public class GameplayState {

    protected static GameplayState instance;

    char[][] rawLevel;

    EnemyDirectionMap enemyDirectionMap;


    PlayerSpawn player1Spawn = new PlayerSpawn();
    PlayerSpawn player2Spawn = new PlayerSpawn();

    Array<Tower> towers = new Array<Tower>();
    Array<Enemy> enemies = new Array<Enemy>();

    LevelTiles[][] levelTiles;

    LevelGoal levelGoal;

    public void load(char[][] rawLevel) {

        this.rawLevel = rawLevel;

        this.enemies.add(EnemyCreator.getInstance().create(10, 10));


    }

    public void update() {

        // TODO iterator memory... :|
        for(int i = 0; i < enemies.size; i++) {
            enemies.get(i).setX(enemies.get(i).getX() + 1);
            enemies.get(i).setY(enemies.get(i).getY() + 1);
        }

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

    Player player1;
    Player player2;

    public char[][] getRawLevel() {
        return this.rawLevel;
    }

    public void reset() {
        // TODO
    }

    public Array<Enemy> getEnemies(){
        return enemies;
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

        // set attributes

        return tower;
    }

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

