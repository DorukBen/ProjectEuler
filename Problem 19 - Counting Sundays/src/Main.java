import java.util.Calendar;

/**
 * Counting Sundays
 * Problem 19
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * Created by doruk on 31.05.2017.
 */

public class Main {

    private static final int START_YEAR = 1901;

    private static final int END_YEAR = 2000;

    public static void main(String[] args) {
        long saturdayCount = 0;
        for (int i = START_YEAR; i < END_YEAR + 1; i++){
            for (int j = 0; j < 12; j++){
                if (isSaturdaysFirstOfMonthInYear(i, j)){
                    saturdayCount++;
                }
            }
        }

        System.out.println(saturdayCount);
    }

    private static boolean isSaturdaysFirstOfMonthInYear(int year, int month){
        Calendar saturday = Calendar.getInstance();

        saturday.set(Calendar.YEAR, year);
        saturday.set(Calendar.DAY_OF_MONTH, 1);
        saturday.set(Calendar.MONTH, month);

        return saturday.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    }
}
