/**
 * Factorial digit sum
 * Problem 20
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int NUMBER = 100;

    public static void main(String[] args) {
        int[] factorial = new int[NUMBER * 10];
        factorial[0] = 1;
        int number = NUMBER;
        while (number != 1){
            for (int i = 0; i < factorial.length; i++){
                factorial[i] = factorial[i] * number;
            }

            for (int i = 0; i < factorial.length-1; i++){
                factorial[i+1] += factorial[i]/10;
                factorial[i] = factorial[i]%10;
            }
            number--;
        }

        long sum = 0;
        for (int aFactorial : factorial) {
            sum += aFactorial;
        }

        System.out.println(sum);
    }
}
