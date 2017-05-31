/**
 * Special Pythagorean triplet
 * Problem 9
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 *                              a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int SUM_OF_SIDES = 1000;

    public static void main(String[] args) {
        int thirdSide = -1;
        for (int firstSide = 1; firstSide < SUM_OF_SIDES && thirdSide == -1; firstSide++){
            for (int secondSide = 1; secondSide < SUM_OF_SIDES - firstSide && thirdSide == -1; secondSide++){
                if (Math.pow(firstSide,2) + Math.pow(secondSide,2) == Math.pow(SUM_OF_SIDES - firstSide - secondSide, 2)){
                    thirdSide = (SUM_OF_SIDES - firstSide - secondSide);
                    
                    System.out.print(firstSide * secondSide * thirdSide);
                }
            }
        }
    }
}
