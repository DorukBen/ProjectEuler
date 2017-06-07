import java.util.ArrayList;

/**
 * Digit cancelling fractions
 * Problem 33
 *
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits
 * in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        float result = 1;

        for (int firstDigit = 1; firstDigit < 10; firstDigit++){
            ArrayList<Integer> possibleNumbers = new ArrayList<>();
            for (int secondDigit = 1; secondDigit < 10; secondDigit++){
                possibleNumbers.add(firstDigit * 10 + secondDigit);
                possibleNumbers.add(secondDigit * 10 + firstDigit);
            }

            for (Integer numerator: possibleNumbers){
                for (Integer denominator: possibleNumbers){
                    if (denominator > numerator){
                        int tempNumerator = Integer.parseInt(String.valueOf(numerator).replaceFirst(String.valueOf(firstDigit), ""));
                        int tempDenominator = Integer.parseInt(String.valueOf(denominator).replaceFirst(String.valueOf(firstDigit), ""));

                        if (tempNumerator / (float)tempDenominator == numerator /(float) denominator){
                            result = result * numerator / denominator;
                        }
                    }
                }
            }
        }

        System.out.print((int)Math.pow(result, -1));
    }
}
