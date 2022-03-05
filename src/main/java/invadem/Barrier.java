package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Barrier {
    //each part of the barriers and it will assemble in the component class
    private int x;
    private int y;
    private int width;
    private int height;
    private Component[] components = new Component[7];

    public Barrier(int x, int y, int width, int height) {
        //Constructor
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * assemble the tank object
     **/
    public void assemble(PApplet app) {
        PImage[] top = new PImage[4];//top image array
        top[0] = app.loadImage("src/main/resources/empty.png");
        top[1] = app.loadImage("src/main/resources/barrier_top3.png");
        top[2] = app.loadImage("src/main/resources/barrier_top2.png");
        top[3] = app.loadImage("src/main/resources/barrier_top1.png");
        PImage[] right = new PImage[4];//right image array
        right[0] = app.loadImage("src/main/resources/empty.png");
        right[1] = app.loadImage("src/main/resources/barrier_right3.png");
        right[2] = app.loadImage("src/main/resources/barrier_right2.png");
        right[3] = app.loadImage("src/main/resources/barrier_right1.png");
        PImage[] left = new PImage[4];//left image array
        left[0] = app.loadImage("src/main/resources/empty.png");
        left[1] = app.loadImage("src/main/resources/barrier_left3.png");
        left[2] = app.loadImage("src/main/resources/barrier_left2.png");
        left[3] = app.loadImage("src/main/resources/barrier_left1.png");
        PImage[] solid = new PImage[4];//solid image array
        solid[0] = app.loadImage("src/main/resources/empty.png");
        solid[1] = app.loadImage("src/main/resources/barrier_solid3.png");
        solid[2] = app.loadImage("src/main/resources/barrier_solid2.png");
        solid[3] = app.loadImage("src/main/resources/barrier_solid1.png");
        components[0] = new Component(solid, x, y, 8, 8);
        components[1] = new Component(solid, x, y - 8, 8, 8);
        components[2] = new Component(solid, x + 16, y, 8, 8);
        components[3] = new Component(solid, x + 16, y - 8, 8, 8);
        components[4] = new Component(left, x, y - 16, 8, 8);
        components[5] = new Component(top, x + 8, y - 16, 8, 8);
        components[6] = new Component(right, x + 16, y - 16, 8, 8);
    }

    /**
     * draw the barriers
     **/
    public void draw(PApplet app) {
        for (Component c : components) {
            c.draw(app);
        }
    }

    public Component[] getComponents() {
        return components;
    }
}