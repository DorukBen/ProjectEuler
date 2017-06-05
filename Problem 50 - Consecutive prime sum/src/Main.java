import java.util.ArrayList;
import java.util.Arrays;

/**
 * Consecutive prime sum
 * Problem 50
 *
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 *                          41 = 2 + 3 + 5 + 7 + 11 + 13
 *
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 *
 * Created by doruk on 5.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        ArrayList<Integer> primes = eratosthenesSieve(1000000);

        int sumOfPrimes = 0;
        int subIndex = 0;
        int supIndex = 0;

        while (sumOfPrimes + primes.get(supIndex) < LIMIT){
            sumOfPrimes += primes.get(supIndex);
            supIndex++;
        }

        while (!primes.contains(sumOfPrimes)){
            if (sumOfPrimes + primes.get(supIndex + 1) < LIMIT){
                sumOfPrimes += primes.get(supIndex + 1);
                supIndex++;
            }else {
                sumOfPrimes -= primes.get(subIndex);
                subIndex++;
            }
        }

        System.out.print(sumOfPrimes);
    }

    private static ArrayList<Integer> eratosthenesSieve(int upperLimit) {
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

        return numbers;
    }
}
