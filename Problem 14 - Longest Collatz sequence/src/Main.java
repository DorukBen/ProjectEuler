/**
 * Longest Collatz sequence
 * Problem 14
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 *                         n → n/2 (n is even)
 *                         n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 *                  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved
 * yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        long number = 1;
        long largestIterationCount = 0;
        long largestIterationCountNumber = 0;

        while (number < LIMIT){
            long iterationCount = 0;
            long tempNumber = number;

            while (tempNumber > 1){
                if (tempNumber%2 == 0){
                    tempNumber = tempNumber / 2;
                }else {
                    tempNumber = 3 * tempNumber + 1;
                }
                iterationCount++;
            }

            if (iterationCount > largestIterationCount){
                largestIterationCount = iterationCount;
                largestIterationCountNumber = number;
            }

            number += 2;
        }

        System.out.print(largestIterationCountNumber);
    }

}
