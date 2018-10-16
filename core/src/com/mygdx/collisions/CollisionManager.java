package com.mygdx.collisions;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.util.Pair;
import org.w3c.dom.css.Rect;

import java.util.List;

public class CollisionManager {

    public Rectangle getNewUserToWorldCollisionRectangles(List<Rectangle> worldCollidables, Rectangle userRectangle, int stepX, int stepY) {

        Pair<Rectangle, Rectangle> closestXY = getClosestXandYCollidables(worldCollidables, userRectangle, stepX, stepY);

        return getNewXY(closestXY, userRectangle, stepX, stepY);
    }

    /**
     * This assumes you're already colliding with the closest rectangles
     */
    protected Rectangle getNewXY(Pair<Rectangle, Rectangle> closestXY, Rectangle userRectangle, int stepX, int stepY) {
        Rectangle newUserRectangleX = createNewRectangleFromStep(userRectangle, stepX, 0);
        Rectangle newUserRectangleY = createNewRectangleFromStep(userRectangle, 0, stepY);

        Rectangle closestX = closestXY.getFirst();
        Rectangle closestY = closestXY.getSecond();

        float newX = newUserRectangleX.x;
        float newY = newUserRectangleY.y;

        if(closestX != null) {

            if(stepX > 0) {
                newX = closestX.x - newUserRectangleX.width;
            }
            else if(stepX < 0) {
                newX = closestX.x + closestX.width;
            }

        }

        if(closestY != null) {

            if(stepY > 0) {
                newY = closestY.y - newUserRectangleY.height;
            }
            else if(stepY < 0) {
                newY = closestY.y + newUserRectangleY.height;
            }

        }

        return new Rectangle(newX, newY, userRectangle.width, userRectangle.height);
    }

    protected Pair<Rectangle, Rectangle> getClosestXandYCollidables(List<Rectangle> worldCollidables, Rectangle userRectangle, int stepX, int stepY) {
        Rectangle newUserRectangleX = createNewRectangleFromStep(userRectangle, stepX, 0);
        Rectangle newUserRectangleY = createNewRectangleFromStep(userRectangle, 0, stepY);

        float closestDistanceX = Float.MAX_VALUE;
        float closestDistanceY = Float.MAX_VALUE;
        Rectangle closestCollidingX = null;
        Rectangle closestCollidingY = null;

        for(Rectangle rectangle : worldCollidables) {
            if(isColliding(rectangle, newUserRectangleX)) {
                float distance = getDistance(getCenter(rectangle).x, getCenter(newUserRectangleX).x);
                if(distance < closestDistanceX) {
                    closestDistanceX = distance;
                    closestCollidingX = rectangle;
                }
            }

            if(isColliding(rectangle, newUserRectangleY)) {
                float distance = getDistance(getCenter(rectangle).y, getCenter(newUserRectangleX).y);
                if(distance < closestDistanceY) {
                    closestDistanceY = distance;
                    closestCollidingY = rectangle;
                }
            }
        }

        return new Pair(closestCollidingX, closestCollidingY);
    }

    protected Rectangle getNewStationaryMovingRectangle(Rectangle stationaryRectangle, Rectangle movingRectangle, int stepX, int stepY) {
        Rectangle newMovingRectangle = createNewRectangleFromStep(movingRectangle, stepX, stepY);

        /**
         * Need to check x first to see if there are collisions, if so, then need to resolve for x
         * Need to then do the same for the Y
         */

        float newX = movingRectangle.x;
        float newY = movingRectangle.y;

        if(stepX > 0) {
            newX = stationaryRectangle.x - newMovingRectangle.width;
        }
        else if(stepX < 0) {
            newX = stationaryRectangle.x + stationaryRectangle.width;
        }

        if(stepY > 0) {
            newY = stationaryRectangle.y + stationaryRectangle.height;
        }
        else if(stepY < 0) {
            newY = stationaryRectangle.y + newMovingRectangle.height;
        }

        return new Rectangle(
            newX,
            newY,
            movingRectangle.width,
            movingRectangle.height
        );

    }

    public Rectangle createNewRectangleFromStep(Rectangle rectangle, int stepX, int stepY) {
        return new Rectangle(
            rectangle.x + stepX,
            rectangle.y + stepY,
            rectangle.width,
            rectangle.height
        );
    }

    public boolean isColliding(Rectangle rectangle1, Rectangle rectangle2) {
        if(rectangle1.x < rectangle2.x + rectangle2.width &&
                rectangle1.x + rectangle1.width > rectangle2.x &&
                rectangle1.y < rectangle2.y + rectangle2.height &&
                rectangle1.y + rectangle1.height > rectangle2.y)
        {
            return true;
        }

        return false;
    }

    private float getDistance(float a, float b) {
        return Math.abs(a - b);
    }

    private Vector2 getCenter(Rectangle rectangle) {
        Vector2 vector2 = new Vector2();
        return rectangle.getCenter(vector2);
    }



}
