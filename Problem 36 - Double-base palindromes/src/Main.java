import java.util.Objects;

/**
 * Double-base palindromes
 * Problem 36
 *
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        long sumOfPalindromes = 0;

        for (int i = 0; i < LIMIT; i++){
            if (isPalindrome(String.valueOf(i))){
                if (isPalindrome(Integer.toString(i,2))){
                    sumOfPalindromes += i;
                }
            }
        }

        System.out.print(sumOfPalindromes);
    }

    private static boolean isPalindrome(String number){

        return Objects.equals(new StringBuilder(number.substring(0, number.length() / 2)).reverse().toString(),
                number.substring(number.length() - (number.length() / 2), number.length()));
    }
}
