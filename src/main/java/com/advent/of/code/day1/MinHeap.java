package com.advent.of.code.day1;

import java.util.ArrayList;
import java.util.Objects;

public class MinHeap extends ArrayList<Integer> {
    public MinHeap() {
        super();
    }

    public MinHeap(Integer initialCapacity) {
        super(initialCapacity);
    }

    public MinHeap(ArrayList<Integer> list) {
        super(list);
        this.build_heap();
    }

    public void push(Integer value) {
        this.add(value);
        this.heapifyUp(this.size() - 1);
    }

    public Integer pop() {
        Integer value = this.get(0);
        this.set(0, this.get(this.size() - 1));
        this.remove(this.size() - 1);
        this.heapifyDown(0);
        return value;        
    }

    private void build_heap() {
        for (Integer i = this.size() / 2; i >= 0; i--) {
            this.heapifyDown(i);
        }
    }

    private void heapifyUp(Integer index) {
        Integer parentIndex = (index - 1) / 2;
        if (this.get(index) < this.get(parentIndex)) {
            Integer temp = this.get(index);
            this.set(index, this.get(parentIndex));
            this.set(parentIndex, temp);
            this.heapifyUp(parentIndex);
        }
    }

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
