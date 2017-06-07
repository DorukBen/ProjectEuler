/**
 * Amicable numbers
 * Problem 21
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 10000;

    public static void main(String[] args) {
        long sumOfAmicableNumbers = 0;
        for (int i = 2; i < LIMIT; i++){
            long sumOfDivisors = calculateDivisorSum(i);
            if (sumOfDivisors != i && calculateDivisorSum(sumOfDivisors) == i){
                sumOfAmicableNumbers += i;
            }
        }

        System.out.print(sumOfAmicableNumbers);
    }

    private static long calculateDivisorSum(long number){
        long divisorSum = 1;

        int factorCount = 0;
        int divisor = 2;
        long tempNumber = number;
        do {
            if (tempNumber% divisor == 0){
                tempNumber = tempNumber/ divisor;
                factorCount++;
            }else {
                if (factorCount != 0){
                    divisorSum = (int) (divisorSum * ((Math.pow(divisor, factorCount + 1) - 1) / (divisor - 1)));
                    factorCount = 0;
                }

                divisor = (divisor == 2)? divisor + 1: divisor + 2;
            }
        }while (tempNumber >= divisor || factorCount != 0);

        return divisorSum - number;
    }
}
