package invadem;

import org.junit.Test;

import static org.junit.Assert.*;

public class Power_InvaderTest {

    @Test
    public void testPower_InvaderConstruction() {
        Power_Invader pow = new Power_Invader(10, 10, 10, 10);
        assertNotNull(pow);
    }

    /**
     * test power_invader's life is 1
     **/
    @Test
    public void testPower_InvaderLife() {
        Power_Invader pow = new Power_Invader(10, 10, 10, 10);
        assertEquals(pow.getLife(), 1);
    }

    /**
     * test power_invader has correct score
     **/
    @Test
    public void testPower_InvaderScore() {
        Power_Invader pow = new Power_Invader(10, 10, 10, 10);
        assertEquals(pow.getBonus_Score(), 250);
    }

    /**
     * test the get method
     **/
    @Test
    public void testPower_InvaderProporties() {
        Power_Invader pow = new Power_Invader(10, 10, 10, 10);
        assertEquals(pow.getWidth(), 10);
        assertEquals(pow.getHeight(), 10);
        assertEquals(pow.getX(), 10);
        assertEquals(pow.getY(), 10);
    }

    /**
     * test the power can be hit
     **/
    @Test
    public void testPower_InvaderHit() {
        Power_Invader pow = new Power_Invader(10, 10, 10, 10);
        pow.isHit();
        assertEquals(pow.getLife(), 0);
    }

    /**
     * test the invader can set up
     **/
    @Test
    public void testPower_InvaderSetLife() {
        Power_Invader pow = new Power_Invader(10, 10, 10, 10);
        pow.setLife(5);
        assertEquals(pow.getLife(), 5);
    }


}
