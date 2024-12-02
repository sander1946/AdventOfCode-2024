package com.advent.of.code;

import java.util.Calendar;

import com.advent.of.code.day1.dayOne;
import com.advent.of.code.day10.dayTen;
import com.advent.of.code.day11.dayEleven;
import com.advent.of.code.day12.dayTwelve;
import com.advent.of.code.day13.dayThirteen;
import com.advent.of.code.day14.dayFourteen;
import com.advent.of.code.day15.dayFifteen;
import com.advent.of.code.day16.daySixteen;
import com.advent.of.code.day17.daySeventeen;
import com.advent.of.code.day18.dayEighteen;
import com.advent.of.code.day19.dayNineteen;
import com.advent.of.code.day2.dayTwo;
import com.advent.of.code.day20.dayTwenty;
import com.advent.of.code.day21.dayTwentyOne;
import com.advent.of.code.day22.dayTwentyTwo;
import com.advent.of.code.day23.dayTwentyThree;
import com.advent.of.code.day24.dayTwentyFour;
import com.advent.of.code.day25.dayTwentyFive;
import com.advent.of.code.day3.dayThree;
import com.advent.of.code.day4.dayFour;
import com.advent.of.code.day5.dayFive;
import com.advent.of.code.day6.daySix;
import com.advent.of.code.day7.daySeven;
import com.advent.of.code.day8.dayEight;
import com.advent.of.code.day9.dayNine;

public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int dayOfTheMonth = cal.get(Calendar.DAY_OF_MONTH);
        if (args.length != 0) {
            dayOfTheMonth = 0; // Default to run all days if an argument is given
        }
        
        System.out.println("=== Advent of Code 2024 ===");
        long startTime = System.nanoTime();
        switch (dayOfTheMonth) {
            case 1 -> dayOne.run();
            case 2 -> dayTwo.run();
            case 3 -> dayThree.run();
            case 4 -> dayFour.run();
            case 5 -> dayFive.run();
            case 6 -> daySix.run();
            case 7 -> daySeven.run();
            case 8 -> dayEight.run();
            case 9 -> dayNine.run();
            case 10 -> dayTen.run();
            case 11 -> dayEleven.run();
            case 12 -> dayTwelve.run();
            case 13 -> dayThirteen.run();
            case 14 -> dayFourteen.run();
            case 15 -> dayFifteen.run();
            case 16 -> daySixteen.run();
            case 17 -> daySeventeen.run();
            case 18 -> dayEighteen.run();
            case 19 -> dayNineteen.run();
            case 20 -> dayTwenty.run();
            case 21 -> dayTwentyOne.run();
            case 22 -> dayTwentyTwo.run();
            case 23 -> dayTwentyThree.run();
            case 24 -> dayTwentyFour.run();
            case 25 -> dayTwentyFive.run();
            default -> {
                dayOne.run(); dayTwo.run(); dayThree.run(); dayFour.run(); dayFive.run(); daySix.run(); daySeven.run(); dayEight.run(); dayNine.run(); dayTen.run(); dayEleven.run(); dayTwelve.run(); dayThirteen.run(); dayFourteen.run(); dayFifteen.run(); daySixteen.run(); daySeventeen.run(); dayEighteen.run(); dayNineteen.run(); dayTwenty.run(); dayTwentyOne.run(); dayTwentyTwo.run(); dayTwentyThree.run(); dayTwentyFour.run(); dayTwentyFive.run();
            }
        }
        System.out.println("\n===========================");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds
        System.out.println("\nExecution time: " + duration / 1000000 + " milliseconds");
    }
}