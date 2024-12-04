package com.advent.of.code.day4;

import com.advent.of.code.Day;
import com.advent.of.code.scraper.Scraper;

/**
 * Day Four solution
 */
public class dayFour extends Day {
    /**
     * Run the solution for day four
     */
    @Override
    public void run() {
        System.out.println("\n===== Day Four ============");
        Scraper scraper = new Scraper(4);
        String[] input = scraper.getInput();
        int height = input.length;
        int width = input[0].length();

        int total = 0;
        String rexegString = "XMAS|SAMX";

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j < width-3) { // check horizontal 
                    String temp = input[i].substring(j, j+4);
                    if (temp.matches(rexegString)) {
                        total += 1;
                    }
                } if (i < height-3) { // check vertical
                    String temp = input[i].substring(j, j+1) + input[i+1].substring(j, j+1) + input[i+2].substring(j, j+1) + input[i+3].substring(j, j+1);
                    if (temp.matches(rexegString)) {
                        total += 1;
                    }
                } if (i < height-3 && j < width-3) { // check right diagonal
                    String temp = input[i].substring(j, j+1) + input[i+1].substring(j+1, j+2) + input[i+2].substring(j+2, j+3) + input[i+3].substring(j+3, j+4);
                    if (temp.matches(rexegString)) {
                        total += 1;
                    }
                } if (i < height-3 && j > 2) { // check left diagonal
                    String temp = input[i].substring(j, j+1) + input[i+1].substring(j-1, j) + input[i+2].substring(j-2, j-1) + input[i+3].substring(j-3, j-2);
                    if (temp.matches(rexegString)) {
                        total += 1;
                    }
                }
            }
        }
        System.out.println("The total number of XMAS is:  " + total);
    
        total = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < height-2 && j < width-2) { // check right diagonal
                    String temp = input[i].substring(j, j+1) + input[i+1].substring(j+1, j+2) + input[i+2].substring(j+2, j+3);
                    String temp2 = input[i+2].substring(j, j+1) + input[i+1].substring(j+1, j+2) + input[i].substring(j+2, j+3);
                    if (temp.matches("MAS|SAM") && temp2.matches("MAS|SAM")) {
                        total += 1;
                    }
                }
            }
        }
        System.out.println("The total number of X-MAS is: " + total);
    }
}