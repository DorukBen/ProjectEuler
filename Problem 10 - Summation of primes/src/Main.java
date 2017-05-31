import java.util.ArrayList;
import java.util.Arrays;

/**
 * Summation of primes
 * Problem 10
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 2000000;

    public static void main(String[] args) {
        long sumOfPrimes = 0;
        for (Integer prime: eratosthenesSieve(LIMIT)){
            sumOfPrimes += prime;
        }

        System.out.print(sumOfPrimes);
    }

    private static Integer[] eratosthenesSieve(int upperLimit) {
        int sieveBound = (upperLimit - 1) / 2;
        int upperSqrt = ((int)Math.sqrt(upperLimit) - 1) / 2;

        boolean[] primes = new boolean[sieveBound + 1];
        Arrays.fill(primes, true);

        for (int i = 1; i <= upperSqrt; i++) {
            if (primes[i]) {
                for (int j = i * 2 * (i + 1); j <= sieveBound; j += 2 * i + 1) {
                    primes[j] = false;
                }
            }
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);

        for (int i = 1; i <= sieveBound; i++) {
            if (primes[i]) {
                numbers.add(2 * i + 1);
            }
        }

        return numbers.toArray(new Integer[0]);
    }
}
