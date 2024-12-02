package com.advent.of.code;

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
        RaportList raportList = new RaportList();
        for (String splitInput1 : splitInput) {
            String[] split = splitInput1.split(" ");
            Raport raport = new Raport();
            for (String rapport : split) {
                rapport = rapport.strip();
                raport.add(Integer.valueOf(rapport));
            }
            raportList.addRaport(raport);
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

    public static void main(String[] args) {
        System.out.println("=== Advent of Code 2024 ===");
        System.out.println("\n========= Day One =========");
        dayOne();
        System.out.println("\n========= Day Two =========");
        dayTwo();
    }
}