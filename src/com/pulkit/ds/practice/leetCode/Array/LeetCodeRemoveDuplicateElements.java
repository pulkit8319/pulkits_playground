package com.pulkit.ds.practice.leetCode.Array;

//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
public class LeetCodeRemoveDuplicateElements {

	public static void main(String[] args) {
		int arr[] = {0,1,1,1,2,2,3,3,4 };
		int len = removeDuplicates(arr);
		System.out.println(len);
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+", ");
		}
	}

	private static int removeDuplicates(int[] arr) {
		int len = arr.length;
		if (len == 0 || len == 1)
			return len;
		int j = 0;
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j] = arr[i];
				j++;
			}
		}
		arr[j++] = arr[len-1];
		return j;
	}
}
