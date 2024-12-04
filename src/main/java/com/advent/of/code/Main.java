package com.advent.of.code;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.advent.of.code.day1.dayOne;
import com.advent.of.code.day2.dayTwo;
import com.advent.of.code.day3.dayThree;
import com.advent.of.code.day4.dayFour;

/**
 * Main class to run the Advent of Code 2024 challenge
 */
public class Main {
    private static final ArrayList<Day> DAYS = new ArrayList<>();
    /**
     * Main method to run the Advent of Code 2024 challenge
     * @param args If an argument is given, it will run all days regardless of the current day
     */
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int dayOfTheMonth = cal.get(Calendar.DAY_OF_MONTH);
        long startTime;
        long endTime;

        if (args.length != 0) {
            try {
                dayOfTheMonth = args[0].isEmpty() ? 0 : Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                dayOfTheMonth = 0; // Default to run all days if an argument is given
            }
        }

        DAYS.add(new dayOne());
        DAYS.add(new dayTwo());
        DAYS.add(new dayThree());
        DAYS.add(new dayFour());

        System.out.println("=== Advent of Code 2024 ===");
        if (dayOfTheMonth == 0) { // Run all days
            startTime = System.nanoTime();
            
            for (Day day : DAYS) {
                day.run();
            }
            
            endTime = System.nanoTime();
        } else if (!(dayOfTheMonth > 0 && dayOfTheMonth <= DAYS.size())) { // Day is not available
            System.out.println("Day " + dayOfTheMonth + " is not available yet");
            return;
        } else { // Run the specific day
            startTime = System.nanoTime();

            DAYS.get(dayOfTheMonth - 1).run();

            endTime = System.nanoTime();
        }
        long duration = (endTime - startTime);  // divide by 1_000_000 to get milliseconds or by 1_000_000_000 to get seconds
        double seconds = (double) duration / 1_000_000_000;
        int minutes = (int) seconds / 60;
        seconds = seconds % 60;
        
        DecimalFormat df = new DecimalFormat("#.######"); // 6 decimal places (hopefully it won't take more than 9 minutes)
        System.out.println("\n===========================");
        System.out.println("Execution time: " + minutes + "m" + df.format(seconds) + "s");
        System.out.println("===========================");
    }
}