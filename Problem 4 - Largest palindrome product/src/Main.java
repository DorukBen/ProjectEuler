import java.util.Objects;

/**
 * Largest palindrome product
 * Problem 4
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 ×
 * 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int DIGIT_COUNT = 3;

    public static void main(String[] args) {
        int firstNumber = calculateLargestNumber(DIGIT_COUNT);
        int secondNumber = firstNumber;

        int largestPalindrome = 0;

        while(((int) Math.log10(secondNumber) + 1) == DIGIT_COUNT){
            for (int i = firstNumber; i >= secondNumber; i--){
                if (isPalindrome(i * secondNumber)){
                    if (i * secondNumber > largestPalindrome){
                        largestPalindrome = i * secondNumber;
                    }
                }
            }

            secondNumber--;
        }

        System.out.print(largestPalindrome);
    }

    private static int calculateLargestNumber(int digitCount){
        int num = 0;
        for (int i = 0; i < digitCount; i++){
            num += 9 * Math.pow(10, i);
        }
        return num;
    }

    private static boolean isPalindrome(long number){
        String strNumber = String.valueOf(number);

        return Objects.equals(new StringBuilder(strNumber.substring(0, strNumber.length() / 2)).reverse().toString(),
                strNumber.substring(strNumber.length() - (strNumber.length() / 2), strNumber.length()));
    }
}
