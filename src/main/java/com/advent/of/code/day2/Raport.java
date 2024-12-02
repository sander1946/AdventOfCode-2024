package com.advent.of.code.day2;

import java.util.ArrayList;

public class Raport extends ArrayList<Integer> {
    public Raport() {
        super();
    }

    public Raport(int initialCapacity) {
        super(initialCapacity);
    }

    public Raport(Raport raport) {
        super(raport);
    }

    public Raport(int[] array) {
        for (int i : array) {
            this.add(i);
        }
    }

    public boolean isSave() {
        if (isStrictlyIncreasing() || isStrictlyDecreasing()) {
            return checkDifferences();
        }
        return false;
    }

    private boolean isStrictlyIncreasing() {
        for (int i = 1; i < this.size(); i++) {
            if (this.get(i - 1) >= this.get(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyDecreasing() {
        for (int i = 1; i < this.size(); i++) {
            if (this.get(i - 1) <= this.get(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDifferences() {
        for (int i = 0; i < this.size() - 1; i++) {
            int diff = Math.abs(this.get(i) - this.get(i + 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }

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
