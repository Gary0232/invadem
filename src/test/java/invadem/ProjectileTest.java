package invadem;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectileTest {


    @Test
    public void testProjectileConstruction() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        assertNotNull(proj);
    }

    /**
     * test projectile can move up
     **/
    @Test
    public void testProjectileSetDirectionUp() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setDirection("up");
        assertEquals(proj.getDirection(), "up");
    }

    /**
     * test projectile can move down
     **/
    @Test
    public void testProjectileSetDirectionDown() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setDirection("down");
        assertEquals(proj.getDirection(), "down");
    }

    /**
     * test project can have different id
     **/
    @Test
    public void testProjectileSetId() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setId(1);
        assertEquals(proj.getId(), 1);
    }

    /**
     * test projectile can move up
     **/
    @Test
    public void testProjectileMoveUp() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setDirection("up");
        proj.move();
        assertEquals(proj.getY(), 2);
    }

    /**
     * test projectile can move up many times
     **/
    @Test
    public void testProjectileMoveUpMore() {
        Projectile proj = new Projectile(2, 10, 2, 2);
        proj.setDirection("up");
        proj.move();
        proj.move();
        proj.move();
        assertEquals(proj.getY(), 7);
    }

    /**
     * test projectile can move down
     **/
    @Test
    public void testProjectileMoveDown() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setDirection("down");
        proj.move();
        assertEquals(proj.getY(), 4);
    }

    /**
     * the move function in invader doesn't work
     **/
    @Test
    public void testProjectileMoveNull() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.move("up");
        assertEquals(proj.getY(), 3);
    }

    /**
     * test projectile can set different direction
     **/
    @Test
    public void testProjectileMove() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setDirection("down");
        proj.setDirection("up");
        proj.move();
        assertEquals(proj.getY(), 2);
    }

    /**
     * test projectile can be hit once
     **/
    @Test
    public void testProjectileHit() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.isHit();
        assertEquals(proj.getLife(), 0);
    }

    /**
     * test projectile only have one life
     **/
    @Test
    public void testProjectileLife() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        assertEquals(proj.getLife(), 1);
    }

    /**
     * test hit function when it not interest
     **/
    @Test
    public void testProjectileNotIntersect() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        Invader inv = new Invader(10, 10, 10, 10);
        Tank tank = new Tank(200, 200, 10, 10);
        assertFalse(proj.hits(inv));
        assertFalse(proj.hits(tank));
    }

    /**
     * test hit function when it interest
     **/
    @Test
    public void testProjectileIntersect() {
        Projectile proj = new Projectile(200, 200, 2, 2);
        Invader inv = new Invader(200, 200, 10, 10);
        Tank tank = new Tank(200, 200, 10, 10);
        assertTrue(proj.hits(inv));
        assertTrue(proj.hits(tank));
    }

    /**
     * test set up a new projectile
     **/
    @Test
    public void testSetProjlife() {
        Projectile proj = new Projectile(2, 3, 2, 2);
        proj.setLife(10);
        assertEquals(proj.getLife(), 10);
    }
    @Test
    public void testProjectileNotIntersect4() {
        Projectile proj = new Projectile(202, 299, 2, 2);
        Invader inv = new Invader(204, 200, 10, 99);
        assertFalse(proj.hits(inv));
    }

    @Test
    public void testProjectileNotIntersect3() {
        Projectile proj = new Projectile(299, 200, 99, 2);
        Invader inv = new Invader(205, 201, 10, 10);
        assertFalse(proj.hits(inv));
    }

    @Test
    public void testProjectileNotIntersect5() {
        Projectile proj = new Projectile(299, 200, 99, 2);
        Invader inv = new Invader(205, 201, 10, 1);
        assertFalse(proj.hits(inv));
    }

    @Test
    public void testProjectileNotIntersect7() {
        Projectile proj = new Projectile(200, 302, 10, 1);
        Invader inv = new Invader(200, 300, 10, 2);
        assertFalse(proj.hits(inv));
    }

    @Test
    public void testProjectileNotIntersect6() {
        Projectile proj = new Projectile(299, 200, 99, 2);
        Invader inv = new Invader(205, 200, 10, 2);
        assertFalse(proj.hits(inv));
    }

    @Test
    public void testProjectileNotIntersect8() {
        Projectile proj = new Projectile(299, 198, 99, 2);
        Invader inv = new Invader(205, 200, 10, 10);
        assertFalse(proj.hits(inv));
    }
}
