import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigInteger;

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
        BigInteger difference = calculator.subtract(100, 60);
        assertEquals("Passed", "40", difference.toString());
    }

    @Test
    public void testSubtract_NegativeNumbers(){
        BigInteger difference = calculator.subtract(-200, -90);
        assertEquals("Passed", "-110", difference.toString());
    }

    @Test
    public void testSubtract_PositiveNegativeNumbers(){
        BigInteger difference = calculator.subtract(1000, -340);
        assertEquals("Passed", "1340", difference.toString());
    }

    @Test
    public void testSubtract_PositiveNumberAndZero(){
        BigInteger difference = calculator.subtract(12345, 0);
        assertEquals("Passed", "12345", difference.toString());
    }

    @Test
    public void testSubtract_NegativeNumberAndZero(){
        BigInteger difference = calculator.subtract(-12345, 0);
        assertEquals("Passed", "-12345", difference.toString());
    }

    @Test
    public void testSubtract_SmallestLongMinusOne(){
        BigInteger difference = calculator.subtract(Long.MIN_VALUE, 1);
        assertEquals("Passed", "-9223372036854775809", difference.toString());
    }

    @Test
    public void testSubtract_MaxLongMinLongValue(){
        BigInteger difference = calculator.subtract(Long.MAX_VALUE,Long.MIN_VALUE);
        assertEquals("Passed", "18446744073709551615", difference.toString());
    }

    @Test
    public void testSubtract_MinLongMaxLongValue(){
        BigInteger difference = calculator.subtract(Long.MIN_VALUE,Long.MAX_VALUE);
        assertEquals("Passed", "-18446744073709551615", difference.toString());
    }
}
