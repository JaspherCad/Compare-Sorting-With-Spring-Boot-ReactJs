package com.example.demo.sorting.bubblesort.model;
public class BubbleSort {
    private int[] array;
    private int[] comparing;

    public BubbleSort(int[] array, int[] comparing) {
        this.array = array;
        this.comparing = comparing;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getComparing() {
        return comparing;
    }

    public void setComparing(int[] comparing) {
        this.comparing = comparing;
    }
}
