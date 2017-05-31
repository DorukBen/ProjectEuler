/**
 * 10001st prime
 * Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10.001st prime number?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int PLACE = 10001;

    public static void main(String[] args) {
        long first = System.currentTimeMillis();
        long prime = 2;
        for (int i = 0; i < PLACE - 1; i++){
            prime = findNextPrime(prime);
        }

        long last = System.currentTimeMillis();

        System.out.print(prime + "        " + (last - first));
    }

    private static long findNextPrime(long prime){
        long nextPrime = prime;

        nextPrime = (nextPrime == 2)? nextPrime + 1: nextPrime + 2;
        int i;
        for (i = 2; i < (nextPrime / 2) + 1 && nextPrime % i != 0; i++);

        if (nextPrime % i != 0){
            return nextPrime;
        }else {
            return findNextPrime(nextPrime);
        }
    }
}
