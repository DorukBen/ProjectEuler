import java.util.Arrays;

/**
 * Pandigital prime
 * Problem 41
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example,
 * 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 *
 * Created by doruk on 3.06.2017.
 */

public class Main {

    private static final int UPPER_LIMIT = 87654321;

    public static void main(String[] args) {

        int sieveBound = (UPPER_LIMIT - 1) / 2;
        int upperSqrt = ((int)Math.sqrt(UPPER_LIMIT) - 1) / 2;

        boolean[] primes = new boolean[sieveBound + 1];
        Arrays.fill(primes, true);

        for (int i = 1; i <= upperSqrt; i++) {
            if (primes[i]) {
                for (int j = i * 2 * (i + 1); j <= sieveBound; j += 2 * i + 1) {
                    primes[j] = false;
                }
            }
        }

        int pandigitalPrime = 0;

        for (int i = sieveBound; i > 0 && pandigitalPrime == 0; i--) {
            if (primes[i]) {
                if (isPandigital(String.valueOf(2 * i + 1))){
                    pandigitalPrime = 2 * i + 1;
                }
            }
        }

        System.out.print(pandigitalPrime);
    }

    private static boolean isPandigital(String number){
        boolean isPandigital = true;
        for (int i = 1; i <= number.length() && isPandigital; i++){
            if (!number.contains(String.valueOf(i))){
                isPandigital = false;
            }
        }

        return isPandigital;
    }
}
