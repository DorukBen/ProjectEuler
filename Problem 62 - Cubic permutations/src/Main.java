import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Cubic permutations
 * Problem 62
 *
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). In fact, 41063625
 * is the smallest cube which has exactly three permutations of its digits which are also cube.
 *
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 *
 * Created by doruk on 18.06.2017.
 */

public class Main {

    private static final int TARGET = 5;

    public static void main(String[] args) {
        HashMap<Long, ArrayList<Long>> cubes = new HashMap<>();

        int number = 345;
        int permutedCubeCount = 0;
        long largestCube = 0;
        while (permutedCubeCount != TARGET){
            number++;

            long cube = (long) Math.pow(number, 3);
            largestCube = permuteLargest(cube);

            if (!cubes.containsKey(largestCube)){
                ArrayList<Long> permutedCubes = new ArrayList<>();
                permutedCubes.add(cube);
                cubes.put(largestCube, permutedCubes);

                permutedCubeCount = permutedCubes.size();
            }else {
                ArrayList<Long> permutedCubes = cubes.get(largestCube);
                permutedCubes.add(cube);
                cubes.put(largestCube, permutedCubes);

                permutedCubeCount = permutedCubes.size();
            }
        }

        System.out.print(LongStream.of(cubes.get(largestCube).stream().mapToLong(Long::longValue).toArray()).sorted().toArray()[0]);
    }

    private static long permuteLargest(long cube) {
        long tempCube = cube;
        int[] digits = new int[(int) Math.floor(Math.log10(cube) + 1)];


        for (int i = 0; i < (int) Math.floor(Math.log10(cube) + 1); i++){
            digits[i] = (int) (tempCube% 10);
            tempCube /= 10;
        }

        digits = IntStream.of(digits).sorted().toArray();

        long largest = 0;
        for (int i = 0; i < digits.length; i++){
            largest += digits[i] * Math.pow(10, i);
        }

        return largest;
    }

}
