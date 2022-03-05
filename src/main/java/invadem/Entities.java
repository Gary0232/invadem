package invadem;

import processing.core.PApplet;
import processing.core.PImage;

//the superclass for all object which can move in the game
public abstract class Entities {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected PImage[] imgs;//images array
    protected int currentImgIndex;
    protected int life;
    protected final int leftBoundary = 180;
    protected final int rightBoundary = 460;

    public Entities(int x, int y, int width, int height) {
        //Constructor
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void move(String direction);

    public abstract void draw(PApplet app);

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getLife() {
        return this.life;
    }

    public void isHit() {
        life--;
    }

    public void setLife(int life) {
        this.life = life;
    }
}