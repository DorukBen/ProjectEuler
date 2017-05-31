import java.util.ArrayList;

/**
 * Smallest multiple
 * Problem 5
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 20;

    public static void main(String[] args) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 2; i < LIMIT; i++){
            int number = i;
            for (Integer prime: factors){
                if (number% prime == 0){
                    number = number / prime;
                }
            }

            if (number != 1){
                factors.add(number);
            }
        }

        int smallestMultiple = 1;
        for (Integer prime: factors){
            smallestMultiple = smallestMultiple * prime;
        }

        System.out.print(smallestMultiple);
    }

}
