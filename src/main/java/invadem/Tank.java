package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Tank extends Entities {
    final int speed = 1; //the tank move rate is 1.

    public Tank(int x, int y, int width, int height) {
        //Constructor
        super(x, y, width, height);
        currentImgIndex = 0;
        life = 3;//tank has 3 lives
    }

    /**
     * tank will move right and left without touch the boundary
     **/
    @Override
    public void move(String direction) {
        if (direction.equals("left") && this.x >= leftBoundary) {
            this.x -= speed;
        } else if (direction.equals("right") && this.x <= rightBoundary) {
            this.x += speed;
        }
    }

    /**
     * draw the tank
     **/
    @Override
    public void draw(PApplet app) {
        imgs = new PImage[1];
        imgs[0] = app.loadImage("src/main/resources/tank1.png");
        app.image(imgs[currentImgIndex], x, y);
    }


}
