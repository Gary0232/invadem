package invadem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Armoured_InvaderTest {


    @Test
    public void testArmoured_InvaderConstruction() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        assertNotNull(arm);
    }

    /**
     * test armoured invader life is 3
     **/
    @Test
    public void testArmoured_InvaderLife() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        assertEquals(arm.getLife(), 3);
    }

    /**
     * test armoured invader has correct score
     **/
    @Test
    public void testArmoured_InvadeScore() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        assertEquals(arm.getBonus_Score(), 250);
    }

    /**
     * test get method
     **/
    @Test
    public void testArmoured_InvaderProporties() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        assertEquals(arm.getWidth(), 10);
        assertEquals(arm.getHeight(), 10);
        assertEquals(arm.getX(), 10);
        assertEquals(arm.getY(), 10);
    }

    /**
     * test armoured invader can be hit
     **/
    @Test
    public void testArmoured_InvaderHit() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        arm.isHit();
        assertEquals(arm.getLife(), 2);
    }

    /**
     * test armoured have 0 life after 3 hits
     **/
    @Test
    public void testArmoured_InvaderDestroy() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        arm.isHit();
        arm.isHit();
        arm.isHit();
        assertEquals(arm.getLife(), 0);
    }

    /**
     * test armoured invader can set up
     **/
    @Test
    public void testArmoured_InvaderSetLife() {
        Armoured_Invader arm = new Armoured_Invader(10, 10, 10, 10);
        arm.setLife(5);
        assertEquals(arm.getLife(), 5);
    }
}
