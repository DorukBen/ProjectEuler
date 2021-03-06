/**
 * Digit fifth powers
 * Problem 30
 *
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 *              1634 = 1^4 + 6^4 + 3^4 + 4^4
 *              8208 = 8^4 + 2^4 + 0^4 + 8^4
 *              9474 = 9^4 + 4^4 + 7^4 + 4^4
 *
 * As 1 = 14 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final int POWER = 5;

    public static void main(String[] args) {
        long sumOfNumbers = 0;

        int digitCount = 1;
        long currentNumber = 2;

        while (currentNumber < digitCount * Math.pow(9, POWER)){
            long sumOfDigits = 0;
            for (int i = 0; i < digitCount; i++){
                int digit = (int) ((currentNumber%Math.pow(10, i + 1) - currentNumber%Math.pow(10, i))/ Math.pow(10, i));

                sumOfDigits += Math.pow(digit ,POWER);
            }

            if (sumOfDigits == currentNumber){
                sumOfNumbers += currentNumber;
            }

            currentNumber++;
            digitCount = String.valueOf(currentNumber).length();
        }

        System.out.print(sumOfNumbers);
    }
}
