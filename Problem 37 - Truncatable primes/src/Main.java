import java.util.ArrayList;
import java.util.Arrays;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove
 * digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        ArrayList<Integer> primes = eratosthenesSieve(LIMIT);
        int sumOfPrimes = 0;

        for (Integer prime: primes){
            String numberLeft = String.valueOf(prime);
            String numberRight = String.valueOf(prime);
            boolean isPrime = true;
            for (int j = 0; j < String.valueOf(prime).length() - 1 && isPrime; j++){
                numberLeft = numberLeft.substring(1);
                numberRight = numberRight.substring(0, numberRight.length() - 1);

                if (!primes.contains(Integer.parseInt(numberLeft)) || !primes.contains(Integer.parseInt(numberRight))){
                    isPrime = false;
                }
            }

            if (isPrime && prime > 7){
                sumOfPrimes += prime;
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
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);

        for (int i = 4; i <= sieveBound; i++) {
            if (primes[i]) {
                String number = String.valueOf(2 * i + 1);
                number = number.substring(1, number.length() - 1);
                if (!number.contains("2") && !number.contains("5") && !number.contains("0")){
                    numbers.add(2 * i + 1);
                }
            }
        }

        return numbers;
    }
}
