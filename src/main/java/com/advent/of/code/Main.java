package com.advent.of.code;

import java.util.ArrayList;

public class Main {
    public static void dayOne() {
        // Part One
        int totalDistance = 0;
        Scraper scraper = new Scraper();
        String input = scraper.getInput();
        String[] splitInput = input.split("\n");
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (String splitInput1 : splitInput) {
            String[] split = splitInput1.split("   ");
            left.add(Integer.valueOf(split[0]));
            right.add(Integer.valueOf(split[1]));
        }

        if (left.size() != right.size()) {
            System.out.println("The number of left and right values do not match");
            return;
        }

        while (left.size() >= 1){
            int leftSmallest = left.get(0);
            int rightSmallest = right.get(0);

            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) < leftSmallest) {
                    leftSmallest = left.get(i);
                }
                if (right.get(i) < rightSmallest) {
                    rightSmallest = right.get(i);
                }
            }
            left.remove(left.indexOf(leftSmallest));
            right.remove(right.indexOf(rightSmallest));
            int distance = Math.abs(leftSmallest - rightSmallest);
            totalDistance += distance;
        }
        System.out.println("The total distance is: " + totalDistance);

        // Part Two
        int totalSimulairity = 0;

        // Add the values to the left and right arraylist again
        for (String splitInput1 : splitInput) {
            String[] split = splitInput1.split("   ");
            left.add(Integer.valueOf(split[0]));
            right.add(Integer.valueOf(split[1]));
        }

        for (int leftInt : left) {
            int rightCounter = 0;
            for (int rightInt : right) {
                if (rightInt == leftInt) {
                    rightCounter++;
                }
            }
            int simulairity = leftInt * rightCounter;
            totalSimulairity += simulairity;
        }
        System.out.println("The total simulairity is: " + totalSimulairity);
    }

    public static void main(String[] args) {
        dayOne();
    }
}