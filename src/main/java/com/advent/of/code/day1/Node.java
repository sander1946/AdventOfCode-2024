package com.advent.of.code.day1;

/**
 * Node class for the Binary Search Tree
 */
public class Node {
    public int key;
    public Node left, right;
    public int count;

    /**
     * Constructor for Node
     * @param item - the value/key to be added to the node
    */
    public Node(int value) {
        key = value;
        left = right = null;
        count = 1; // Initialize count to 1
    }
}
