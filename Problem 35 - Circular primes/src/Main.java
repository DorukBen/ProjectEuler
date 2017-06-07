import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Circular primes
 * Problem 35
 *
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        ArrayList<Integer> primes = eratosthenesSieve(LIMIT);
        int index = 0;
        while (index < primes.size()){
            Integer number = primes.get(index);
            boolean isSame = true;
            do {
                number = (int) ((number% 10 * Math.pow(10, (int) Math.log10(number))) + number/ 10);
                isSame = Objects.equals(number, primes.get(index));
            } while (primes.contains(number) && !isSame);

            if (isSame){
                index++;
            }else {
                primes.remove(index);
            }
        }

        System.out.print(primes.size());
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
        numbers.add(5);

        for (int i = 1; i <= sieveBound; i++) {
            if (primes[i]) {
                String strNumber = String.valueOf(2 * i + 1);
                if (!strNumber.contains("2") && !strNumber.contains("5")){
                    numbers.add(2 * i + 1);
                }
            }
        }

        return numbers;
    }
}
