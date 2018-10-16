package com.xiaowen.javatest;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] input = {0,1,1,3,4,5,3,0,2,4,2};
		int[] output = new int[input.length];
		int k = 5; // k is the largest number in the input array
		System.out.println("before sorting:");
		System.out.println(Arrays.toString(input)); 
		output = countingSort(input, output, k);
		System.out.println("after sorting:");
		System.out.println(Arrays.toString(output));
	}
	
	public static int[] countingSort(int[] input, int[] output, int k) {
		// create buckets 
		int counter[] = new int[k + 1]; 
		// fill buckets 
		for (int i : input) { counter[i]++; } 
		// sort array 
		int ndx = 0; 
		for (int i = 0; i < counter.length; i++) {
			while (counter[i] > 0) { 
				output[ndx++] = i;
				counter[i]--; 
			}
		}
		return output;
	}
}
