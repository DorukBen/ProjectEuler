import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Coded triangle numbers
 * Problem 42
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 *
 *                                      1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values
 * we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number
 * then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words,
 * how many are triangle words?
 *
 * Created by doruk on 3.06.2017.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        String[] names = stringToStringArray(readFile("p042_words.txt"));
        int[] triangleNumbers = findTriangleNumbers(1000);

        int totalCount = 0;
        for (String name : names) {
            int sumOfDigits = 0;
            for (int j = 0; j < name.length(); j++) {
                sumOfDigits += name.charAt(j) - 64;
            }

            int index = 0;
            while (sumOfDigits > triangleNumbers[index]) {
                index++;
            }

            if (triangleNumbers[index] == sumOfDigits) {
                totalCount++;
            }
        }

        System.out.println(totalCount);
    }

    private static String[] stringToStringArray(String text){
        String[] strings = text.split(",");

        for (int i = 0; i < strings.length; i++){
            strings[i] = strings[i].replace("\"", "");
        }

        return strings;
    }

    private static String readFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    private static int[] findTriangleNumbers(int count){
        int[] triangleNumbers = new int[count];

        for (int i = 0; i < count; i++){
            triangleNumbers[i] = ((i + 1) * (i + 2))/ 2;
        }

        return triangleNumbers;
    }
}
