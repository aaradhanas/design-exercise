import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by AAS on 7/23/2018.
 */
public class CalculatorTest{

    private static Calculator calculator;

    @BeforeClass
    public static void createCalculatorObject(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd_PositiveNumbers(){
        int sum = calculator.add(1,2);
        assertEquals("Passed", sum, 3);
    }

    @Test
    public void testAdd_NegativeNumbers(){
        int sum = calculator.add(-100,-20);
        assertEquals("Passed", sum, -120);
    }

    @Test
    public void testAdd_PositiveNegativeNumbers(){
        int sum = calculator.add(78,-22);
        assertEquals("Passed", sum, 56);
    }

    @Test
    public void testAdd_PositiveNumberAndZero(){
        int sum = calculator.add(54,0);
        assertEquals("Passed", sum, 54);
    }

    @Test
    public void testAdd_NegativeNumberAndZero(){
        int sum = calculator.add(-32,0);
        assertEquals("Passed", sum, -32);
    }

    @Test
    public void testAdd_MaxIntegerValuePlusOne(){
        int sum = calculator.add(Integer.MAX_VALUE, 1);
        assertEquals("Passed", sum, Integer.MIN_VALUE);
    }

    @Test
    public void testAdd_MinIntegerValueMinusOne(){
        int sum = calculator.add(Integer.MIN_VALUE, -1);
        assertEquals("Passed", sum, Integer.MAX_VALUE);
    }

    @Test
    public void testAdd_MaxIntegerValues(){
        int sum = calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals("Passed", sum, -2);
    }

}
