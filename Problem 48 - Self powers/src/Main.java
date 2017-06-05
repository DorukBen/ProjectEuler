/**
 * Self powers
 * Problem 48
 *
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 *
 * Created by doruk on 5.06.2017.
 */

public class Main {

    private static final int DIGIT_COUNT = 10;

    public static void main(String[] args) {
        int[] sumOfNumbers = new int[DIGIT_COUNT];
        for (int i = 1; i <= 1000; i++){
            int[] number = new int[DIGIT_COUNT];
            number[0] = 1;

            for (int j = 0; j < i; j++){
                for (int k = 0; k < number.length; k++){
                    number[k] = number[k] * i;
                }

                for (int k = 0; k < number.length; k++){
                    if (k != number.length - 1){
                        number[k + 1] += number[k]/ 10;
                    }
                    number[k] = number[k]% 10;
                }
            }

            for (int k = 0; k < sumOfNumbers.length; k++){

                sumOfNumbers[k] = sumOfNumbers[k] + number[k];

                if (k != sumOfNumbers.length - 1){
                    sumOfNumbers[k + 1] += sumOfNumbers[k]/ 10;
                }
                sumOfNumbers[k] = sumOfNumbers[k]% 10;
            }
        }


        for (int k = sumOfNumbers.length - 1; k >= 0; k--){
            System.out.print(sumOfNumbers[k]);
        }
    }
}
