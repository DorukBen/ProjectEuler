/**
 * Number letter counts
 * Problem 17
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters
 * used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
 * (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int LIMIT = 1000;

    private static final String[] NUMBERS = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private static final String[] TENS = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] HUNDRED = {"",
            "hundred"};

    private static final String[] THOUSAND = {"",
            "thousand"};

    public static void main(String[] args) {

        long sum = 0;
        for (int i = 1; i <= LIMIT; i++){
            String word = getNumbersEnglishWords(i).replaceAll("\\s+","");

            sum += word.length();
        }

        System.out.print(sum);
    }

    private static String getNumbersEnglishWords(int number){
        return NUMBERS[(number%10000)/1000] + " " +THOUSAND[((number%10000)/1000 != 0)? 1: 0] + " " + NUMBERS[(number%1000)/100] + " " + HUNDRED[((number%1000)/100 != 0)? 1: 0] +
                ((number%100 > 0)&& ((number%1000)/100 != 0)? "and": "") + (((number%100) > 19)? TENS[(number%100)/10] + NUMBERS[number%10]: NUMBERS[number%100]);
    }
}
