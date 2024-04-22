package com.pulkit.ds.practice;

public class MaximalDifferenceArray {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 7 };
		int maxDiff = maximalDiff(arr);
		if (maxDiff < 0) {
			System.out.println("No maximal diff");
		} else {
			System.out.println(maxDiff);
		}
	}

	private static int maximalDiff(int[] arr) {
		int maxDiff = arr[1] - arr[0];// 2
		int minElement = arr[0];// 1
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - minElement > maxDiff) {
				maxDiff = arr[i + 1] - minElement;
			}
			if (minElement > arr[i + 1]) {
				minElement = arr[i + 1];
			}
		}
		return maxDiff;
	}
}
