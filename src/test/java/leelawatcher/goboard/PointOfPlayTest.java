package leelawatcher.goboard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * @author Barry Becker
 */
public class PointOfPlayTest {


    @Test
    public void testConstruction() {
        PointOfPlay pos = new PointOfPlay(1, 2);
        assertEquals("(1,2)", pos.toString());
    }

    @Test
    public void testEqual() {
        PointOfPlay pos1 = new PointOfPlay(1, 2);
        PointOfPlay pos2 = new PointOfPlay(1, 2);

        assertEquals(pos1, pos2);
    }

    @Test
    public void testNotEqual() {
        PointOfPlay pos1 = new PointOfPlay(1, 2);
        PointOfPlay pos2 = new PointOfPlay(3, 2);

        assertNotEquals(pos1, pos2);
    }


}
