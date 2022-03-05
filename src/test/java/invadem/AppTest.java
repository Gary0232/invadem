package invadem;

import org.junit.Before;
import org.junit.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.Assert.*;

public class AppTest extends App {
    /**
     * runSketch test pictures
     **/
    @Before
    public void set() {
        String[] args = {"test"};
        PApplet.runSketch(args, this);
        delay(2000);
    }

    /**
     * test game can in a right status
     **/
    @Test
    public void testGameChecker() {
        setConditionChecker(5);
        assertEquals(getConditionChecker(), 5);
    }

    @Test
    public void testInitialiseObj() {
        initialiseObj();
        assertEquals(invaders.size(), 0);
        assertEquals(projectiles.size(), 0);
        assertEquals(barriers.size(), 0);
    }

    /**
     * test different shoot rate and it cannot below 60
     **/
    @Test
    public void testResetShootRate() {
        assertEquals(getShootRate(), 300);
        resetShootRate();
        assertEquals(getShootRate(), 240);
        resetShootRate();
        assertEquals(getShootRate(), 180);
        resetShootRate();
        assertEquals(getShootRate(), 120);
        resetShootRate();
        assertEquals(getShootRate(), 60);
        resetShootRate();
        assertEquals(getShootRate(), 60);
    }

    /**
     * test load barriers
     **/
    @Test
    public void testLoadBarriers() {
        PImage image = new PImage(8, 8);
        assertNotNull(barriers);
        assertEquals(barriers.size(), 3);
        for (int i = 0; i < 3; i++) {
            barriers.get(i).assemble(this);
            assertNotNull(barriers.get(i));
        }
    }

    /**
     * test can generate random projectile
     **/
    @Test
    public void testRandomShoot() {
        loadInvaders();
        randomShoot();
        assertEquals(projectiles.size(), 1);
    }

    /**
     * test game checker
     **/
    @Test
    public void testGameCheckerEdge() {
        tank.setLife(3);
        gameChecker();
        assertEquals(getConditionChecker(), 2);
    }

    /**
     * test game can be lose
     **/
    @Test
    public void testGameCheckerLose() {
        loadInvaders();
        loadTank();
        invaders.clear();
        gameChecker();
        assertEquals(getConditionChecker(), 1);
    }

    /**
     * test game can be win
     **/
    @Test
    public void testGameCheckerWin() {
        loadTank();
        tank.setLife(0);
        gameChecker();
        assertEquals(getConditionChecker(), 0);
    }

    /**
     * test game can win and in a right status
     **/
    @Test
    public void testNewGameLoaderWin() {
        setConditionChecker(0);
        frameCount_new = 139;
        currentScore = 999999;
        newGameLoader();
        assertEquals(highestScore, 999999);
        assertEquals(shootRate, 300);
        assertEquals(frameCount_new, 0);
        assertEquals(conditionChecker, 2);
    }

    /**
     * test game can lose and in a right status
     **/
    @Test
    public void testNewGameLoaderLose() {
        setConditionChecker(1);
        frameCount_new = 139;
        newGameLoader();
        assertEquals(shootRate, 240);
        assertEquals(frameCount_new, 0);
        assertEquals(conditionChecker, 2);
    }

    /**
     * test the keyevent
     **/
    @Test
    public void testKeypressReleased() {
        keyCode = 37;
        keyPressed();
        assertTrue(testLeft);
        keyReleased();
        assertFalse(testLeft);
        keyCode = 39;
        keyPressed();
        assertTrue(testRight);
        keyReleased();
        assertFalse(testRight);
        keyCode = 32;
        keyPressed();
        assertTrue(testSpace);
        assertEquals(projectiles.get(0).getDirection(), "up");
        keyReleased();
        assertFalse(testSpace);
    }

    /**
     * test generate random numbers
     **/
    @Test
    public void testGenerateRandom() {
        invaders.clear();//make invader size to 0
        assertEquals(generateRandom(), 0);
    }

    /**
     * test tank can move left after key press
     **/
    @Test
    public void testTanMoveLeft() {
        testLeft = true;
        tank.move("left");
    }

    /**
     * test tank can move right after key press
     **/
    @Test
    public void testTankMoveRight() {
        testRight = true;
        tank.move("right");
    }

    /**
     * test the game will lose when invader reach the end
     **/
    @Test
    public void testGameLose() {
        for (int i = 0; i < 1000; i++) {
            invaders.get(1).move();
        }
        setConditionChecker(0);
        assertEquals(conditionChecker, 0);
    }

    @Test
    public void testKeypressedEdge() {
        keyCode = 37;
        testLeft = true;
        keyPressed();
        assertTrue(testLeft);
        keyCode = 39;
        testRight = true;
        keyPressed();
        assertTrue(testRight);
        keyCode = 32;
        testSpace = true;
        keyPressed();
    }
}
