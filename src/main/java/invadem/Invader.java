package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Invader extends Entities {
    private int frameCounter = 0;//check the move direction for down
    private int counter = 0;//check the move direction for left or right
    private int bonus_Score = 100;//when it be hitted it will increase the score

    public Invader(int x, int y, int width, int height) {
        super(x, y, width, height);
        currentImgIndex = 0;//the index for changing the invaders's image
        life = 1;
    }

    @Override
    public void move(String direction) {
        if (direction.equals("left")) {
            currentImgIndex = 0;
            x--;
        }
        if (direction.equals("right")) {
            currentImgIndex = 0;
            x++;
        }
        if (direction.equals("down")) {
            currentImgIndex = 1;
            y++;
        }
    }

    @Override
    public void draw(PApplet app) {
        imgs = new PImage[2];
        imgs[0] = app.loadImage("src/main/resources/invader1.png");
        imgs[1] = app.loadImage("src/main/resources/invader2.png");
        app.image(imgs[currentImgIndex], x, y);
    }

    public void move() {
        /* after 30 pixels it will move down*/
        if (frameCounter == 60) {
            /*invader will move 8 times downwards*/
            for (int i = 0; i < 8; i++) {
                this.move("down");
            }
            frameCounter = 0;
            counter++;

        } else {
            if (frameCounter % 2 == 0) {
                if (counter % 2 == 0) {
                    this.move("right");
                }
                if (counter % 2 == 1) {
                    this.move("left");
                }
            }
        }
        frameCounter++;
    }

    public void setFrameCounter(int frameCounter) {
        this.frameCounter = frameCounter;
    }

    public int getFrameCounter() {
        return this.frameCounter;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getBonus_Score() {
        return this.bonus_Score;
    }

}