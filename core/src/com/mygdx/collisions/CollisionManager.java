package com.mygdx.collisions;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.util.Pair;

public class CollisionManager {



    public void foobar() {

        Rectangle a = new Rectangle(1, 2, 10, 10);
        Rectangle b = new Rectangle(1, 2, 3, 5);

        // todo, if colliding, then do new stuff
    }

    public Rectangle getNewStationaryMovingRectangle(Rectangle stationaryRectangle, Rectangle movingRectangle, int stepX, int stepY) {
        Rectangle newMovingRectangle = createNewRectangleFromStep(movingRectangle, stepX, stepY);

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


}
