import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Names scores
 * Problem 22
 *
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin
 * by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its
 * alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th
 * name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        String text = readFile("p022_names.txt");
        String[] names =  stringToStringArray(text);
        Arrays.sort(names);
        int[] scores = new int[names.length];

        for (int i = 0; i < names.length; i++){
            char[] digits = names[i].toCharArray();
            for (char digit : digits) {
                scores[i] += digit - 64;
            }
        }

        long sumOfScores = 0;
        for (int i = 0; i < scores.length; i++){
            sumOfScores += (i + 1) * scores[i];
        }

        System.out.print(sumOfScores);
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

    private static String[] stringToStringArray(String text){
        String[] strings = text.split(",");

        for (int i = 0; i < strings.length; i++){
            strings[i] = strings[i].replace("\"", "");
        }

        return strings;
    }
}
