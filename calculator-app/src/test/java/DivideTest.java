import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

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
        double result = calculator.divide(10, 5).doubleValue();
        assertEquals(2, result, 0);
    }

    @Test
    public void testDivide_NegativeNumbers(){
        double result = calculator.divide(-200, -18).doubleValue();
        //BigDecimal result = BigDecimal.valueOf(200).divide(BigDecimal.valueOf(18), MathContext.DECIMAL64);
        assertEquals(11.11111111111111, result, 0);
        //assertEquals(11.1111111111111111, result.doubleValue(), 0);
    }

    @Test
    public void testDivide_PositiveNegativeNumbers(){
        double result = calculator.divide(-570.23,90000000.5671).doubleValue();
        assertEquals(-6.335888848965749E-6, result, 0);
    }

    @Test
    public void testDivide_PositiveNumberAndOne(){
        double result = calculator.divide(19876.543232898345, 1).doubleValue();
        assertEquals(19876.54323289834, result, 0);
    }

    @Test
    public void testDivide_NegativeNumberAndOne(){
        double result = calculator.divide(-93478509375.823743875, 1).doubleValue();
        assertEquals(-93478509375.823743875, result, 0);
    }

    @Test
    public void testDivide_OneAndPositiveNumber(){
        double result = calculator.divide(1, 90000000.36473645).doubleValue();
        assertEquals(1.111111106608192E-8, result, 0);
    }

    @Test
    public void testDivide_OneAndNegativeNumber(){
        double result = calculator.divide(1, 6743853.234).doubleValue();
        assertEquals(1.482831795565141E-7, result, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide_PositiveNumberAndZero(){
        calculator.divide(4567.234345, 0).doubleValue();
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide_NegativeNumberAndZero(){
       calculator.divide(-1342353453, 0).doubleValue();
    }

    @Test
    public void testDivide_MaxLongMinLong(){
        double result = calculator.divide(Long.MAX_VALUE, Long.MIN_VALUE).doubleValue();
        assertEquals(-1.0, result, 0);
    }

    @Test
    public void testDivide_MinLongMaxLong(){
        double result = calculator.divide(Long.MIN_VALUE, Long.MAX_VALUE).doubleValue();
        assertEquals(-1.0, result, 0);
    }

    @Test
    public void testDivide_MaxDoubleMinDouble(){
        BigDecimal result = calculator.divide(Double.MAX_VALUE, Double.MIN_VALUE);
        assertEquals("3.668761499719012E+631", result.toString());
    }

    @Test
    public void testDivide_MinDoubleMaxDouble(){
        double result = calculator.divide(Double.MIN_VALUE, Double.MAX_VALUE).doubleValue();
        assertEquals(0.0, result, 0);
    }
}
