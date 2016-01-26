package decathlon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lina on 2016-01-25.
 */

public class TestComplexTimeToDouble {

    @Test
    public void TestComplexTimeToDouble() {
        String s = "1.10.10";
        complexTimeToDouble tester2 = new complexTimeToDouble();

        assertEquals(70.10, tester2.complexTimeToDouble(s), 0);
    }
}
