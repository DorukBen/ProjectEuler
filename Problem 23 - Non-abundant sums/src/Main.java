import java.util.ArrayList;

/**
 * Non-abundant sums
 * Problem 23
 *
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
 * the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two
 * abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as
 * the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that
 * the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 28123;

    public static void main(String[] args) {
        ArrayList<Integer> abundantNumbers = findAbundantNumbers();

        boolean[] canBeWrittenAsAbundant = new boolean[LIMIT + 1];
        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i; j < abundantNumbers.size(); j++) {
                if (abundantNumbers.get(i) + abundantNumbers.get(j) <= LIMIT) {
                    canBeWrittenAsAbundant[abundantNumbers.get(i) + abundantNumbers.get(j)] = true;
                }
            }
        }

        long sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (!canBeWrittenAsAbundant[i]) {
                sum += i;
            }
        }

        System.out.print(sum);
    }

    private static long calculateDivisorSum(long number){
        long divisorSum = 1;

        int factorCount = 0;
        int divisor = 2;
        long tempNumber = number;
        do {
            if (tempNumber% divisor == 0){
                tempNumber = tempNumber/ divisor;
                factorCount++;
            }else {
                if (factorCount != 0){
                    divisorSum = (int) (divisorSum * ((Math.pow(divisor, factorCount + 1) - 1) / (divisor - 1)));
                    factorCount = 0;
                }

                divisor = (divisor == 2)? divisor + 1: divisor + 2;
            }
        }while (tempNumber >= divisor || factorCount != 0);

        return divisorSum - number;
    }

    private static ArrayList<Integer> findAbundantNumbers(){
        int index = 1;
        ArrayList<Integer> abundantNumbers = new ArrayList<>();

        while (index <= LIMIT){
            if (calculateDivisorSum(index) > index){
                abundantNumbers.add(index);
            }
            index++;
        }

        return abundantNumbers;
    }
}
