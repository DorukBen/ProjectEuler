/**
 * Integer right triangles
 * Problem 39
 *
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    private static final int LIMIT = 1000;

    public static void main(String[] args) {
        int largestTriangleCount = 0;
        int largestPerimeter = 0;
        for (int p = 1; p <= LIMIT; p++){
            int triangleCount = 0;
            for (int i = 1; i < p - 2; i++){
                for (int j = i; j < p; j++){
                    double otherSide = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                    if (i + j + otherSide == p){
                        triangleCount++;
                    }
                }
            }

            if (triangleCount > largestTriangleCount){
                largestTriangleCount = triangleCount;
                largestPerimeter = p;
            }
        }

        System.out.print(largestPerimeter);
    }
}
