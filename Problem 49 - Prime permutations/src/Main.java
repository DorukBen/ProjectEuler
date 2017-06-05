import java.util.ArrayList;
import java.util.Arrays;

/**
 * Prime permutations
 * Problem 49
 *
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of
 * the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one
 * other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 *
 * Created by doruk on 5.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> primes = eratosthenesSieve(10000);
        int increase = -1;
        int startNumber = -1;

        for (int i = 0; i < primes.size(); i++){
            if (String .valueOf(primes.get(i)).length() == 4){
                ArrayList<String> permutations = permuteNumbers(String .valueOf(primes.get(i)));

                permutations.sort((o1, o2) -> {
                    if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                        return 1;
                    } else if (Integer.parseInt(o1) < Integer.parseInt(o2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                });

                for (int j = 0; j < permutations.size(); j++){
                    for (int k = j + 1; k < permutations.size(); k++){
                        if (Integer.parseInt(permutations.get(j)) != Integer.parseInt(permutations.get(k))){
                            int nextPrime = Integer.parseInt(permutations.get(k)) + (Integer.parseInt(permutations.get(k)) - Integer.parseInt(permutations.get(j)));

                            if (permutations.contains(String.valueOf(nextPrime)) && permutations.get(k).length() == 4 && permutations.get(j).length() == 4 && String.valueOf(nextPrime).length() == 4){
                                if (primes.contains(Integer.parseInt(permutations.get(k))) && primes.contains(Integer.parseInt(permutations.get(j))) && primes.contains(nextPrime)){
                                    startNumber = Integer.parseInt(permutations.get(j));
                                    increase = Integer.parseInt(permutations.get(k)) - Integer.parseInt(permutations.get(j));
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.print(startNumber + "" + (startNumber + increase) + "" + (startNumber + increase + increase));
    }

    private static ArrayList<String> permuteNumbers(String input) {
        ArrayList<String> permutations = new ArrayList<>();

        if (input.length() == 1) {
            permutations.add(Character.toString(input.charAt(0)));
            return permutations;
        }

        String toInsert = Character.toString(input.charAt(0));
        for(String item : permuteNumbers(input.substring(1))) {
            for (int i = 0; i <= item.length(); ++i) {
                String newPermutation = new StringBuilder(item).insert(i, toInsert).toString();
                permutations.add(newPermutation);
            }
        }

        return permutations;
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
