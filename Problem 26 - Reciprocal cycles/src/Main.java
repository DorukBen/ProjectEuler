/**
 * Reciprocal cycles
 * Problem 26
 *
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000;

    public static void main(String[] args) {
        int largestReciprocalCycleCount = 0;
        int largestReciprocalCycleNumber = 0;

        for (int i = LIMIT; i > 1 && largestReciprocalCycleCount < i; i--) {

            int[] foundRemainders = new int[i];
            int left = 1;
            int position = 0;

            do {
                foundRemainders[left] = position;
                left = left * 10;
                left = left % i;
                position++;
            }while (foundRemainders[left] == 0 && left != 0);

            if (position - foundRemainders[left] > largestReciprocalCycleCount) {
                largestReciprocalCycleCount = position - foundRemainders[left];
                largestReciprocalCycleNumber = i;
            }
        }

        System.out.print(largestReciprocalCycleNumber);
    }

}
