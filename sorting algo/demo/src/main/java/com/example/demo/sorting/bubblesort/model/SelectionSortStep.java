package com.example.demo.sorting.bubblesort.model;


import java.util.List;

public class SelectionSortStep {
    private List<Integer> array;
    private List<Integer> comparing;
    private int selected;

    public SelectionSortStep(List<Integer> array, List<Integer> comparing, int selected) {
        this.array = array;
        this.comparing = comparing;
        this.selected = selected;
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getComparing() {
        return comparing;
    }

    public void setComparing(List<Integer> comparing) {
        this.comparing = comparing;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
