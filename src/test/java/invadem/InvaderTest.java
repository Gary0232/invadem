package invadem;

import org.junit.Test;

import static org.junit.Assert.*;


public class InvaderTest {

    @Test
    public void testInvaderConstruction() {
        Invader inv = new Invader(20, 20, 20, 20);
        assertNotNull(inv);
    }

    /**
     * test invader has correct started life
     **/
    @Test
    public void testInvaderLife() {
        Invader inv = new Invader(20, 20, 20, 20);
        assertEquals(inv.getLife(), 1);
    }

    /**
     * test invader can move left
     **/
    @Test
    public void testInvaderMoveLeft() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.move("left");
        assertEquals(inv.getX(), 19);
    }

    /**
     * test invader can move right
     **/
    @Test
    public void testInvaderMoveRight() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.move("right");
        assertEquals(inv.getX(), 21);
    }

    /**
     * test invader can move down
     **/
    @Test
    public void testInvaderMoveDown() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.move("down");
        assertEquals(inv.getY(), 21);
    }

    /**
     * test invader can be hit
     **/
    @Test
    public void testInvaderHit() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.isHit();
        assertEquals(inv.getLife(), 0);
    }

    /**
     * test invader has correct bonus score
     **/
    @Test
    public void testInvaderScore() {
        Invader inv = new Invader(20, 20, 20, 20);
        assertEquals(inv.getBonus_Score(), 100);
    }

    /**
     * test invader can move down at correct time
     **/
    @Test
    public void testInvaderMove1() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.setFrameCounter(60);
        inv.move();
        assertEquals(inv.getY(), 28);
        assertEquals(inv.getFrameCounter(), 1);
        assertEquals(inv.getCounter(), 1);
    }

    /**
     * test invader can move right at correct time
     **/
    @Test
    public void testInvaderMove2() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.setFrameCounter(20);
        inv.setCounter(2);
        inv.move();
        assertEquals(inv.getX(), 21);
        assertEquals(inv.getFrameCounter(), 21);
        assertEquals(inv.getCounter(), 2);
    }

    /**
     * test invader can move left at correct time
     **/
    @Test
    public void testInvaderMove3() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.setFrameCounter(20);
        inv.setCounter(3);
        inv.move();
        assertEquals(inv.getX(), 19);
        assertEquals(inv.getFrameCounter(), 21);
        assertEquals(inv.getCounter(), 3);
    }
    @Test
    public void testInvaderMove4() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.setFrameCounter(21);
        inv.setCounter(2);
        inv.move();
        assertEquals(inv.getX(), 20);
        assertEquals(inv.getFrameCounter(), 22);
        assertEquals(inv.getCounter(), 2);
    }

    /**
     * get method test
     **/
    @Test
    public void testInvaderProporties() {
        Invader inv = new Invader(20, 20, 20, 20);
        assertEquals(inv.getHeight(), 20);
        assertEquals(inv.getWidth(), 20);
    }

    /**
     * test invader can have different life
     **/
    @Test
    public void testInvaderSetLife() {
        Invader inv = new Invader(20, 20, 20, 20);
        inv.setLife(10);
        assertEquals(inv.getLife(), 10);
    }

}
