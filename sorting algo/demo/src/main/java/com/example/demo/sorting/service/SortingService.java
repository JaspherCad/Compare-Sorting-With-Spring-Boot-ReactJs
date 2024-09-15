package com.example.demo.sorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.demo.sorting.bubblesort.model.BubbleSort;
import com.example.demo.sorting.bubblesort.model.MergeSortDTO;
import com.example.demo.sorting.bubblesort.model.SelectionSortStep;

@Service
public class SortingService {

	public List<BubbleSort> bubbleSort(int[] array){
		List<BubbleSort> steps = new ArrayList<BubbleSort>();//we put the real time process of sorting here
		for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
            	
            	int[] comparing = new int[] {j, j+1}; //pointerIndex and postPointerIndex
            	
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                steps.add(new BubbleSort(array.clone(), comparing));
            }
        }
        return steps;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	// Merge Sort with visualized merging
	public List<MergeSortDTO> mergeSort(int[] array) {
        List<MergeSortDTO> steps = new ArrayList<>();
        mergeSort(array, 0, array.length - 1, steps);
        return steps;
    }
	
	
	//much complex and wordy forda "FRONTEND SAKE". i need three colors
	//left -- merged -- right index 

    private void mergeSort(int[] array, int left, int right, List<MergeSortDTO> steps) {
        if (left < right) { //base case
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, steps); //for left part
            mergeSort(array, mid + 1, right, steps); //for right part
            merge(array, left, mid, right, steps);
        }
    }

    private void merge(int[] array, int left, int mid, int right, List<MergeSortDTO> steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);
        
        int i = 0, j = 0;
        int k = left;
        List<Integer> leftIndices = new ArrayList<>();
        List<Integer> rightIndices = new ArrayList<>();
        List<Integer> mergedIndices = new ArrayList<>();
        
        while (i < n1 && j < n2) {
            leftIndices.add(left + i);
            rightIndices.add(mid + 1 + j);
            
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            
            mergedIndices.add(k);
            k++;
            
            // Add step to the list
            steps.add(new MergeSortDTO(
                array.clone(),
                leftIndices.stream().mapToInt(Integer::intValue).toArray(),
                rightIndices.stream().mapToInt(Integer::intValue).toArray(),
                mergedIndices.stream().mapToInt(Integer::intValue).toArray()
            ));
            
            // clear all for the next iteration and for FRONTEND color
            leftIndices.clear();
            rightIndices.clear();
            mergedIndices.clear();
        }
        
        //if array1 is used all
        while (i < n1) {
            array[k] = L[i];
            leftIndices.add(left + i);
            mergedIndices.add(k);
            i++;
            k++;
            steps.add(new MergeSortDTO(
                array.clone(),
                leftIndices.stream().mapToInt(Integer::intValue).toArray(),
                new int[]{}, // No right indices
                mergedIndices.stream().mapToInt(Integer::intValue).toArray()
            ));
            leftIndices.clear();
            mergedIndices.clear();
        }
        
        //if array2 is used all
        while (j < n2) {
            array[k] = R[j];
            rightIndices.add(mid + 1 + j);
            mergedIndices.add(k);
            j++;
            k++;
            steps.add(new MergeSortDTO(
                array.clone(),
                new int[]{}, 
                rightIndices.stream().mapToInt(Integer::intValue).toArray(),
                mergedIndices.stream().mapToInt(Integer::intValue).toArray()
            ));
            rightIndices.clear();
            mergedIndices.clear();
        }
    }
    
    
    
    
    
    
    
    
    
    
    //selection sort part
    public List<SelectionSortStep> selectionSort(List<Integer> array) {
        List<SelectionSortStep> steps = new ArrayList<>();
        List<Integer> currentArray = new ArrayList<>(array);

        for (int i = 0; i < currentArray.size() - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < currentArray.size(); j++) {
                steps.add(new SelectionSortStep(new ArrayList<>(currentArray), List.of(minIndex, j), -1));
                if (currentArray.get(j) < currentArray.get(minIndex)) {
                    minIndex = j;
                }
            }

            int temp = currentArray.get(minIndex);
            currentArray.set(minIndex, currentArray.get(i));
            currentArray.set(i, temp);

            steps.add(new SelectionSortStep(new ArrayList<>(currentArray), List.of(i, minIndex), i)); //i min index
        }

        return steps;
    }
}