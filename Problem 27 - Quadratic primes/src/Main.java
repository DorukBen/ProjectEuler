import java.util.ArrayList;
import java.util.Arrays;

/**
 * Quadratic primes
 * Problem 27
 *
 * Euler discovered the remarkable quadratic formula:
 *
 *                                              n^2+n+41
 *
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39. However,
 * when n=40,402+40+41=40(40+1)+41n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41n=41,412+41+41 is
 * clearly divisible by 41.
 *
 * The incredible formula n2−79n+1601n2−79n+1601 was discovered, which produces 80 primes for the consecutive values
 * 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n2+an+bn2+an+b, where |a|<1000|a|<1000 and |b|≤1000|b|≤1000
 *
 * where |n||n| is the modulus/absolute value of nn
 * e.g. |11|=11|11|=11 and |−4|=4|−4|=4
 * Find the product of the coefficients, aa and bb, for the quadratic expression that produces the maximum number of primes
 * for consecutive values of nn, starting with n=0n=0.
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final int A_BELOW = 1000;
    private static final int B_BELOW_EQUAL = 1000;

    public static void main(String[] args) {
        int largestSequence = 0;
        int A = 0;
        int B = 0;

        Integer[] possibleBs = eratosthenesSieve(B_BELOW_EQUAL);

        for (int a = A_BELOW - 1; a > -A_BELOW ; a--){
            for (Integer b: possibleBs){
                if (isPrime(a + b + 1)){
                    int n = 2;
                    while (isPrime((long) Math.abs(Math.pow(n, 2) + (a * n) + b))){
                        n++;
                    }

                    if ((n - 1) >= largestSequence){
                        largestSequence = n - 1;
                        A = a;
                        B = b;
                    }
                }
            }
        }

        System.out.print(A*B);
    }

    private static boolean isPrime(long number){
        boolean isPrime = true;
        long divisor = number / 2 + 1;
        while (isPrime && divisor > 1){
            if (number % divisor == 0){
                isPrime = false;
            }
            divisor--;
        }

        return isPrime;
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
