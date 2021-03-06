/**
 * Combinatoric selections
 * Problem 53
 *
 * There are exactly ten ways of selecting three from five, 12345:
 *
 *              123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general,
 *
 * nCr = n!/r!(n−r)!
 *,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 *
 * Created by doruk on 6.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {

        int count = 0;
        for (int n = 1; n <= 100; n++){
            for (int r = 1; r <= n; r++){
                double numerator = 1;
                if (r >= n - r){
                    for (int i = r + 1; i <= n; i++){
                        numerator = numerator * i;
                        if (i - r <= n - r){
                            numerator = numerator/ (i - r);
                        }
                    }
                }else {
                    for (int i = n - r + 1; i <= n; i++){
                        numerator = numerator * i;
                        if (i - n - r <= r){
                            numerator = numerator/ (i - (n - r));
                        }
                    }
                }

                if (numerator > LIMIT){
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}
