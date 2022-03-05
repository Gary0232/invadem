package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Diamond extends Entities {
    //An obj from the entities to get bonus score
    int bonus_Score = 500;
    public Diamond(int x, int y, int width, int height) {
        super(x, y, width, height);
        life = 1;
    }

    @Override
    public void move(String direction) {
    }

    public void move(){
       y = y + 3;
    }

    @Override
    public void draw(PApplet app) {
        imgs = new PImage[1];
        imgs[0] = app.loadImage("src/main/resources/diamond.png");
        app.image(imgs[currentImgIndex], x, y);
    }
    public int getBonus_Score(){
        return this.bonus_Score;
    }
}
