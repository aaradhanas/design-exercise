import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

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
        BigInteger sum = calculator.add(1,2);
        assertEquals("Passed", sum.toString(), "3");
    }

    @Test
    public void testAdd_NegativeNumbers(){
        BigInteger sum = calculator.add(-100,-20);
        assertEquals("Passed", sum.toString(), "-120");
    }

    @Test
    public void testAdd_PositiveNegativeNumbers(){
        BigInteger sum = calculator.add(78,-22);
        assertEquals("Passed", sum.toString(), "56");
    }

    @Test
    public void testAdd_PositiveNumberAndZero(){
        BigInteger sum = calculator.add(54,0);
        assertEquals("Passed", sum.toString(), "54");
    }

    @Test
    public void testAdd_NegativeNumberAndZero(){
        BigInteger sum = calculator.add(-32,0);
        assertEquals("Passed", sum.toString(), "-32");
    }

    @Test
    public void testAdd_LargeIntegerValuePlusOne(){
        BigInteger sum = calculator.add(Long.MAX_VALUE, 1);
        assertEquals("Passed", sum.toString(), "9223372036854775808");
    }

    @Test
    public void testAdd_SmallIntegerValueMinusOne(){
        BigInteger sum = calculator.add(Long.MIN_VALUE, -1);
        assertEquals("Passed", sum.toString(), "-9223372036854775809");
    }

    @Test
    public void testAdd_LargeIntegerValues(){
        BigInteger sum = calculator.add(Long.MAX_VALUE, Long.MAX_VALUE);
        assertEquals("Passed", sum.toString(), "18446744073709551614");
    }

    @Test(expected = ArithmeticException.class)
    public void testAdd_MaxBigIntegerValuePlusOne(){
        //Test addition of max value of BigInteger (2 ^ 2147483647) plus one. Should throw ArithmeticException.
        calculator.add(BigInteger.valueOf(2).pow(Integer.MAX_VALUE), BigInteger.valueOf(1));
    }

    @Test
    public void testAdd_10LargeNumbers(){
        BigInteger seed = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger sum = BigInteger.ZERO;
        int i = 0;
        while(i < 10){
            sum = sum.add(seed);
            i++;
        }
        assertEquals("Passed", sum.toString(), "92233720368547758070");
    }

    @Test
    public void testAdd_50LargeNumbers(){
        BigInteger seed = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger sum = BigInteger.ZERO;
        int i = 0;
        while(i < 50){
            sum = sum.add(seed);
            i++;
        }
        assertEquals("Passed", sum.toString(), "461168601842738790350");
    }

    @Test
    public void testAdd_100LargeNumbers(){
        BigInteger seed = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger sum = BigInteger.ZERO;
        int i = 0;
        while(i < 100){
            sum = sum.add(seed);
            i++;
        }
        assertEquals("Passed", sum.toString(), "922337203685477580700");
    }

    @Test
    public void testAdd_500LargeNumbers(){
        BigInteger seed = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger sum = BigInteger.ZERO;
        int i = 0;
        while(i < 500){
            sum = sum.add(seed);
            i++;
        }
        assertEquals("Passed", sum.toString(), "4611686018427387903500");
    }


    @Test
    public void testAdd_1000LargeNumbers(){
        BigInteger seed = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger sum = BigInteger.ZERO;
        int i = 0;
        while(i < 1000){
            sum = sum.add(seed);
            i++;
        }
        assertEquals("Passed", sum.toString(), "9223372036854775807000");
    }
}
