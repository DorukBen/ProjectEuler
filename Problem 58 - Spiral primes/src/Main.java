/**
 * Spiral primes
 * Problem 58
 *
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 *
 *                                              37 36 35 34 33 32 31
 *                                              38 17 16 15 14 13 30
 *                                              39 18  5  4  3 12 29
 *                                              40 19  6  1  2 11 28
 *                                              41 20  7  8  9 10 27
 *                                              42 21 22 23 24 25 26
 *                                              43 44 45 46 47 48 49
 *
 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out
 * of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 *
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this
 * process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first
 * falls below 10%?
 * Created by doruk on 8.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        int primeCount = 3;
        int sideLength = 3;

        while (primeCount/ (float) ((2 * sideLength) - 1) >= 0.10){
            sideLength += 2;

            int number = sideLength * sideLength;

            for (int i = 1; i < 4; i++){
                if (isPrime(number - (i * (sideLength - 1)))){
                    primeCount++;
                }
            }
        }

        System.out.print(sideLength);
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
