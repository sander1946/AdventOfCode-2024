package com.advent.of.code.day1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * MinHeap class
 */
public class MinHeap extends ArrayList<Integer> {
    /**
     * Create an empty MinHeap
     */
    public MinHeap() {
        super();
    }

    /**
     * Create a MinHeap with the specified initial capacity
     * @param initialCapacity the initial capacity of the MinHeap
     */
    public MinHeap(Integer initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Create a MinHeap and fill it with the specified list
     * @param list the list to fill the MinHeap with
     */
    public MinHeap(ArrayList<Integer> list) {
        super(list);
        this.build_heap();
    }

    /**
     * Add the specified value to the MinHeap
     * @param value the value to be added
     */
    public void push(Integer value) {
        this.add(value);
        this.heapifyUp(this.size() - 1);
    }

    /**
     * Remove and return the smallest value from the MinHeap
     * @return the smallest value in the MinHeap
     */
    public Integer pop() {
        Integer value = this.get(0);
        this.set(0, this.get(this.size() - 1));
        this.remove(this.size() - 1);
        this.heapifyDown(0);
        return value;        
    }

    /**
     * Build the MinHeap from it's own saved list
     */
    private void build_heap() {
        for (Integer i = this.size() / 2; i >= 0; i--) {
            this.heapifyDown(i);
        }
    }

    /**
     * Heapify the MinHeap up
     * @param index the index to heapify up
     */
    private void heapifyUp(Integer index) {
        Integer parentIndex = (index - 1) / 2;
        if (this.get(index) < this.get(parentIndex)) {
            Integer temp = this.get(index);
            this.set(index, this.get(parentIndex));
            this.set(parentIndex, temp);
            this.heapifyUp(parentIndex);
        }
    }

    /**
     * Heapify the MinHeap down
     * @param index the index to heapify down
     */
    private void heapifyDown(Integer index) {
        Integer leftChildIndex = 2 * index + 1;
        Integer rightChildIndex = 2 * index + 2;
        Integer smallestIndex = index;

        if (leftChildIndex < this.size() && this.get(leftChildIndex) < this.get(smallestIndex)) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < this.size() && this.get(rightChildIndex) < this.get(smallestIndex)) {
            smallestIndex = rightChildIndex;
        }

        if (!Objects.equals(smallestIndex, index)) {
            Integer temp = this.get(index);
            this.set(index, this.get(smallestIndex));
            this.set(smallestIndex, temp);
            this.heapifyDown(smallestIndex);
        }
    }
}
