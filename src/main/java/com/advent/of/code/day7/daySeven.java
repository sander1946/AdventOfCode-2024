package com.advent.of.code.day7;

import java.math.BigInteger;
import java.util.ArrayList;

import com.advent.of.code.Day;
import com.advent.of.code.scraper.Scraper;

/**
 * Day Seven solution
 */
public class daySeven extends Day {
    private final ArrayList<Equation> equations = new ArrayList<>();
    /**
     * Run the solution for day seven
     */
    @Override
    public void run() {
        System.out.println("\n===== Day Seven ===========");
        Scraper scraper = new Scraper(7);
        String[] input = scraper.getInput();

        for (String line : input) {
            Equation equation = new Equation(line);
            equations.add(equation);
        }

        String[] operators = new String[] {"+", "*", "||"};

        BigInteger totalCalibrationResult = BigInteger.ZERO;
        for (Equation equation : equations) {
            if (equation.isReachable(operators)) {
                totalCalibrationResult = totalCalibrationResult.add(equation.getGoal());
            }
        }
        System.out.println("Total Calibration Result: " + totalCalibrationResult);
    }
}