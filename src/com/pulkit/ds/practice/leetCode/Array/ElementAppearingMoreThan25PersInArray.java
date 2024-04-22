package com.pulkit.ds.practice.leetCode.Array;

//Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
//Return that integer.
public class ElementAppearingMoreThan25PersInArray {

	public static void main(String[] args) {
		int arr[] = {1};
		int num = findSpecialIntegerOptimised(arr);
		System.out.println(num);
	}

	private static int findSpecialIntegerOptimised(int[] arr) {
		int n = arr.length;
		int th = n/4;
		for (int i = 0; i < n;i++) {
			if(arr[i]==arr[i+th]){
				return arr[i];
			}
		}
		return -1;
	}

	private static int findSpecialInteger(int[] arr) {
		int count = 1;
		int n = arr.length;
		if(n==1){
			return arr[0];
		}
		int th = n/4;
		for (int i = 0; i < n-1;i++) {
			count = 1;
			while(arr[i]==arr[i+1]){
				count++;
				if(count>th){
					return arr[i];
				}
				i++;
			}
		}
		return -1;
	}

}
