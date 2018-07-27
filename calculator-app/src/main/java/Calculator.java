import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by AAS on 7/23/2018.
 */
class Calculator {

    /**
     * Add method which takes long arguments
     * @param num1
     * @param num2
     * @return BigInteger
     */
    BigInteger add(long num1, long num2){
        return BigInteger.valueOf(num1).add(BigInteger.valueOf(num2));
    }

    /**
     * Add method which takes BigInteger arguments
     * @param num1
     * @param num2
     * @return BigInteger
     */
    BigInteger add(BigInteger num1, BigInteger num2){
        try {
            return num1.add(num2);
        } catch( ArithmeticException exception){
            System.out.println("Result is out of range...Returning 0...");
            return BigInteger.ZERO;
        }
    }

    /**
     * Add method which takes double arguments
     * @param num1
     * @param num2
     * @return BigDecimal
     */
    BigDecimal add(double num1, double num2){
        return BigDecimal.valueOf(num1).add(BigDecimal.valueOf(num2));
    }

    /**
     * Subtract methd which takes logn arguments
     * @param num1
     * @param num2
     * @return BigInteger
     */

    BigInteger subtract(long num1, long num2){
        return BigInteger.valueOf(num1).subtract(BigInteger.valueOf(num2));
    }
}
