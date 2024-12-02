package com.advent.of.code;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void dayOne() {
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

    public static void dayThree() {
        
    }

    public static void dayFour() {

    }

    public static void dayFive() {

    }

    public static void daySix() {

    }

    public static void daySeven() {

    }

    public static void dayEight() {

    }

    public static void dayNine() {

    }

    public static void dayTen() {

    }

    public static void dayEleven() {

    }

    public static void dayTwelve() {

    }

    public static void dayThirteen() {

    }

    public static void dayFourteen() {

    }

    public static void dayFiveteen() {

    }

    public static void daySixteen() {

    }

    public static void daySeventeen() {

    }

    public static void dayEightteen() {

    }

    public static void dayNineteen() {

    }

    public static void dayTwenty() {

    }

    public static void dayTwentyOne() {

    }

    public static void dayTwentyTwo() {

    }

    public static void dayTwentyThree() {

    }

    public static void dayTwentyFour() {

    }

    public static void dayTwentyFive() {

    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int dayOfTheMonth = cal.get(Calendar.DAY_OF_MONTH);
        if (args.length != 0) {
            dayOfTheMonth = 0; // Default to run all days if an argument is given
        }
        
        System.out.println("=== Advent of Code 2024 ===");
        switch (dayOfTheMonth) {
            case 1 -> {
                System.out.println("\n===== Day One =============");
                dayOne();
            }
            case 2 -> {
                System.out.println("\n===== Day Two =============");
                dayTwo();
            }
            case 3 -> {
                System.out.println("\n===== Day Three ===========");
                dayThree();
            }
            case 4 -> {
                System.out.println("\n===== Day Four ============");
                dayFour();
            }
            case 5 -> {
                System.out.println("\n===== Day Five ============");
                dayFive();
            }
            case 6 -> {
                System.out.println("\n===== Day Six =============");
                daySix();
            }
            case 7 -> {
                System.out.println("\n===== Day Seven ===========");
                daySeven();
            }
            case 8 -> {
                System.out.println("\n===== Day Eight ===========");
                dayEight();
            }
            case 9 -> {
                System.out.println("\n===== Day Nine ============");
                dayNine();
            }
            case 10 -> {
                System.out.println("\n===== Day Ten =============");
                dayTen();
            }
            case 11 -> {
                System.out.println("\n===== Day Eleven ==========");
                dayEleven();
            }
            case 12 -> {
                System.out.println("\n===== Day Twelve ==========");
                dayTwelve();
            }
            case 13 -> {
                System.out.println("\n===== Day Thirteen ========");
                dayThirteen();
            }
            case 14 -> {
                System.out.println("\n===== Day Fourteen ========");
                dayFourteen();
            }
            case 15 -> {
                System.out.println("\n===== Day Fiveteen ========");
                dayFiveteen();
            }
            case 16 -> {
                System.out.println("\n===== Day Sixteen =========");
                daySixteen();
            }
            case 17 -> {
                System.out.println("\n===== Day Seventeen =======");
                daySeventeen();
            }
            case 18 -> {
                System.out.println("\n===== Day Eightteen =======");
                dayEightteen();
            }
            case 19 -> {
                System.out.println("\n===== Day Nineteen ========");
                dayNineteen();
            }
            case 20 -> {
                System.out.println("\n===== Day Twenty ==========");
                dayTwenty();
            }
            case 21 -> {
                System.out.println("\n===== Day TwentyOne =======");
                dayTwentyOne();
            }
            case 22 -> {
                System.out.println("\n===== Day TwentyTwo =======");
                dayTwentyTwo();
            }
            case 23 -> {
                System.out.println("\n===== Day TwentyThree =====");
                dayTwentyThree();
            }
            case 24 -> {
                System.out.println("\n===== Day TwentyFour ======");
                dayTwentyFour();
            }
            case 25 -> {
                System.out.println("\n===== Day TwentyFive ======");
                dayTwentyFive();
            }
            default -> {
                System.out.println("\n===== Day One =============");
                dayOne();
                System.out.println("\n===== Day Two =============");
                dayTwo();
                System.out.println("\n===== Day Three ===========");
                dayThree();
                System.out.println("\n===== Day Four ============");
                dayFour();
                System.out.println("\n===== Day Five ============");
                dayFive();
                System.out.println("\n===== Day Six =============");
                daySix();
                System.out.println("\n===== Day Seven ===========");
                daySeven();
                System.out.println("\n===== Day Eight ===========");
                dayEight();
                System.out.println("\n===== Day Nine ============");
                dayNine();
                System.out.println("\n===== Day Ten =============");
                dayTen();
                System.out.println("\n===== Day Eleven ==========");
                dayEleven();
                System.out.println("\n===== Day Twelve ==========");
                dayTwelve();
                System.out.println("\n===== Day Thirteen ========");
                dayThirteen();
                System.out.println("\n===== Day Fourteen ========");
                dayFourteen();
                System.out.println("\n===== Day Fiveteen ========");
                dayFiveteen();
                System.out.println("\n===== Day Sixteen =========");
                daySixteen();
                System.out.println("\n===== Day Seventeen =======");
                daySeventeen();
                System.out.println("\n===== Day Eightteen =======");
                dayEightteen();
                System.out.println("\n===== Day Nineteen ========");
                dayNineteen();
                System.out.println("\n===== Day Twenty ==========");
                dayTwenty();
                System.out.println("\n===== Day TwentyOne =======");
                dayTwentyOne();
                System.out.println("\n===== Day TwentyTwo =======");
                dayTwentyTwo();
                System.out.println("\n===== Day TwentyThree =====");
                dayTwentyThree();
                System.out.println("\n===== Day TwentyFour ======");
                dayTwentyFour();
                System.out.println("\n===== Day TwentyFive ======");
                dayTwentyFive();
            }
        }
        System.out.println("\n===========================");
    }
}