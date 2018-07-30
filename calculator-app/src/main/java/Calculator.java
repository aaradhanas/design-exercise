import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

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
        return num1.add(num2);
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

    /** Add method which takes BigDecimal arguments
     *
     * @param num1
     * @param num2
     * @return BigDecimal
     */
    BigDecimal add(BigDecimal num1, BigDecimal num2){
        return  num1.add(num2);
    }

    /**
     * Subtract method which takes long arguments
     * @param num1
     * @param num2
     * @return BigInteger
     */
    BigInteger subtract(long num1, long num2){
        return BigInteger.valueOf(num1).subtract(BigInteger.valueOf(num2));
    }

    /**
     * Subtract method which takes double arguments
     * @param num1
     * @param num2
     * @return BigDecimal
     */
    BigDecimal subtract(double num1, double num2){
        return BigDecimal.valueOf(num1).subtract(BigDecimal.valueOf(num2));
    }

    /**
     * Multiply method which takes long arguments
     * @param num1
     * @param num2
     * @return BigInteger
     */
    BigInteger multiply(long num1, long num2) {
        return BigInteger.valueOf(num1).multiply(BigInteger.valueOf(num2));
    }

    /**
     * Multiply method which takes BigInteger arguments
     * @param num1
     * @param num2
     * @return BigInteger
     */
    BigInteger multiply(BigInteger num1, BigInteger num2) {
        return num1.multiply(num2);
    }

    /**
     * Multiply method which takes double arguments
     * @param num1
     * @param num2
     * @return BigDecimal
     */
    BigDecimal multiply(double num1, double num2) {
        return BigDecimal.valueOf(num1).multiply(BigDecimal.valueOf(num2));
    }

    /**
     * Multiply method which takes BigDecimal arguments
     * @param num1
     * @param num2
     * @return BigDecimal
     */
    BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }

    /**
     * Divide method which takes double arguments
     * @param num1
     * @param num2
     * @return double
     */
    BigDecimal divide(double num1, double num2) throws ArithmeticException{
        return BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(num2), MathContext.DECIMAL64);
    }
}
