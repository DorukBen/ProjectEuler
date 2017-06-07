import java.util.ArrayList;

/**
 * Pandigital products
 * Problem 32
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the
 * 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product
 * is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        ArrayList<String> pandigitalNumbers = permute("123456789");
        ArrayList<Integer> products = new ArrayList<>();

        for (String pandigital: pandigitalNumbers){
            for (int i = 1; i < (pandigital.length()/ 2) + 1; i++){
                int firstNumber = Integer.parseInt(pandigital.substring(0, i));
                int secondNumber = Integer.parseInt(pandigital.substring(i, (pandigital.length()/ 2) + 1));
                int product = Integer.parseInt(pandigital.substring((pandigital.length()/ 2) + 1));

                if (firstNumber * secondNumber == product){
                    if (!products.contains(product)){
                        products.add(product);
                    }
                }
            }
        }

        System.out.print(products.stream().mapToInt(Integer::intValue).sum());
    }

    private static ArrayList<String> permute(String input) {
        ArrayList<String> permutations = new ArrayList<>();

        if (input.length() == 1) {
            permutations.add(Character.toString(input.charAt(0)));
            return permutations;
        }

        String toInsert = Character.toString(input.charAt(0));
        for(String item : permute(input.substring(1))) {
            for (int i = 0; i <= item.length(); ++i) {
                String newPermutation = new StringBuilder(item).insert(i, toInsert).toString();
                permutations.add(newPermutation);
            }
        }

        return permutations;
    }
}
