/**
 * 1000-digit Fibonacci number
 * Problem 25
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final int MATCH = 1000;

    public static void main(String[] args) {
        int[] firstNumber = new int[MATCH];
        int[] secondNumber = new int[MATCH];

        firstNumber[0] = 1;
        secondNumber[0] = 1;

        int index = 2;

        boolean isFirstNumberAdded = false;

        while (firstNumber[MATCH - 1] == 0 && secondNumber[MATCH - 1] == 0){
            if (isFirstNumberAdded){
                for (int i = 0; i < MATCH - 1; i++){
                    secondNumber[i] = firstNumber[i] + secondNumber[i];

                    secondNumber[i+1] += secondNumber[i] / 10;
                    secondNumber[i] = secondNumber[i] % 10;
                }

                isFirstNumberAdded = false;
            }else {
                for (int i = 0; i < MATCH - 1; i++){
                    firstNumber[i] = firstNumber[i] + secondNumber[i];

                    firstNumber[i+1] += firstNumber[i] / 10;
                    firstNumber[i] = firstNumber[i] % 10;
                }

                isFirstNumberAdded = true;
            }
            index++;
        }

        System.out.print(index);
    }
}
