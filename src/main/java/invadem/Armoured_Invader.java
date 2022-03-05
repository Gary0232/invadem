package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Armoured_Invader extends Invader {
    private int bonus_Score = 250;
    public Armoured_Invader(int x, int y, int width, int height) {
        super(x, y, width, height);
        life = 3;


    }

    @Override
    public void draw(PApplet app) {
        imgs = new PImage[2];
        imgs[0] = app.loadImage("src/main/resources/invader1_armoured.png");
        imgs[1] = app.loadImage("src/main/resources/invader2_armoured.png");
        app.image(imgs[currentImgIndex], x, y);
    }
    @Override
    public int getBonus_Score(){
        return this.bonus_Score;
    }
}
