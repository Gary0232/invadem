package invadem;

import processing.core.PApplet;
import processing.core.PImage;

public class Projectile extends Entities {
    private String direction;
    private int id;
    //the id of normal projectile is 1,the id of power projectile is 2


    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
        life = 1;
    }

    @Override
    public void move(String direction) {
    }

    /**
     * projectile will move down and up at speed 1
     **/
    public void move() {
        if (direction.equals("down")) {
            y += 10;
        }
        if (direction.equals("up")) {
            y -= 10;
        }
    }

    @Override
    public void draw(PApplet app) {
        imgs = new PImage[1];
        imgs[0] = app.loadImage("src/main/resources/projectile.png");
        app.image(imgs[currentImgIndex], x, y);
    }

    /**
     * AABB collision use the generic
     **/
    public <T extends Entities> boolean hits(T t) {
        return (this.getX() < (t.getX() + t.getWidth())) && ((this.getX() + this.getWidth()) > t.getX()) &&
                (this.getY() < (t.getY() + t.getHeight())) && ((this.getHeight() + this.getY()) > t.getY());
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

