package com.mygdx.collisions;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollisionManagerTest {

    CollisionManager collisionManager;

    @Before
    public void before() {
        collisionManager = new CollisionManager();
    }

    /**
     * Builds a square around the user square and moves the user square around the box testing collisions
     */
    @Test
    public void getNewUserToWorldCollisionRectanglesTest() {

        int width = 10;
        int height = 10;

        // build by columns
        List<Rectangle> worldCollidables = new ArrayList();
        worldCollidables.add(new Rectangle(10, 10, width, height));
        worldCollidables.add(new Rectangle(10, 20, width, height));
        worldCollidables.add(new Rectangle(10, 30, width, height));
        worldCollidables.add(new Rectangle(10, 40, width, height));

        worldCollidables.add(new Rectangle(20, 10, width, height));
        worldCollidables.add(new Rectangle(20, 40, width, height));

        worldCollidables.add(new Rectangle(30, 10, width, height));
        worldCollidables.add(new Rectangle(30, 40, width, height));

        worldCollidables.add(new Rectangle(40, 10, width, height));
        worldCollidables.add(new Rectangle(40, 20, width, height));
        worldCollidables.add(new Rectangle(40, 30, width, height));
        worldCollidables.add(new Rectangle(40, 40, width, height));

        Rectangle userRectangle = new Rectangle(25, 25, width, height);
        
        List<Pair<Integer, Integer>> steps = new ArrayList();
        steps.add(new Pair<Integer, Integer>(-7, 0));
        steps.add(new Pair<Integer, Integer>(-7, -7));
        steps.add(new Pair<Integer, Integer>(0, -7));
        steps.add(new Pair<Integer, Integer>(7, -7));
        steps.add(new Pair<Integer, Integer>(7, 0));
        steps.add(new Pair<Integer, Integer>(7, 7));
        steps.add(new Pair<Integer, Integer>(0, 7));
        steps.add(new Pair<Integer, Integer>(-7, 7));

        for(Pair<Integer, Integer> pair: steps) {
            Rectangle newRectangle = collisionManager.getNewUserToWorldCollisionRectangles(worldCollidables, userRectangle, pair.getFirst(), pair.getSecond());
            Assert.assertTrue(20 <= newRectangle.getX() && newRectangle.getX() <= 30);
            Assert.assertTrue(20 <= newRectangle.getY() && newRectangle.getY() <= 30);
        }

    }
}
