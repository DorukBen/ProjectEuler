/**
 * Triangular, pentagonal, and hexagonal
 * Problem 45
 *
 * Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
 *
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 * Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
 * Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 *
 * It can be verified that T285 = P165 = H143 = 40755.
 *
 * Find the next triangle number that is also pentagonal and hexagonal.
 *
 * Created by doruk on 3.06.2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
        long triangleIndex = 286;
        long pentagonalIndex = 166;
        long hexagonalIndex = 144;

        long triangleNumber = (triangleIndex * (triangleIndex + 1))/ 2;
        long pentagonalNumber = (pentagonalIndex * ((3 * pentagonalIndex) - 1))/ 2;
        long hexagonalNumber = hexagonalIndex * ((2 * hexagonalIndex) - 1);

        while (triangleNumber != pentagonalNumber || pentagonalNumber != hexagonalNumber){
            if (triangleNumber < pentagonalNumber || triangleNumber < hexagonalNumber){
                triangleIndex++;
                triangleNumber = (triangleIndex * (triangleIndex + 1))/ 2;
            }

            if (pentagonalNumber < triangleNumber || pentagonalNumber < hexagonalNumber){
                pentagonalIndex++;
                pentagonalNumber = (pentagonalIndex * ((3 * pentagonalIndex) - 1))/ 2;
            }

            if (hexagonalNumber < triangleNumber || hexagonalNumber < pentagonalNumber){
                hexagonalIndex++;
                hexagonalNumber = hexagonalIndex * ((2 * hexagonalIndex) - 1);
            }
        }

        System.out.print(triangleNumber);
    }
}
