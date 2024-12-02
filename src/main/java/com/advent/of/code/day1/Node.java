package com.advent.of.code.day1;

    // Node Class
public class Node {
    public int key;
    public Node left, right;
    public int count;

    public Node(int item) {
        key = item;
        left = right = null;
        count = 1; // Initialize count to 1
    }
}
