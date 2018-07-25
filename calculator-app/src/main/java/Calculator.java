import java.math.BigInteger;

/**
 * Created by AAS on 7/23/2018.
 */
class Calculator {

    /**
     * Add method which takes long arguments
     * @param num1
     * @param num2
     * @return long
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
     * @return double
     */
    double add(double num1, double num2){
        double sum =  num1 + num2;

        if( sum == Double.POSITIVE_INFINITY){
            System.out.println("Result is out of range...Returning 0...");
            return 0;
        }
        return sum;
    }
}
