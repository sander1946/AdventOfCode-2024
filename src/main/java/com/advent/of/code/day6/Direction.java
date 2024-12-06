package com.advent.of.code.day6;

public enum Direction {
    UP('^', -1, 0),
    DOWN('V', 1, 0),
    LEFT('<', 0, -1),
    RIGHT('>', 0, 1);

    final char character;
    final int row;
    final int col;

    Direction(char character, int row, int col) {
        this.character = character;
        this.row = row;
        this.col = col;
    }

    Direction right() {
        return switch (this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }
}
