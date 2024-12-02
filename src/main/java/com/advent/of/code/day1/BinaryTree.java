package com.advent.of.code.day1;

/**
 * A binary tree class
 */
public class BinaryTree {
    Node root;

    /**
     * Constructor for BinaryTree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Method to insert a new key in the tree
     * @param key - the key to be inserted
     */
    public void insert(int key) {
        root = insertRec(root, key);
    }

    /**
     * A utility function to insert a new key in the tree
     * @param root - the root node
     * @param key - the key to be inserted
     * @return the root node
     */
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
    
        // Otherwise, recur down the tree 
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        } else if (key == root.key) {
            root.count++; // Increment count for duplicate key
        }
    
        // return the (unchanged) node pointer 
        return root;
    }

    /**
     * print the tree inorder
     */
    public void inorder() {
        inorderRec(root);
    }

    /**
     * A utility function to do inorder traversal of BST
     * @param root - the root node
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    /**
     * Method to search for a key in the tree
     * @param key - the key to search for
     * @return the node with the key
     */
    public Node search(int key) {
        return searchRec(root, key);
    }

    /**
     * A utility function to search for a key in the tree
     * @param root - the root node
     * @param key - the key to search for
     * @return the node with the key
     */
    private Node searchRec(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            return root;
        }
        
        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    /**
     * Method to find the minimum value in the tree
     * @return the minimum value in the tree
     */
    public int findMin() {
        return findMinRec(root);
    }

    /**
     * A utility function to find the minimum value in the tree
     * @param root - the root node
     * @return the minimum value in the tree
     */
    private int findMinRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.left == null)
            return root.key;

        return findMinRec(root.left);
    }

    /**
     * Method to find the maximum value in the tree
     * @return the maximum value in the tree
     */
    public int findMax() {
        return findMaxRec(root);
    }

    /**
     * A utility function to find the maximum value in the tree
     * @param root - the root node
     * @return the maximum value in the tree
     */
    private int findMaxRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.right == null)
            return root.key;

        return findMaxRec(root.right);
    }
}
