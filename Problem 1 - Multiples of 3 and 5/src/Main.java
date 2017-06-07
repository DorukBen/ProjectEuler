/**
 * Multiples of 3 and 5
 * Problem 1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {
    private static final int LIMIT = 1000;
    private static final int FIRST_NUMBER = 3;
    private static final int SECOND_NUMBER = 5;

    public static void main(String[] args) {
        int sum = (FIRST_NUMBER * (((LIMIT - 1)/ FIRST_NUMBER) * (((LIMIT - 1)/ FIRST_NUMBER) + 1)) / 2) +
                (SECOND_NUMBER * (((LIMIT - 1)/ SECOND_NUMBER) * (((LIMIT - 1)/ SECOND_NUMBER) + 1)) / 2) -
                ((FIRST_NUMBER * SECOND_NUMBER) * (((LIMIT - 1)/ (FIRST_NUMBER * SECOND_NUMBER)) * (((LIMIT - 1)/ (FIRST_NUMBER * SECOND_NUMBER)) + 1)) / 2);

        System.out.print(sum);
    }
}
