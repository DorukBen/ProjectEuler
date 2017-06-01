/**
 * Digit factorials
 * Problem 34
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        int[] factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++){
                int factorial = 1;
                for (int j = 2; j <= i; j++){
                    factorial = factorial * j;
                }
                factorials[i] = factorial;
        }

        int totalSum = 0;
        int digitCount = 1;
        int number = 3;
        while (number <= digitCount * factorials[9]){
            long factorialDigitsSum = 0;
            int tempNumber = number;
            while (tempNumber > 0){
                int digit = tempNumber% 10;
                tempNumber = tempNumber/ 10;

                factorialDigitsSum += factorials[digit];
            }

            if (factorialDigitsSum == number){
                totalSum += number;
            }

            number++;
            digitCount = String.valueOf(number).length();
        }

        System.out.print(totalSum);
    }
}
