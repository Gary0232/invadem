package invadem;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BarrierTest {

    @Test
    public void barrierConstruction() {
        Barrier b = new Barrier(12,20,30,30);
        assertNotNull(b);
    }
}
