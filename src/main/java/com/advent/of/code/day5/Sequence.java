package com.advent.of.code.day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Sequence extends ArrayList<Integer> {
    public Sequence() {
        super();
    }

    public Sequence(Integer value) {
        super();
        this.add(value);
    }

    public Sequence(Sequence sequence) {
        super(sequence);
    }

    public Sequence(String[] sequence) {
        super();
        for (String value : sequence) {
            this.add(Integer.valueOf(value.strip()));
        }
    }

    public Sequence addValue(Integer value) {
        this.add(value);
        return this;
    }

    public Sequence insertValue(Integer value, int index) {
        this.add(index, value);
        return this;
    }

    public Sequence addSequence(Sequence sequence) {
        this.addAll(sequence);
        return this;
    }

    public Sequence addSequence(ArrayList<Integer> sequence) {
        this.addAll(sequence);
        return this;
    }

    public Sequence addSequence(Integer[] sequence) {
        this.addAll(Arrays.asList(sequence));
        return this;
    }

    public Integer getMiddleValue() {
        return this.get(this.size() / 2);
    }

    @Override
    public String toString() {
        return "Sequence: " + super.toString();
    }

    public Boolean checkRule(Rule rule) {
        if (this.contains(rule.first) && this.contains(rule.second)) {
            return this.indexOf(rule.first) < this.indexOf(rule.second); 
        }
        return null; // they do not contain the rule
    }

    public Sequence createValidSequence(ArrayList<Rule> rules) {
        int[][] ruleMatrix = new int[100][100];
        for (Rule rule : rules) {
            ruleMatrix[rule.first][rule.second] = 1;
        }

        Sequence validSequence = new Sequence(this);
        validSequence.sort((Integer a, Integer b) -> {
            if (ruleMatrix[a][b] == 1) {
                return -1;
            }
            if (ruleMatrix[b][a] == 1) {
                return 1;
            }
            return 0;
        });

        return validSequence;
    }
}
