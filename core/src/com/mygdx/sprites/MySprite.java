package com.mygdx.sprites;


public class MySprite {

    // TODO sprite x, y
    // exp - collision rect, sprite rect

    protected int xPos;
    protected int yPos;
    protected int xVel;
    protected int yVel;
    protected int width;
    protected int height;

    protected int spriteDrawX;
    protected int spriteDrawY;
    protected int spriteDrawWidth;
    protected int spriteDrawHeight;

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setXPos(int x) {
        this.xPos = x;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    public int getXVel(){
        return xVel;
    }

    public int getYVel(){
        return yVel;
    }

    public void setXVel(int xVel) {
        this.xVel = xVel;
    }

    public void setYVel(int yVel) {
        this.yVel = yVel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
