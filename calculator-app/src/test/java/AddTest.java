import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by AAS on 7/23/2018.
 */
public class AddTest {

    private static Calculator calculator;

    @BeforeClass
    public static void createCalculatorObject(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd_PositiveNumbers(){
        BigInteger sum = calculator.add(1,2);
        assertEquals("Passed", "3", sum.toString());
    }

    @Test
    public void testAdd_NegativeNumbers(){
        BigInteger sum = calculator.add(-100,-20);
        assertEquals("Passed", "-120", sum.toString());
    }

    @Test
    public void testAdd_PositiveNegativeNumbers(){
        BigInteger sum = calculator.add(78,-22);
        assertEquals("Passed", "56", sum.toString());
    }

    @Test
    public void testAdd_PositiveNumberAndZero(){
        BigInteger sum = calculator.add(54,0);
        assertEquals("Passed", "54", sum.toString());
    }

    @Test
    public void testAdd_NegativeNumberAndZero(){
        BigInteger sum = calculator.add(-32,0);
        assertEquals("Passed", "-32", sum.toString());
    }

    @Test
    public void testAdd_MaxLongValuePlusOne(){
        BigInteger sum = calculator.add(Long.MAX_VALUE, 1);
        assertEquals("Passed", "9223372036854775808", sum.toString());
    }

    @Test
    public void testAdd_MaxLongValues(){
        BigInteger sum = calculator.add(Long.MAX_VALUE, Long.MAX_VALUE);
        assertEquals("Passed", "18446744073709551614", sum.toString());
    }

    @Test
    public void testAdd_MinLongValues(){
        BigInteger sum = calculator.add(Long.MIN_VALUE, Long.MIN_VALUE);
        assertEquals("Passed", "-18446744073709551616", sum.toString());
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
        assertEquals("Passed", "92233720368547758070", sum.toString());
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
        assertEquals("Passed", "461168601842738790350", sum.toString());
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
        assertEquals("Passed", "922337203685477580700", sum.toString());
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
        assertEquals("Passed", "4611686018427387903500", sum.toString());
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
        assertEquals("Passed", "9223372036854775807000", sum.toString());
    }

    @Test
    public void testAdd_PositiveDoubles(){
        double sum = calculator.add(1.23,2.45).doubleValue();
        assertEquals(3.68, sum, 0);
    }

    @Test
    public void testAdd_NegativeDoubles(){
        double sum = calculator.add(-1.01,-2.1).doubleValue();
        assertEquals(-3.11, sum, 0);
    }

    @Test
    public void testAdd_PositiveNegativeDoubles(){
        double sum = calculator.add(790.45,-2.2).doubleValue();
        assertEquals(788.25, sum, 0);
    }

    @Test
    public void testAdd_PositiveDoubleAndZero(){
        double sum = calculator.add(1000.56,0).doubleValue();
        assertEquals(1000.56, sum, 0);
    }

    @Test
    public void testAdd_NegativeDoubleAndZero(){
        double sum = calculator.add(-458.978,0).doubleValue();
        assertEquals(-458.978, sum, 0);
    }

    @Test
    public void testAdd_TwoMaxDoubleValues(){
        BigDecimal sum = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(Double.MAX_VALUE));
        assertEquals("Passed", "3.5953862697246314E+308", sum.toString());
    }

    @Test
    public void testAdd_TwoMinDoubleValues(){
        BigDecimal sum = calculator.add(Double.MIN_VALUE, Double.MIN_VALUE);
        assertEquals("Passed", "9.8E-324", sum.toString());
    }
}
