package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Power_Invader extends Invader {
    private int bonus_Score = 250;

    public Power_Invader(int x, int y, int width, int height) {
        super(x, y, width, height);
        life = 1;

    }

    @Override
    public void draw(PApplet app) {
        imgs = new PImage[2];
        imgs[0] = app.loadImage("src/main/resources/invader1_power.png");
        imgs[1] = app.loadImage("src/main/resources/invader2_power.png");
        app.image(imgs[currentImgIndex], x, y);
    }

    @Override
    public int getBonus_Score() {
        return this.bonus_Score;
    }


}
