package invadem;

import org.junit.Test;
import processing.core.PImage;

import static org.junit.Assert.*;


public class ComponentTest {
    /**
     * test component can be hit
     **/
    @Test
    public void testIsHit() {
        PImage[] images = new PImage[1];
        images[0] = new PImage(2, 4);
        Component c = new Component(images, 2, 4, 2, 4);
        c.life = 0;
        c.isHit();
        assertEquals(c.life, 0);
    }


}
