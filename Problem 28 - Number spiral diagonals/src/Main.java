/**
 * Number spiral diagonals
 * Problem 28
 *
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows
 *
 *                                          21 22 23 24 25
 *                                          20  7  8  9 10
 *                                          19  6  1  2 11
 *                                          18  5  4  3 12
 *                                          17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final int WIDTH = 1001;

    public static void main(String[] args) {
        long totalSum = 1;

        int number;
        for (int i = 1; i < (WIDTH/ 2) + 1; i++){
            number = (2 * i) + 1;
            totalSum += Math.pow(number, 2) + (Math.pow(number, 2) - (number - 1))
                    + (Math.pow(number, 2) - (2 * (number - 1))) + (Math.pow(number, 2) - (3 * (number - 1)));
        }

        System.out.print(totalSum);
    }
}
