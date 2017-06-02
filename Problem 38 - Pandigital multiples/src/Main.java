/**
 * Pandigital multiples
 * Problem 38
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 *          192 × 1 = 192
 *          192 × 2 = 384
 *          192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192
 * and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is
 * the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with
 * (1,2, ... , n) where n > 1?
 *
 * Created by doruk on 2.06.2017.
 */

public class Main {

    public static void main(String[] args) {
        String largestProduct = "0";

        for (int i = 10; i < 10000; i++ ){
            int n = 0;
            int isPandigital;
            StringBuilder pandigital = new StringBuilder();
            do {
                n++;
                pandigital.append(i * n);
                isPandigital = isPandigital(pandigital.toString());
            }while (isPandigital == 0);

            if (n > 1 && isPandigital == 1){
                if (Long.parseLong(pandigital.toString()) > Long.parseLong(largestProduct)){
                    largestProduct = pandigital.toString();
                }
            }
        }

        System.out.print(largestProduct);
    }

    private static int isPandigital(String concatenatedProduct){
        int isPandigital = 1;
        if (concatenatedProduct.length() > 9){
            isPandigital = -1;
        }else if (concatenatedProduct.length() == 9){
            if (!concatenatedProduct.contains("0")){
                int length = concatenatedProduct.length() - 1;
                for (int i = 0; i < length && isPandigital == 1; i++){
                    String digit = Character.toString(concatenatedProduct.charAt(0));
                    concatenatedProduct = concatenatedProduct.substring(1);

                    if (concatenatedProduct.contains(digit)){
                        isPandigital = -1;
                    }
                }
            }else {
                isPandigital = 0;
            }
        }else {
            isPandigital = 0;
        }


        return isPandigital;
    }
}
