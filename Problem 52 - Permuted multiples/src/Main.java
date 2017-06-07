/**
 * Permuted multiples
 * Problem 52
 *
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 * Created by doruk on 6.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        long number = 1;
        boolean isMultiplesHaveSameDigits = false;

        while (!isMultiplesHaveSameDigits){
            String strNumber = String.valueOf(number);

            int containCharacterCountForMultiples = 0;
            for (int i = 2; i <= 6; i++){
                String productNumber = String.valueOf(i * number);

                if (productNumber.length() == strNumber.length()){
                    int containCharacterCount = 0;
                    for (int j = 0; j < strNumber.length(); j++){
                        if (productNumber.contains(Character.toString(strNumber.charAt(j))) &&
                                strNumber.contains(Character.toString(productNumber.charAt(j)))){
                            containCharacterCount++;
                        }
                    }

                    if (containCharacterCount == strNumber.length()){
                        containCharacterCountForMultiples++;
                    }
                }
            }

            if (containCharacterCountForMultiples == 5){
                isMultiplesHaveSameDigits = true;
            }else {
                number++;
            }
        }

        System.out.print(number);
    }
}
