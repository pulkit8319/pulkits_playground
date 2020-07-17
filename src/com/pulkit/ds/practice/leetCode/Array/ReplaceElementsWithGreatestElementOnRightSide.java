package com.pulkit.ds.practice.leetCode.Array;

//Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
//After doing so, return the array.
public class ReplaceElementsWithGreatestElementOnRightSide {

	public static void main(String[] args) {
		int[] arr = { 17, 18, 5, 4, 6, 1 };
		int[] num = replaceElements(arr);
		for (int j = 0; j < num.length; j++) {
			System.out.print(num[j]);
		}
	}

	private static int[] replaceElements(int[] arr) {
		int n = arr.length;
		int max = -1;
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = max;
			max = Math.max(max, temp);
		}
		return arr;
	}

}
