package com.example.demo.sorting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sorting.bubblesort.model.BubbleSort;
import com.example.demo.sorting.bubblesort.model.MergeSortDTO;
import com.example.demo.sorting.bubblesort.model.SelectionSortStep;
import com.example.demo.sorting.service.SortingService;

@RestController
public class SortingController {
	
	private SortingService sortingService;

	public SortingController(SortingService sortingService) {
		super();
		this.sortingService = sortingService;
	}
	
	@PostMapping("/bubbleSort")
	public List<BubbleSort> bubbleSort(@RequestBody int[] array) {
	    return sortingService.bubbleSort(array);
	}

	
	@PostMapping("/mergeSort")
    public List<MergeSortDTO> mergeSort(@RequestBody int[] array) {
        return sortingService.mergeSort(array);
    }
	
	@PostMapping("/selection")
    public List<SelectionSortStep> selectionSort(@RequestBody List<Integer> array) {
        return sortingService.selectionSort(array);
    }
}
