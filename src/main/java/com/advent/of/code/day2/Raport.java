package com.advent.of.code.day2;

import java.util.ArrayList;

/**
 * Raport class
 */
public class Raport extends ArrayList<Integer> {
    /**
     * Create an empty Raport
     */
    public Raport() {
        super();
    }

    /**
     * Create a Raport with the specified initial capacity
     * @param initialCapacity the initial capacity of the Raport
     */
    public Raport(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Create a Raport and fill it with the specified raport
     * @param raport the raport element to fill the Raport with
     */
    public Raport(Raport raport) {
        super(raport);
    }

    /**
     * Create a Raport with the specified elements
     * @param array the elements to fill the Raport with
     */
    public Raport(int[] array) {
        for (int i : array) {
            this.add(i);
        }
    }

    /**
     * Check if the Raport is safe
     * @return true if the Raport is safe, false otherwise
     */
    public boolean isSave() {
        if (isStrictlyIncreasing() || isStrictlyDecreasing()) {
            return checkDifferences();
        }
        return false;
    }

    /**
     * Check if the Raport is strictly increasing
     * @return true if the Raport is strictly increasing, false otherwise
     */
    private boolean isStrictlyIncreasing() {
        for (int i = 1; i < this.size(); i++) {
            if (this.get(i - 1) >= this.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the Raport is strictly decreasing
     * @return true if the Raport is strictly decreasing, false otherwise
     */
    private boolean isStrictlyDecreasing() {
        for (int i = 1; i < this.size(); i++) {
            if (this.get(i - 1) <= this.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the differences between the elements are between 1 and 3
     * @return true if the differences between the elements are between 1 and 3, false otherwise
     */
    private boolean checkDifferences() {
        for (int i = 0; i < this.size() - 1; i++) {
            int diff = Math.abs(this.get(i) - this.get(i + 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the Raport is safe with one removal
     * @return true if the Raport is safe with one removal, false otherwise
     */
    public boolean isSaveWithOneRemoval() {
        if (isSave()) {
            return true;
        }
        for (int i = 0; i < this.size(); i++) {
            Raport tempRaport = new Raport(this);
            tempRaport.remove(i);
            if (tempRaport.isSave()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : this) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }
}
