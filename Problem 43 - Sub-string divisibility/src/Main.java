import java.util.ArrayList;

/**
 * Sub-string divisibility
 * Problem 43
 *
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order,
 * but it also has a rather interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 *
 *       d2d3d4=406 is divisible by 2
 *       d3d4d5=063 is divisible by 3
 *       d4d5d6=635 is divisible by 5
 *       d5d6d7=357 is divisible by 7
 *       d6d7d8=572 is divisible by 11
 *       d7d8d9=728 is divisible by 13
 *       d8d9d10=289 is divisible by 17
 *
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 *
 * Created by doruk on 3.06.2017.
 */

public class Main {

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        ArrayList<String> pandigitalNumbers = permutePandigitalNumbers("0123456789");

        long sumOfPandigitalNumbers = 0;
        for (String pandigitalNumber : pandigitalNumbers) {
            boolean followRule = true;
            for (int j = 0; j < PRIMES.length && followRule; j++) {
                if (Integer.parseInt(pandigitalNumber.substring(j + 1, j + 4)) % PRIMES[j] != 0) {
                    followRule = false;
                }
            }

            if (followRule) {
                sumOfPandigitalNumbers += Long.parseLong(pandigitalNumber);
            }
        }

        System.out.println(sumOfPandigitalNumbers);
    }

    private static ArrayList<String> permutePandigitalNumbers(String input) {
        ArrayList<String> permutations = new ArrayList<>();

        if (input.length() == 1) {
            permutations.add(Character.toString(input.charAt(0)));
            return permutations;
        }

        String toInsert = Character.toString(input.charAt(0));
        for(String item : permutePandigitalNumbers(input.substring(1))) {
            for (int i = 0; i <= item.length(); ++i) {
                String newPermutation = new StringBuilder(item).insert(i, toInsert).toString();
                permutations.add(newPermutation);
            }
        }

        return permutations;
    }
}
