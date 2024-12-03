package com.advent.of.code.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.advent.of.code.Day;
import com.advent.of.code.scraper.Scraper;

/**
 * Day Three solution
 */
public class dayThree extends Day {
    private static boolean dont = false;
    /**
     * Run the solution for day three
     */
    @Override
    public void run() {
        System.out.println("\n===== Day Three ===========");
        // Part One
        Scraper scraper = new Scraper(3);
        String[] input = scraper.getInput();
        int total = 0;
        for (String line : input) {
            Pattern pattern = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                int leftDigit = Integer.parseInt(matcher.group().split(",")[0].split("\\(")[1]);
                int rightDigit = Integer.parseInt(matcher.group().split(",")[1].split("\\)")[0]);
                if (leftDigit > 999 || rightDigit > 999 || leftDigit < -999 || rightDigit < -999) {
                    continue;
                }
                total += leftDigit * rightDigit;
            }
        }
        System.out.println("Result of the normal multiplications: " + total);

        // Part Two
        total = 0;
        for (String line : input) {
            Pattern pattern = Pattern.compile("mul\\([0-9]+,[0-9]+\\)|don't\\(\\)|do\\(\\)");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group().equals("do()")) {
                    dayThree.dont = false;
                    continue;
                } else if (matcher.group().equals("don't()") || dayThree.dont) {
                    dayThree.dont = true;
                    continue;
                }
                int leftDigit = Integer.parseInt(matcher.group().split(",")[0].split("\\(")[1]);
                int rightDigit = Integer.parseInt(matcher.group().split(",")[1].split("\\)")[0]);
                if (leftDigit > 999 || rightDigit > 999 || leftDigit < -999 || rightDigit < -999) {
                    continue;
                }
                total += leftDigit * rightDigit;
            }
        }
        System.out.println("Result of the logic multiplications:  " + total);
    }
}