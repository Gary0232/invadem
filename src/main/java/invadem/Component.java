package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Component extends Entities {
    //  the main class of the barriers

    public Component(PImage[] imgs, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.imgs = imgs;
        currentImgIndex = 3;// image index to change the barrier
        life = 3;//each component has 3 lives

    }

    /**
     * if the barrier is being hit, the component will change and the index of it will also change.
     **/
    @Override
    public void isHit() {
        //barrier life must be larger than 0
        if (life > 0) {
            life--;
            currentImgIndex = life;
        }
    }

    /**
     * barrier cannot move
     **/
    @Override
    public void move(String direction) {
    }

    @Override
    public void draw(PApplet app) {
        app.image(this.imgs[currentImgIndex], x, y);
    }

}
