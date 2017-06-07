import java.util.Arrays;

/**
 * Lychrel numbers
 * Problem 55
 *
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 *
 * Not all numbers produce palindromes so quickly. For example,
 *
 *               349 + 943 = 1292,
 *              1292 + 2921 = 4213
 *              4213 + 3124 = 7337
 *
 * That is, 349 took three iterations to arrive at a palindrome.
 *
 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. A number that never
 * forms a palindrome through the reverse and add process is called a Lychrel number. Due to the theoretical nature of these
 * numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise. In addition you
 * are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or,
 * (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first
 * number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664
 * (53 iterations, 28-digits).
 *
 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 *
 * How many Lychrel numbers are there below ten-thousand?
 *
 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
 *
 * Created by doruk on 8.06.2017.
 */

public class Main {

    private static final int NUMBER_LIMIT = 10000;
    private static final int TRY_LIMIT = 50;

    public static void main(String[] args) {
        int lychrelCount = 0;

        int[] index = new int[]{0};

        while (index.length < (int) Math.log10(NUMBER_LIMIT) + 1){
            int[] number = index;
            int[] reverse = reverseNumber(number.clone());

            int tryCount = 0;
            boolean isPalindrome = false;
            while (tryCount < TRY_LIMIT && !isPalindrome){
                int[] sum = sumNumbers(number, reverse);

                if (isPalindrome(sum)){
                    isPalindrome = true;
                }else {
                    number = sum;
                    reverse = reverseNumber(number.clone());
                    tryCount++;
                }
            }

            if (!isPalindrome){
                lychrelCount++;
            }

            int[] increase = new int[index.length];
            increase[increase.length - 1] = 1;
            index = sumNumbers(index, increase);
        }

        System.out.print(lychrelCount);
    }

    private static int calculateSumLength(int[] number, int[] reverse){
        int sumOfDigits = 9;

        for (int i = 0; i < number.length && sumOfDigits == 9; i++){
            sumOfDigits = number[i] + reverse[i];
        }

        return (sumOfDigits > 9)? number.length + 1: number.length;
    }

    private static boolean isPalindrome(int[] number){
        for (int i = 0; i < (number.length/ 2); i++){
            if (number[i] != number[number.length - 1 - i]){
                return false;
            }
        }
        return true;
    }

    private static int[] reverseNumber(int[] number){
        for (int i = 0; i < (number.length)/ 2; i++){
            int temp = number[i];
            number[i] = number[number.length - 1 - i];
            number[number.length - 1 - i] = temp;
        }

        return number;
    }

    private static int[] sumNumbers(int[] number, int[] reverse){
        int[] sum = new int[calculateSumLength(number, reverse)];
        int increase = (sum.length == number.length)? 0: 1;

        for (int i = number.length - 1; i >= 0; i--){
            sum[i + increase] += number[i] + reverse[i];

            if (i + increase != 0){
                sum[i + increase - 1] += sum[i + increase]/ 10;
            }
            sum[i + increase] = sum[i + increase]% 10;
        }

        return sum;
    }
}
