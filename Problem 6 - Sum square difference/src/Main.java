/**
 * Sum square difference
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 *
 *                      1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 *
 *                      (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 100;

    public static void main(String[] args) {
        int diff = (int) Math.pow((LIMIT * (LIMIT + 1))/ 2, 2) - ((LIMIT * (LIMIT + 1) * (2 * LIMIT + 1))/ 6);

        System.out.print(diff);
    }
}
