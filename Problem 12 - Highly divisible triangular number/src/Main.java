/**
 * Highly divisible triangular number
 * Problem 12
 *
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 +
 * 5 + 6 + 7 = 28. The first ten terms would be:
 *
 *                                                1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 *
 *   1: 1
 *   3: 1,3
 *   6: 1,2,3,6
 *   10: 1,2,5,10
 *   15: 1,3,5,15
 *   21: 1,3,7,21
 *   28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five hundred divisors?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 500;

    public static void main(String[] args) {
        int index = 1;

        while (calculateDivisorCount((index% 2 == 0)? index/ 2: index) * calculateDivisorCount((index% 2 == 0)? index + 1: (index + 1)/ 2) < LIMIT){
            index++;
        }

        System.out.print((index * (index + 1)) / 2);
    }

    private static int calculateDivisorCount(long number){
        int divisorCount = 1;

        int factorCount = 0;
        int divisor = 2;

        do {
            if (number% divisor == 0){
                number = number/ divisor;
                factorCount++;
            }else {
                if (factorCount != 0){
                    divisorCount = divisorCount * (factorCount + 1);
                    factorCount = 0;
                }

                divisor = (divisor == 2)? divisor + 1: divisor + 2;
            }
        }while (number >= divisor || factorCount != 0);

        return divisorCount;
    }
}
