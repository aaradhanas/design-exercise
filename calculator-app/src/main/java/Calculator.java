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
        return num1.add(num2);
    }
}
