/**
 * Coin sums
 * Problem 31
 *
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final int[] CURRENCY_VALUES = {1, 2, 5, 10, 20, 50, 100, 200};

    private static final int TARGET = 200;

    public static void main(String[] args) {
        int[] possibleWays = new int[TARGET + 1];
        possibleWays[0] = 1;

        for (int currencyValue : CURRENCY_VALUES) {
            for (int j = currencyValue; j <= TARGET; j++) {
                possibleWays[j] += possibleWays[j - currencyValue];
            }
        }

        System.out.print(possibleWays[TARGET]);
    }
}
