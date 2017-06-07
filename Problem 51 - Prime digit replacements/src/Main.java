import java.util.ArrayList;
import java.util.Arrays;

/**
 * Prime digit replacements
 * Problem 51
 *
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73,
 * and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven
 * primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part
 * of an eight prime value family.
 *
 * Created by doruk on 6.06.2017.
 */

public class Main {

    private static final int VALUE_FAMILY = 8;

    public static void main(String[] args) {
        boolean[] primes = eratosthenesSieve(1000000);

        int smallestValueFamilyPrime = 0;

        int index = 50;
        while (index < primes.length && smallestValueFamilyPrime == 0){
            if (primes[index]){
                int number = 2 * index + 1;
                for (int j = 0; j < String.valueOf(number).length(); j++){
                    String strNumber = String.valueOf(number);
                    strNumber = strNumber.replace(strNumber.charAt(j), '*');

                    int primeCount = 0;

                    int replaceDigit = (strNumber.charAt(0) != '*')? 0: 1;
                    while (replaceDigit < 10 && (10 - replaceDigit) + primeCount >= VALUE_FAMILY){
                        String controlNumber = strNumber.replace('*',Character.forDigit(replaceDigit,10));

                        if (primes[(Integer.parseInt(controlNumber) - 1)/ 2]){
                            primeCount++;
                        }

                        replaceDigit++;
                    }

                    if (primeCount == VALUE_FAMILY){
                        smallestValueFamilyPrime = number;
                    }
                }
            }
            index++;
        }

        System.out.print(smallestValueFamilyPrime);
    }

    private static boolean[] eratosthenesSieve(int upperLimit) {
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

        return primes;
    }
}
