package invadem;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiamondTest {
    /**
     * test the diamond has correct score
     **/
    @Test
    public void testGetscore() {
        Diamond diamond = new Diamond(3, 3, 3, 3);
        assertEquals(diamond.getBonus_Score(), 500);
    }
}
