package com.advent.of.code.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.advent.of.code.Day;
import com.advent.of.code.scraper.Scraper;

/**
 * Day Six solution
 */
public class daySix  extends Day {
    /**
     * Run the solution for day six
     */
    @Override
    public void run() {
        System.out.println("\n===== Day Six =============");
        Scraper scraper = new Scraper(6);
        String[] input = scraper.getInput();
        List<List<Character>> grid = new ArrayList<>(); 
        Guard guard = null;

        for (int i = 0; i < input.length; i++) {
            List<Character> line = new ArrayList<>();
            for (int j = 0; j < input[i].length(); j++) {
                char c = input[i].charAt(j);
                line.add(c);
                if (c == Direction.UP.character) {
                    guard = new Guard(i, j, Direction.UP);
                }
            }
            grid.add(line);
        }

        simulateGuardWalk(grid, guard);

        int total = 0;
        List<Pos> potentialSites = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            List<Character> line = grid.get(i);
            for (int j = 0; j < line.size(); j++) {
                Character c = line.get(j);
                if (c == 'X') {
                    potentialSites.add(new Pos(i, j));
                    total++;
                }
            }
        }

        System.out.println("The total of point the guard went to is: " + total);

        total = 0;
        for (Pos pot : potentialSites) {
            resetGrid(grid);
            grid.get(pot.row).set(pot.col, '#');
            if (simulateGuardWalk(grid, guard)) {
                total++;
            }
            grid.get(pot.row).set(pot.col, '.');
        }
        System.out.println("The total ways of creating a loop is:    " + total);
    }

    private static void resetGrid(List<List<Character>> grid) {
        for (List<Character> line : grid) {
            for (int j = 0; j < line.size(); j++) {
                Character c = line.get(j);
                if (c == 'X') {
                    line.set(j, '.');
                }
            }
        }
    }

    private static boolean simulateGuardWalk(List<List<Character>> grid, Guard guard) {
        int rows = grid.size();
        int cols = rows;

        Direction direction = guard.direction();
        int row = guard.indexX();
        int col = guard.indexY();
        Set<Turn> turns = new HashSet<>();
        while (true) {
            grid.get(row).set(col, 'X');
            int newRow = row + direction.row;
            int newCol = col + direction.col;
            if (newRow >= 0 && newCol >= 0 && newRow <= rows - 1 && newCol <= cols - 1) {
                if (grid.get(newRow).get(newCol) == '#') {
                    Turn cur = new Turn(row, col, direction);
                    if (turns.contains(cur)) {
                        return true; // Loop detected
                    }
                    direction = direction.right();
                    turns.add(cur);
                } else {
                    row = newRow;
                    col = newCol;
                }
            } else {
                return false;
            }
        }
    }

    record Pos(int row, int col) {
    }

    record Turn(int row, int col, Direction direction) {
    }

    record Guard(int indexX, int indexY, Direction direction) {
    }
}