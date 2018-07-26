import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by AAS on 7/26/2018.
 */
public class SubtractTest {

    private static Calculator calculator;

    @BeforeClass
    public static void createCalculatorObject(){
        calculator = new Calculator();
    }

    @Test
    public void testSubtract_PositiveNumbers(){
        long difference = calculator.subtract(100, 60);
        assertEquals("Passed", difference, 40);
    }

    @Test
    public void testSubtract_NegativeNumbers(){
        long difference = calculator.subtract(-200, -90);
        assertEquals("Passed", difference, -110);
    }

    @Test
    public void testSubtract_PositiveNegativeNumbers(){
        long difference = calculator.subtract(1000, -340);
        assertEquals("Passed", difference, 1340);
    }

    @Test
    public void testSubtract_PositiveNumberAndZero(){
        long difference = calculator.subtract(12345, 0);
        assertEquals("Passed", difference, 12345);
    }

    @Test
    public void testSubtract_NegativeNumberAndZero(){
        long difference = calculator.subtract(-12345, 0);
        assertEquals("Passed", difference, -12345);
    }

    @Test
    public void testSubtract_SmallestLongMinusOne(){
        long difference = calculator.subtract(Long.MIN_VALUE, 1);
        assertEquals("Passed", difference, 0);
    }

    @Test
    public void testSubtract_MaxLongMinLongValue(){
        long difference = calculator.subtract(Long.MAX_VALUE,Long.MIN_VALUE);
        assertEquals("Passed", difference, 0);
    }

    @Test
    public void testSubtract_MinLongMaxLongValue(){
        long difference = calculator.subtract(Long.MIN_VALUE,Long.MAX_VALUE);
        assertEquals("Passed", difference, 0);
    }
}
