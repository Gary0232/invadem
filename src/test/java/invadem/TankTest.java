package invadem;

import org.junit.Test;

import static org.junit.Assert.*;

public class TankTest {

    @Test
    public void testTankConstruction() {
        Tank tank = new Tank(10, 10, 10, 10);
        assertNotNull(tank);
    }

    /**
     * test tank can move left
     **/
    @Test
    public void testTankMoveLeft() {
        Tank tank = new Tank(200, 10, 10, 10);
        tank.move("left");
        assertEquals(tank.getX(), 199);
    }

    /**
     * test tan can move right
     **/
    @Test
    public void testTankMoveRight() {
        Tank tank = new Tank(200, 10, 10, 10);
        tank.move("right");
        assertEquals(tank.getX(), 201);
    }

    /**
     * test tank can be hit and has correct life
     **/
    @Test
    public void testTankHit() {
        Tank tank = new Tank(200, 10, 10, 10);
        tank.isHit();
        assertEquals(tank.getLife(), 2);
    }

    /**
     * after 3 hits tank will be destoryed
     **/
    @Test
    public void testTankDestroy() {
        Tank tank = new Tank(200, 10, 10, 10);
        tank.isHit();
        tank.isHit();
        tank.isHit();
        assertEquals(tank.getLife(), 0);
    }

    /**
     * test tank can be hit correctly
     **/
    @Test
    public void testTankHitPoints() {
        Tank tank = new Tank(200, 10, 10, 10);
        tank.isHit();
        tank.isHit();
        assertEquals(tank.getLife(), 1);
    }

    /**
     * test the speed of tank is 1
     **/
    @Test
    public void testTankSpeed() {
        Tank tank = new Tank(200, 10, 10, 10);
        assertEquals(tank.speed, 1);
    }

    /**
     * test tank can hit and move
     **/
    @Test
    public void testTankHitWithMove() {
        Tank tank = new Tank(200, 10, 10, 10);
        tank.isHit();
        tank.move("left");
        assertEquals(tank.getLife(), 2);
        assertEquals(tank.getX(), 199);
    }

    /**
     * test tank cannot move out of edge
     **/
    @Test
    public void testTankMoveLeftEdge() {
        Tank tank = new Tank(100, 10, 10, 10);
        tank.move("left");
        assertEquals(tank.getX(), 100);
    }

    /**
     * test tank cannot move out of edge
     **/
    @Test
    public void testTankMoveRightEdge() {
        Tank tank = new Tank(500, 10, 10, 10);
        tank.move("right");
        assertEquals(tank.getX(), 500);
    }

}
