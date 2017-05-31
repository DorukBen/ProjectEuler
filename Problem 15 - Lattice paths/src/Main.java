/**
 * Lattice paths
 * Problem 15
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6
 * routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int GRID_LENGTH = 20;

    public static void main(String[] args) {
        int stage = 2 * GRID_LENGTH + 1;
        long[] fibonacciPyramid = new long[(stage*(stage + 1)) / 2];

        fibonacciPyramid[0] = 1;
        fibonacciPyramid[1] = 1;
        fibonacciPyramid[2] = 1;

        for (int i = 1; i < stage - 1; i++){
            fibonacciPyramid[((i + 1) * (i + 2)) / 2] = 1;
            fibonacciPyramid[(((i + 1) * (i + 2)) / 2) + i + 1] = 1;
            for (int j = 0; j < i; j++){
                fibonacciPyramid[((i * (i + 1))/ 2) + i + 2 + j] = fibonacciPyramid[(i * (i + 1))/ 2 + j] + fibonacciPyramid[((i * (i + 1))/ 2) + 1 + j];
            }
        }

        System.out.print(fibonacciPyramid[(((stage*(stage + 1)) / 2) - stage / 2) - 1]);
    }
}
