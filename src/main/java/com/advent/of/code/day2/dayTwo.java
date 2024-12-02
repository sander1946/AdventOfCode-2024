package com.advent.of.code.day2;

import java.util.ArrayList;

import com.advent.of.code.scraper.Scraper;

/**
 * Day Two solution
 */
public class dayTwo {
    /**
     * Run the solution for day two
     */
    public static void run() {
        System.out.println("\n===== Day Two =============");
        // Part One
        Scraper scraper = new Scraper(2);
        String[] input = scraper.getInput();
        ArrayList<Raport> raportList = new ArrayList<>();
        for (String splitInput1 : input) {
            String[] split = splitInput1.split(" ");
            Raport raport = new Raport();
            for (String rapport : split) {
                rapport = rapport.strip();
                raport.add(Integer.valueOf(rapport));
            }
            raportList.add(raport);
        }

        int totalOne = 0;
        for (Raport raport : raportList) {
            if (raport.isSave()) {
                totalOne++;
            }
        }
        System.out.println("The total number of safe raports with no removal is:  " + totalOne);

        // Part Two
        int totalTwo = 0;
        for (Raport raport : raportList) {
            if (raport.isSaveWithOneRemoval()) {
                totalTwo++;
            }
        }
        System.out.println("The total number of safe raports with one removal is: " + totalTwo);
    }
}