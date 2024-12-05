package com.advent.of.code.day5;

public class Rule {
    public final int first;
    public final int second;

    public Rule(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Rule: " + first + " | " + second;
    }
}
