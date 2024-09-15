package com.example.demo.sorting.bubblesort.model;

public class MergeSortDTO {
    private int[] array;
    private int[] leftIndices;
    private int[] rightIndices;
    private int[] mergedIndices;

    // Constructor
    public MergeSortDTO(int[] array, int[] leftIndices, int[] rightIndices, int[] mergedIndices) {
        this.array = array;
        this.leftIndices = leftIndices;
        this.rightIndices = rightIndices;
        this.mergedIndices = mergedIndices;
    }

    // Getters and Setters
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getLeftIndices() {
        return leftIndices;
    }

    public void setLeftIndices(int[] leftIndices) {
        this.leftIndices = leftIndices;
    }

    public int[] getRightIndices() {
        return rightIndices;
    }

    public void setRightIndices(int[] rightIndices) {
        this.rightIndices = rightIndices;
    }

    public int[] getMergedIndices() {
        return mergedIndices;
    }

    public void setMergedIndices(int[] mergedIndices) {
        this.mergedIndices = mergedIndices;
    }
}
