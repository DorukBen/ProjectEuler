/**
 * Largest prime factor
 * Problem 3
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final long NUMBER = 600851475143L;

    public static void main(String[] args) {
        long number = NUMBER;
        long largestFactor = 0;

        int prime = 2;
        while (prime <= number) {
            if (number % prime == 0) {
                number = number / prime;
                largestFactor = prime;
            } else {
                prime++;
            }
        }

        System.out.print(largestFactor);
    }

}
