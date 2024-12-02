package com.advent.of.code.day1;

import com.advent.of.code.scraper.Scraper;

/**
 * Day One solution
 */
public class dayOne {
    /**
     * Run the solution for day one
     */
    public static void run() {
        System.out.println("\n===== Day One =============");
        // Part One
        int totalDistance = 0;
        Scraper scraper = new Scraper(1);
        String[] input = scraper.getInput();
        MinHeap heapOne = new MinHeap();
        MinHeap heapTwo = new MinHeap();

        for (String splitInput1 : input) {
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

        for (String splitInput1 : input) {
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
    
}
