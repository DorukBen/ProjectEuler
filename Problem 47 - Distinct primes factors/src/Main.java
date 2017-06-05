import java.util.ArrayList;
import java.util.Arrays;

/**
 * Distinct primes factors
 * Problem 47
 *
 * The first two consecutive numbers to have two distinct prime factors are:
 *
 *      14 = 2 × 7
 *      15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 *
 *      644 = 2² × 7 × 23
 *      645 = 3 × 5 × 43
 *      646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 *
 * Created by doruk on 3.06.2017.
 */

public class Main {

    private static final int TARGET = 4;
    private static final Integer[] primes = eratosthenesSieve(10000);

    public static void main(String[] args) {


        int number = 1;

        for (int i = 0; i < TARGET; i++){
            number = number * primes[i];
        }

        int count = 0;
        while (count < TARGET){
            if (calculateDistinctFactorCount(number) == TARGET){
                count++;
            }else {
                count = 0;
            }
            number++;
        }

        System.out.print(number - TARGET);
    }

    private static int calculateDistinctFactorCount(int number){
        int distinctPrimeCount = 1;
        int index = 0;
        boolean isUsed = false;

        while (number > 1 && index < primes.length){
            if (number%primes[index] == 0){
                number = number/ primes[index];
                isUsed = true;
            }else {
                index++;

                if (isUsed){
                    distinctPrimeCount++;
                    isUsed = false;
                }
            }
        }

        return distinctPrimeCount;
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
