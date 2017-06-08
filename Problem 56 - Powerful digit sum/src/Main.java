import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Powerful digit sum
 * Problem 56
 *
 * A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed
 * by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
 *
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 *
 * Created by doruk on 8.06.2017.
 */

public class Main {

    private static final int TOTAL = 100;

    public static void main(String[] args) {
        int largestSum = 0;

        for (int a = TOTAL - 1; a > 0; a--) {
            for (int b = TOTAL - 1; b > 0; b--) {
                BigInteger number = BigInteger.valueOf(a).pow(b);
                if (number.bitCount() * 9 > largestSum){
                    int sum = digitSum(number);
                    if (sum > largestSum){
                        largestSum = sum;
                    }
                }
            }
        }

        System.out.print(largestSum);
    }

    private static int digitSum(BigInteger number) {
        char[] chars = number.toString().toCharArray();
        return IntStream.range(0, chars.length).map(i -> chars[i]).sum() - chars.length * 48;
    }
}
