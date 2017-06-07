/**
 * Champernowne's constant
 * Problem 40
 *
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 *
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 *
 * Created by doruk on 3.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        int constantLength = 0;
        int coefficient = 0;
        int product = 1;

        for (int i = 1; i < LIMIT && constantLength < LIMIT; i++){
            String number = String.valueOf(i);

            for (int j = 0; j < number.length(); j++){
                if (constantLength + j + 1 == Math.pow(10, coefficient)){
                    product = product * Character.getNumericValue(number.charAt(j));

                    coefficient++;
                }
            }

            constantLength += number.length();
        }

        System.out.print(product);
    }
}
