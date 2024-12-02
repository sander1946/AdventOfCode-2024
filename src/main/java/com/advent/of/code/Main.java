package com.advent.of.code;

import java.util.ArrayList;
import java.util.Calendar;

import com.advent.of.code.day1.BinaryTree;
import com.advent.of.code.day1.MinHeap;
import com.advent.of.code.day1.Node;
import com.advent.of.code.day2.Raport;
import com.advent.of.code.scraper.Scraper;

public class Main {
    public static void dayOne() {
        System.out.println("\n===== Day One =============");
        // Part One
        int totalDistance = 0;
        Scraper scraper = new Scraper(1);
        String input = scraper.getInput();
        String[] splitInput = input.split("\n");
        MinHeap heapOne = new MinHeap();
        MinHeap heapTwo = new MinHeap();

        for (String splitInput1 : splitInput) {
            String[] split = splitInput1.split("   ");
            split[0] = split[0].strip();
            split[1] = split[1].strip();
            heapOne.push(Integer.valueOf(split[0]));
            heapTwo.push(Integer.valueOf(split[1]));
        }

        if (heapOne.size() != heapTwo.size()) {
            System.out.println("The number of left and right values do not match");
            return;
        }

        while (heapOne.size() >= 1) {
            int leftSmallest = heapOne.pop();
            int rightSmallest = heapTwo.pop();
            int distance = Math.abs(leftSmallest - rightSmallest);
            totalDistance += distance;
        }
        System.out.println("The total distance is:    " + totalDistance);

        // Part Two
        int totalSimilarity = 0;

        MinHeap heap = new MinHeap();
        BinaryTree tree = new BinaryTree();

        for (String splitInput1 : splitInput) {
            String[] split = splitInput1.split("   ");
            split[0] = split[0].strip();
            split[1] = split[1].strip();
            heap.push(Integer.valueOf(split[0]));
            tree.insert(Integer.parseInt(split[1]));
        }

        while (heap.size() >= 1) {
            int leftSmallest = heap.pop();
            Node node = tree.search(leftSmallest);
            if (node != null) {
                totalSimilarity += leftSmallest * node.count;
            }
        }
        System.out.println("The total simulairity is: " + totalSimilarity);
    }

    public static void dayTwo() {
        System.out.println("\n===== Day Two =============");
        Scraper scraper = new Scraper(2);
        String input = scraper.getInput();
        String[] splitInput = input.split("\n");
        ArrayList<Raport> raportList = new ArrayList<>();
        for (String splitInput1 : splitInput) {
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

        int totalTwo = 0;
        for (Raport raport : raportList) {
            if (raport.isSaveWithOneRemoval()) {
                totalTwo++;
            }
        }
        System.out.println("The total number of safe raports with no removal is:  " + totalOne);
        System.out.println("The total number of safe raports with one removal is: " + totalTwo);
    }

    public static void dayThree() {System.out.println("\n===== Day Three ===========");}
    public static void dayFour() {System.out.println("\n===== Day Four ============");}
    public static void dayFive() {System.out.println("\n===== Day Five ============");}
    public static void daySix() {System.out.println("\n===== Day Six =============");}
    public static void daySeven() {System.out.println("\n===== Day Seven ===========");}
    public static void dayEight() {System.out.println("\n===== Day Eight ===========");}
    public static void dayNine() {System.out.println("\n===== Day Nine ============");}
    public static void dayTen() {System.out.println("\n===== Day Ten =============");}
    public static void dayEleven() {System.out.println("\n===== Day Eleven ==========");}
    public static void dayTwelve() {System.out.println("\n===== Day Twelve ==========");}
    public static void dayThirteen() {System.out.println("\n===== Day Thirteen ========");}
    public static void dayFourteen() {System.out.println("\n===== Day Fourteen ========");}
    public static void dayFiveteen() {System.out.println("\n===== Day Fiveteen ========");}
    public static void daySixteen() {System.out.println("\n===== Day Sixteen =========");}
    public static void daySeventeen() {System.out.println("\n===== Day Seventeen =======");}
    public static void dayEightteen() {System.out.println("\n===== Day Eightteen =======");}
    public static void dayNineteen() {System.out.println("\n===== Day Nineteen ========");}
    public static void dayTwenty() {System.out.println("\n===== Day Twenty ==========");}
    public static void dayTwentyOne() {System.out.println("\n===== Day TwentyOne =======");}
    public static void dayTwentyTwo() {System.out.println("\n===== Day TwentyTwo =======");}
    public static void dayTwentyThree() {System.out.println("\n===== Day TwentyThree =====");}
    public static void dayTwentyFour() {System.out.println("\n===== Day TwentyFour ======");}
    public static void dayTwentyFive() {System.out.println("\n===== Day TwentyFive ======");}

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int dayOfTheMonth = cal.get(Calendar.DAY_OF_MONTH);
        if (args.length != 0) {
            dayOfTheMonth = 0; // Default to run all days if an argument is given
        }
        
        System.out.println("=== Advent of Code 2024 ===");
        long startTime = System.nanoTime();
        switch (dayOfTheMonth) {
            case 1 -> dayOne();
            case 2 -> dayTwo();
            case 3 -> dayThree();
            case 4 -> dayFour();
            case 5 -> dayFive();
            case 6 -> daySix();
            case 7 -> daySeven();
            case 8 -> dayEight();
            case 9 -> dayNine();
            case 10 -> dayTen();
            case 11 -> dayEleven();
            case 12 -> dayTwelve();
            case 13 -> dayThirteen();
            case 14 -> dayFourteen();
            case 15 -> dayFiveteen();
            case 16 -> daySixteen();
            case 17 -> daySeventeen();
            case 18 -> dayEightteen();
            case 19 -> dayNineteen();
            case 20 -> dayTwenty();
            case 21 -> dayTwentyOne();
            case 22 -> dayTwentyTwo();
            case 23 -> dayTwentyThree();
            case 24 -> dayTwentyFour();
            case 25 -> dayTwentyFive();
            default -> {dayOne(); dayTwo(); dayThree(); dayFour(); dayFive(); daySix(); daySeven(); dayEight(); dayNine(); dayTen(); dayEleven(); dayTwelve(); dayThirteen(); dayFourteen(); dayFiveteen(); daySixteen(); daySeventeen(); dayEightteen(); dayNineteen(); dayTwenty(); dayTwentyOne(); dayTwentyTwo(); dayTwentyThree(); dayTwentyFour(); dayTwentyFive();}
        }
        System.out.println("\n===========================");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds
        System.out.println("\nExecution time: " + duration / 1000000 + " milliseconds");
    }
}