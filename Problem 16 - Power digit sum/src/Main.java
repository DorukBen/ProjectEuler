/**
 * Power digit sum
 * Problem 16
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int NUMBER = 2;

    private static final int POWER = 1000;

    public static void main(String[] args) {
        int[] digitArray = new int[POWER];
        digitArray[0] = NUMBER;

        for (int i = 0; i < POWER - 1; i++){
            for (int j = 0; j < digitArray.length; j++){
                digitArray[j] = digitArray[j] * NUMBER;
            }

            for (int j = 0; j < digitArray.length - 1; j++){
                digitArray[j+1] += digitArray[j] /10;
                digitArray[j] = digitArray[j] % 10;
            }
        }

        long sum = 0;
        for (int aDigitArray : digitArray) {
            sum += aDigitArray;
        }

        System.out.print(sum);
    }
}
