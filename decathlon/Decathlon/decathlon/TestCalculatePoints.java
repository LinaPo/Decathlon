package decathlon;

/**
 * Created by Lina on 2016-01-24.
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCalculatePoints {

    @Test
    public void testCalculatePoints() {

        CalculatePoints tester = new CalculatePoints();


        // assert statements
        assertTrue("must be more than 0", tester.calcTrack(1, 12.61)>0);

        assertEquals(537,tester.calcTrack(1, 12.61),0);

    }

}

