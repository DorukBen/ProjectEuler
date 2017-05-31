/**
 * Lexicographic permutations
 * Problem 24
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic
 * permutations of 0, 1 and 2 are:
 *
 *                                      012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * Created by doruk on 1.06.2017.
 */

public class Main {

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static final int MATCH = 1000000;

    public static void main(String[] args) {
        char[] digits = DIGITS;

        int stage = digits.length;
        StringBuilder number = new StringBuilder();
        long index = 0;
        while (index + 1 != MATCH && stage > 0){
            for (int i = 0; i < stage; i++){
                if (index + findPossiblePermutationCount(stage - 1) + 1 <= MATCH){
                    index += findPossiblePermutationCount(stage - 1);
                }else {
                    if (index == MATCH){
                        number.append(digits[i - 1]);
                        digits = removeFromArray(digits, i - 1);
                    }else {
                        number.append(digits[i]);
                        digits = removeFromArray(digits, i);
                    }

                    i = stage;
                }
            }
            stage--;
        }

        for (char digit : digits) {
            if (!number.toString().contains(Character.toString(digit))) {
                number.append(digit);
            }
        }

        System.out.print(number.toString());
    }

    private static char[] removeFromArray(char[] chars, int index){
        int supIndex = 0;
        int subIndex = 0;
        char[] newChars = new char[chars.length - 1];

        while (supIndex < chars.length - 1){
            if (subIndex == index){
                subIndex++;
            }else {
                newChars[supIndex] = chars[subIndex];
                subIndex++;
                supIndex++;
            }
        }

        return newChars;
    }

    private static long findPossiblePermutationCount(int digitCount){
        long possiblePermutations = 1;
        for (int i = 1; i < digitCount+1; i++){
            possiblePermutations = possiblePermutations * i;
        }

        return possiblePermutations;
    }
}
