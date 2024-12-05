package com.advent.of.code.day5;

import java.util.ArrayList;

import com.advent.of.code.Day;
import com.advent.of.code.scraper.Scraper;

/**
 * Day Five solution
 */
public class dayFive  extends Day {
    private static final ArrayList<Rule> Rules = new ArrayList<>();
    private static final ArrayList<Sequence> Sequences = new ArrayList<>();
    private static final ArrayList<Sequence> invalidSequences = new ArrayList<>();
    /**
     * Run the solution for day five
     */
    @Override
    public void run() {
        System.out.println("\n===== Day Five ============");
        Scraper scraper = new Scraper(5);
        String[] input = scraper.getInput();

        // Part One
        for (String line : input) {
            if (line.contains("|")) {
                String[] split = line.split("\\|");
                Rule rule = new Rule(Integer.parseInt(split[0].strip()), Integer.parseInt(split[1].strip()));
                Rules.add(rule);
            } else if (line.contains(",")) {
                String[] split = line.split(",");
                Sequence sequence = new Sequence(split);
                Sequences.add(sequence);
            } else {// line breaks
            }
        }

        int total = 0;
        for (Sequence sequence : Sequences) {
            boolean valid = true;
            for (Rule rule : Rules) {
                Boolean check = sequence.checkRule(rule); 
                if (check != null) { // they contain the rule
                    if (!check) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                int middleValue = (int) sequence.getMiddleValue();
                total += middleValue;
            } else {
                invalidSequences.add(sequence);
            }
        }
        System.out.println("The total sum of the middle values of the valid sequences is:   " + total);

        // Part Two
        total = 0;
        for (Sequence sequence : invalidSequences) {
            Sequence validSequence = sequence.createValidSequence(Rules);
            int middleValue = (int) validSequence.getMiddleValue();
            total += middleValue;
        }
        System.out.println("The total sum of the middle values of the invalid sequences is: " + total);
    }
}