import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by AAS on 7/29/2018.
 */
public class MultiplyTest {

    private static Calculator calculator;

    @BeforeClass
    public static void createCalculatorObject(){
        calculator = new Calculator();
    }

    @Test
    public void testMultiply_PositiveNumbers(){
        BigInteger product = calculator.multiply(800, 20);
        assertEquals("Passed", 16000, product.intValue());
    }

    @Test
    public void testMultiply_NegativeNumbers(){
        BigInteger product = calculator.multiply(-987, 1022);
        assertEquals("Passed", -1008714, product.intValue());
    }

    @Test
    public void testMultiply_PositiveNegativeNumbers(){
        BigInteger product = calculator.multiply(10000, -200);
        assertEquals("Passed", -2000000, product.intValue());
    }

    @Test
    public void testMultiply_PositiveNumberAndOne(){
        BigInteger product = calculator.multiply(689045, 1);
        assertEquals("Passed", 689045, product.intValue());
    }

    @Test
    public void testMultiply_NegativeNumberAndOne(){
        BigInteger product = calculator.multiply(-90874321, 1);
        assertEquals("Passed", -90874321, product.intValue());
    }

    @Test
    public void testMultiply_TwoMaxLongValues(){
        BigInteger product = calculator.multiply(Long.MAX_VALUE, Long.MAX_VALUE);
        assertEquals("Passed", "85070591730234615847396907784232501249", product.toString());
    }

    @Test
    public void testMultiply_TwoMinLongValues(){
        BigInteger product = calculator.multiply(Long.MIN_VALUE, Long.MIN_VALUE);
        assertEquals("Passed", "85070591730234615865843651857942052864", product.toString());
    }

    @Test
    public void testMultiply_MaxLongMinLongValues(){
        BigInteger product = calculator.multiply(Long.MAX_VALUE, Long.MIN_VALUE);
        assertEquals("Passed", "-85070591730234615856620279821087277056", product.toString());
    }

    @Test
    public void testMultiply_5LargeNumbers(){
        BigInteger seed = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger product = BigInteger.ONE;
        int i = 0;
        while(i < 5){
            product = calculator.multiply(seed, product);
            i++;
        }
        assertEquals("Passed", "66749594872528440038659400431137192519314960677663778810642210898138927029830146832929608695807", product.toString());
    }

    @Test
    public void testMultiply_PositiveDoubles(){
        BigDecimal product = calculator.multiply(100.8, 30.6);
        assertEquals(3084.48, product.doubleValue(), 0);
    }

    @Test
    public void testMultiply_NegativeDoubles(){
        BigDecimal product = calculator.multiply(-9876.45, -8765.2);
        assertEquals(8.656905954E7, product.doubleValue(), 0);
    }

    @Test
    public void testMultiply_PositiveNegativeDoubles(){
        BigDecimal product = calculator.multiply(100.67, -20.8);
        assertEquals(-2093.936, product.doubleValue(), 0);
    }

    @Test
    public void testMultiply_PositiveDoubleAndOne(){
        BigDecimal product = calculator.multiply(1234567.9876, 1);
        assertEquals(1234567.9876, product.doubleValue(), 0);
    }

    @Test
    public void testMultiply_NegativeDoubleAndOne(){
        BigDecimal product = calculator.multiply(-876409.8123456, 1);
        assertEquals(-876409.8123456, product.doubleValue(), 0);
    }

    @Test
    public void testMultiply_TwoMaxDoubleValues(){
        BigDecimal product = calculator.multiply(Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals("Passed", "3.23170060713109998320439596646649E+616", product.toString());
    }

    @Test
    public void testMultiply_TwoMinDoubleValues(){
        BigDecimal product = calculator.multiply(Double.MIN_VALUE, Double.MIN_VALUE);
        assertEquals("Passed", "2.401E-647", product.toString());
    }

    @Test
    public void testMultiply_MaxDoubleMinDoubleValues(){
        BigDecimal product = calculator.multiply(Double.MAX_VALUE, Double.MIN_VALUE);
        assertEquals(8.808696360825347E-16, product.doubleValue(), 0);
    }

    @Test
    public void testMultiply_5LargeDoubles(){
        BigDecimal seed = BigDecimal.valueOf(Double.MAX_VALUE);
        BigDecimal product = BigDecimal.ONE;
        int i = 0;
        while(i < 5){
            product = calculator.multiply(seed, product);
            i++;
        }
        assertEquals("Passed", "1.877490722242956540121945755737971182054000497463631871559576992936763982620107557E+1541", product.toString());
    }
}
