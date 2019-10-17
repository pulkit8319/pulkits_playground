package com.pulkit.ds.practice;

public class DollsInsideDoll {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		int minDolls = getMinDolls(arr);
		System.out.println(minDolls);

	}

	private static int getMinDolls(int[] arr) {
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(Math.abs(arr[i])<arr[j]) {
					arr[i] = min;
					arr[j] = -arr[j];
					break;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=min) {
				count++;
			}
		}
		return count;
	}

}
