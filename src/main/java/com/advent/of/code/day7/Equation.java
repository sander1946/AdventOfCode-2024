package com.advent.of.code.day7;

import java.math.BigInteger;
import java.util.Arrays;

public class Equation {
    private final BigInteger goal;
    private final BigInteger[] values;

    public Equation(String line) {
        String[] parts = line.split(": ");
        goal = new BigInteger(parts[0]);
        String[] tempvalues = parts[1].strip().split(" ");
        values = new BigInteger[tempvalues.length];
        for (int i = 0; i < tempvalues.length; i++) {
            values[i] = new BigInteger(tempvalues[i]);
        }
    }

    public BigInteger getGoal() {
        return goal;
    }

    public BigInteger[] getValues() {
        return values;
    }

    public boolean isReachable(String[] operators) {
        return checkReachable(values[0], 1, operators);
    }

    private boolean checkReachable(BigInteger current, int index, String[] operators) {
        if (index == values.length) {
            return current.equals(goal);
        }
        for (String operator : operators) {
            BigInteger nextValue = values[index];
            BigInteger newCurrent;
            newCurrent = switch (operator) {
                case "+" -> current.add(nextValue);
                case "*" -> current.multiply(nextValue);
                default -> new BigInteger(current.toString() + nextValue.toString());
            }; // Concatenation operator "||"
            if (checkReachable(newCurrent, index + 1, operators)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Equation [goal:" + goal + ", values:" + Arrays.toString(values) + "]";
    }
}
