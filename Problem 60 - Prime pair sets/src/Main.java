import java.util.ArrayList;
import java.util.Arrays;

/**
 * Prime pair sets
 * Problem 60
 *
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the
 * result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes,
 * 792, represents the lowest sum for a set of four primes with this property.
 *
 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 *
 * Created by doruk on 9.06.2017.
 */

public class Main {

    private static final int TARGET = 5;

    public static void main(String[] args) {
        Integer[] primes = eratosthenesSieve(10000);
        ArrayList<Integer>[] pairPrimes = new ArrayList[primes.length];

        for (int i = 0; i < primes.length; i++){
            pairPrimes[i] = new ArrayList<>();
            for (int j = i + 1; j < primes.length; j++){
                int firstPrime = (int) (primes[i] + (Math.pow(10, (int)(Math.log10(primes[i]) + 1)) * primes[j]));
                int secondPrime = (int) (primes[j] + (Math.pow(10, (int)(Math.log10(primes[j]) + 1)) * primes[i]));
                if (isPrime(firstPrime) && isPrime(secondPrime)){
                    pairPrimes[i].add(j);
                }
            }
        }

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < pairPrimes.length; i++){
            for (int j = 0; j < pairPrimes[i].size(); j++){
                ArrayList<Integer> sumArray = new ArrayList<>();
                sumArray.add(i);
                boolean pairsFound = false;
                for (int k = j; k < pairPrimes[i].size() && !pairsFound; k++){
                    boolean allPair = true;
                    int index = pairPrimes[i].get(k);

                    for (Integer prime: sumArray){
                        if (!pairPrimes[prime].contains(index)){
                            allPair = false;
                        }
                    }

                    if (allPair){
                        sumArray.add(index);
                        if (sumArray.size() == TARGET){
                            pairsFound = true;
                        }
                    }
                }

                if (pairsFound){
                    int sum = sumArray.stream().mapToInt(Integer::intValue).map(x -> primes[x]).sum();
                    if (sum < minSum){
                        minSum = sum;
                    }
                }
            }
        }

        System.out.print(minSum);
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

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
