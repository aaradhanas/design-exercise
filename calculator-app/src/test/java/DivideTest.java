import org.junit.BeforeClass;
import org.junit.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.assertEquals;

/**
 * Created by AAS on 7/29/2018.
 */
public class DivideTest {

    private static Calculator calculator;

    @BeforeClass
    public static void createCalculatorObject(){
        calculator = new Calculator();
    }

    @Test
    public void testDivide_PositiveNumbers(){
        double result = calculator.divide(10, 5);
        assertEquals(2, result, 0);
    }

    @Test
    public void testDivide_NegativeNumbers(){
        double result = calculator.divide(-200, -18);
        assertEquals(11.11111111111111, result, 0);
    }

    @Test
    public void testDivide_PositiveNegativeNumbers(){
        double result = calculator.divide(-570.23,90000000.5671);
        assertEquals(-6.335888848965749E-6, result, 0);
    }

    @Test
    public void testDivide_PositiveNumberAndOne(){
        double result = calculator.divide(19876.543232898345, 1);
        assertEquals(19876.543232898345, result, 0);
    }

    @Test
    public void testDivide_NegativeNumberAndOne(){
        double result = calculator.divide(-93478509375.823743875, 1);
        assertEquals(-93478509375.823743875, result, 0);
    }

    @Test
    public void testDivide_OneAndPositiveNumber(){
        double result = calculator.divide(1, 90000000.36473645);
        assertEquals(1.1111111066081919E-8, result, 0);
    }

    @Test
    public void testDivide_OneAndNegativeNumber(){
        double result = calculator.divide(1, 6743853.234);
        assertEquals(1.4828317955651406E-7, result, 0);
    }


    @Test
    public void testDivide_PositiveNumberAndZero(){
        double result = calculator.divide(4567.234345, 0);
        assertEquals(Infinity, result, 0);
    }

    @Test
    public void testDivide_NegativeNumberAndZero(){
        double result = calculator.divide(-1342353453, 0);
        assertEquals(-Infinity, result, 0);
    }
}
