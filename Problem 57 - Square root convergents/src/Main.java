import java.math.BigInteger;

/**
 * Square root convergents
 * Problem 57
 *
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 *
 *           √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 *
 *          1 + 1/2 = 3/2 = 1.5
 *          1 + 1/(2 + 1/2) = 7/5 = 1.4
 *          1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 *          1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the
 * number of digits in the numerator exceeds the number of digits in the denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 *
 * Created by doruk on 8.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000;

    public static void main(String[] args) {
        int expansionCount = 0;
        int counter = 0;

        BigInteger numerator = BigInteger.valueOf(3);
        BigInteger denominator = BigInteger.valueOf(2);

        while (expansionCount < LIMIT){
            numerator = numerator.add(denominator.shiftLeft(1));
            denominator = numerator.subtract(denominator);

            if (numerator.toString().length() > denominator.toString().length()){
                counter++;
            }

            expansionCount++;
        }

        System.out.print(counter);
    }
}
