package com.mygdx.collisions;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class GeometricCollisions {

    public boolean collides(Rectangle rectangle1, Rectangle rectangle2) {
        if(rectangle1.x < rectangle2.x + rectangle2.width &&
                rectangle1.x + rectangle1.width > rectangle2.x &&
                rectangle1.y < rectangle2.y + rectangle2.height &&
                rectangle1.y + rectangle1.height > rectangle2.y)
        {
            return true;
        }

        return false;
    }

    public boolean collides(Rectangle r1, Circle c1) {
        float closestX = clamp(c1.x, r1.x, r1.x + r1.width);
        float closestY = clamp(c1.y, r1.y - r1.height, r1.y);

        float distanceX = c1.x - closestX;
        float distanceY = c1.y - closestY;

        return Math.pow(distanceX, 2) + Math.pow(distanceY, 2) < Math.pow(c1.radius, 2);
    }

    private float clamp(float value, float min, float max) {
        float x = value;
        if (x < min) {
            x = min;
        } else if (x > max) {
            x = max;
        }
        return x;
    }
}
