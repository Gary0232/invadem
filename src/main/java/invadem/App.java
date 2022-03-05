package invadem;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PFont;
//import ddf.minim;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends PApplet {
    public Tank tank;
    //initialize the user object
    public boolean testSpace, testRight, testLeft;
    int shootRate = 300;
    public int timeCounter = 0;//count the time
    public int conditionChecker = 2;
    //starts for 2 ,if computer win, it will change to 0,if player win, it will change to 1.
    public int highestScore = 10000;
    public int currentScore;
    public List<Projectile> projectiles = new ArrayList<>();
    public List<Invader> invaders = new ArrayList<>();
    public List<Barrier> barriers = new ArrayList<>();
    public List<Diamond> diamonds = new ArrayList<>();
    public Power_Invader pw;
    public AudioPlayer player1,player2;//music player
    public int frameCount_new = 0;

    public App() {
    }

    /**
     * set up for all objects
     **/
    @Override
    public void setup() {
        frameRate(60);
        loadTank();
        loadInvaders();
        loadBarriers();
        loadDiamond();
        Minim minim = new Minim(this);
        player1 = minim.loadFile("src/main/resources/sound1.wav");//shoot music
        player2 = minim.loadFile("src/main/resources/sound2.mp3",1024);//backgroud music
        //loop the backgroud music
    }


    @Override
    public void settings() {
        size(640, 480);
    }

    /**
     * load three barriers in a list
     **/
    public void loadBarriers() {
        Barrier barrier_left = new Barrier(200, 400, 8, 8);
        Barrier barrier_mid = new Barrier(320, 400, 8, 8);
        Barrier barrier_right = new Barrier(440, 400, 8, 8);
        barriers.add(barrier_left);
        barriers.add(barrier_mid);
        barriers.add(barrier_right);
        /*assemble all the parts of barriers and load the image*/
        for (Barrier i : barriers) {
            i.assemble(this);
        }
    }

    /**
     * load tank object
     **/
    public void loadTank() {
        tank = new Tank(320, 440, 22, 14);
    }

    /**
     * load 40 invaders object and add the into list
     **/
    public void loadInvaders() {
        int a = 30;//the distance between each invader is 30
        for (int i = 0; i < 10; i++) {
            invaders.add(new Armoured_Invader(180 + a * i, 50, 16, 16));
        }
        for (int i = 0; i < 10; i++) {
            pw = new Power_Invader(180 + a * i, 80, 16, 16);
            invaders.add(pw);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                invaders.add(new Invader(180 + a * i, 110 + a * j, 16, 16));
            }
        }
    }

    public void loadDiamond() {
        diamonds.add(new Diamond(250, 0, 8, 8));
    }

    /**
     * clear all the objects
     **/
    public void initialiseObj() {
        invaders.clear();
        projectiles.clear();
        barriers.clear();
        diamonds.clear();
        player2 = null;
    }

    /**
     * make the shootrate minus 60 seconds each time
     **/
    public void resetShootRate() {
        if (shootRate > 60) {
            shootRate = shootRate - 60;
        }
    }

    public int getShootRate() {
        return shootRate;
    }

    /**
     * generate a random number based on the invaders' list size
     **/
    public int generateRandom() {
        Random ran = new Random();
        if (invaders.size() > 0) {
            int randomNum = ran.nextInt(invaders.size());// define the range
            return randomNum;
        } else {
            return 0;
        }
    }

    /**
     * shoot randomly from the invaders
     **/
    public void randomShoot() {
        if (generateRandom() > 0) {
            //generate the random projectile
            int x = invaders.get(generateRandom()).getX();
            int y = invaders.get(generateRandom()).getY();
            //power invader will shoot the power projectile
            if (invaders.get(generateRandom()) instanceof Power_Invader) {
                Projectile p = new Projectile(x, y, 2, 5);
                p.setId(0);
                p.setDirection("down");
                projectiles.add(p);
            } else {
                Projectile p = new Projectile(x, y, 1, 3);
                p.setId(1);
                p.setDirection("down");
                projectiles.add(p);
            }
            //generate a random diamond
            Random ran = new Random();
            int randNumber = ran.nextInt(460 - 180 + 1) + 180;
            diamonds.add(new Diamond(randNumber, 0, 8, 8));
        }
    }

    /**
     * check the game whether it win or lose
     **/
    public void gameChecker() {
        if (invaders.size() == 0) {
            setConditionChecker(1);
        }
        if (tank.getLife() <= 0) {
            setConditionChecker(0);
        }
    }

    /**
     * load the next level or new game depends on ConditionChecker status
     **/
    public void newGameLoader() {
        if (getConditionChecker() == 1) {
            //player win
            background(0);
            image(this.loadImage("src/main/resources/nextlevel.png"), 250, 220, 130, 40);
            frameCount_new++;
            if (frameCount_new == 140) {
                initialiseObj();
                setup();
                setConditionChecker(2);
                resetShootRate();
                frameCount_new = 0;
            }
        }
        if (getConditionChecker() == 0) {
            //computer win
            background(0);
            image(this.loadImage("src/main/resources/gameover.png"), 250, 220, 130, 40);
            frameCount_new++;
            if (currentScore > highestScore) {
                highestScore = currentScore;
                currentScore = 0;
            }else{
                currentScore = 0;
            }
            if (frameCount_new == 140) {
                initialiseObj();
                setup();
                setConditionChecker(2);
                frameCount_new = 0;
            }
            shootRate = 300;
        }
    }

    public void setConditionChecker(int i) {
        conditionChecker = i;
    }

    public int getConditionChecker() {
        return conditionChecker;
    }

    /**
     * if press the left ,right or space key ,left and right for move ,and the space is used for shoot
     **/
    @Override
    public void keyPressed() {
        if (keyCode == 37 && !testLeft) {
            testLeft = true;
        }
        if (keyCode == 39 && !testRight) {
            testRight = true;

        }
        if (keyCode == 32 && !testSpace) {
            testSpace = true;
            Projectile p = new Projectile(tank.getX() + 11, tank.getY() + 2, 1, 3);
            p.setDirection("up");
            projectiles.add(p);
            player1.play();
            player1.rewind();
        }
    }

    /**
     * if release the left ,right or space key
     **/
    @Override
    public void keyReleased() {
        if (keyCode == 37) {
            testLeft = false;
        }
        if (keyCode == 39) {
            testRight = false;
        }
        if (keyCode == 32) {
            testSpace = false;
        }
    }

    @Override
    public void draw() {
        //Main Game Loop
        background(0);//black background
        PFont myFont = createFont("src/main/resources/PressStart2P-Regular.tff", 15);
        textFont(myFont, 15);
        text("Current Score: " + currentScore, 10, 30);
        text("High Score: " + highestScore, 460, 30);
        text("Tank life: " + tank.getLife(), 10, 50);
        tank.draw(this);//draw the tank
        if (testLeft) {
            tank.move("left");
        }
        if (testRight) {
            tank.move("right");
        }
        //generate the projectile
        if (timeCounter == getShootRate()) {
            randomShoot();
            timeCounter = 0;
        } else {
            timeCounter++;
        }
        //draw the diamond
        for (Diamond i : diamonds) {
            i.draw(this);
            i.move();
        }
        //draw the invaders
        for (Invader i : invaders) {
            i.draw(this);
            i.move();
            //if invaders reach the barrier the player will lose
            if (i.getY() > 370) {
                setConditionChecker(0);
            }
        }
        //draw the barriers
        for (Barrier i : barriers) {
            i.draw(this);
        }
        //draw the projectiles come from the tank
        for (Projectile i : projectiles) {
            i.draw(this);
            i.move();
            //if projectile hits the invaders or barriers, they will change the status
            if (i.getDirection().equals("up")) {
                for (Invader j : invaders) {
                    if (i.hits(j)) {
                        i.isHit();
                        j.isHit();
                    }
                }
                for (Barrier b : barriers) {
                    for (Component c : b.getComponents()) {
                        if (c.getLife() > 0 && i.hits(c)) {
                            i.isHit();
                            c.isHit();
                        }
                    }
                }
                for (Diamond d : diamonds) {
                    if (i.hits(d)) {
                        i.isHit();
                        d.isHit();
                    }
                }
            }
            //if the downwards projectile hits the tank and barrier, they will change the status
            else if (i.getDirection().equals("down")) {
                //if it is the power projectile
                if (i.getId() == 0) {
                    if (i.hits(tank)) {
                        i.isHit();
                        tank.setLife(0);
                    }
                    for (Barrier b : barriers) {
                        for (Component c : b.getComponents()) {
                            if (c.getLife() > 0 && i.hits(c)) {
                                i.isHit();
                                c.isHit();
                                c.isHit();
                                c.isHit();
                            }
                        }
                    }
                }
                //if it is normal projectile
                else if (i.getId() == 1) {
                    if (i.hits(tank)) {
                        i.isHit();
                        tank.isHit();
                    }
                    for (Barrier b : barriers) {
                        for (Component c : b.getComponents()) {
                            if (c.getLife() > 0 && i.hits(c)) {
                                i.isHit();
                                c.isHit();
                            }
                        }
                    }
                }
            }
        }
        //if the projectiles has hit it will be remove from the list
        for (int m = 0; m < projectiles.size(); m++) {
            if (projectiles.get(m).getLife() == 0) {
                projectiles.remove(m);
            }
        }

        //if the invaders has hit it will be remove from the list
        for (int k = 0; k < invaders.size(); k++) {
            if (invaders.get(k).getLife() <= 0) {
                currentScore += invaders.get(k).getBonus_Score();
                invaders.remove(k);
            }
        }
        //if the diamonds has hit it will be remove from the list
        for (int d = 0; d < diamonds.size(); d++) {
            if (diamonds.get(d).getLife() <= 0) {
                currentScore += diamonds.get(d).getBonus_Score();
                diamonds.remove(d);
            }
        }
        gameChecker();
        newGameLoader();
    }

    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }

}
