/**
 * Goldbach's other conjecture
 * Problem 46
 *
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 *
 *                                 9 = 7 + 2×12
 *                                 15 = 7 + 2×22
 *                                 21 = 3 + 2×32
 *                                 25 = 7 + 2×32
 *                                 27 = 19 + 2×22
 *                                 33 = 31 + 2×12
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 *
 * Created by doruk on 3.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        boolean followingRule = true;
        long index = 6;
        while (followingRule){
            long number = (2 * index) - 1;
            boolean isInConjecture = false;
            for (int i = 0; (2 * Math.pow(i, 2)) < number && !isInConjecture; i++){
                if (isPrime((long) (number - (2 * Math.pow(i, 2))))){
                    isInConjecture = true;
                }
            }

            if (isInConjecture){
                index++;
            }else {
                followingRule = false;
            }
        }

        System.out.print(((2 * index) - 1));
    }

    private static boolean isPrime(long number) {
        if (number < 2){
            return false;
        }

        for(int i = 2 ; i < number; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}
