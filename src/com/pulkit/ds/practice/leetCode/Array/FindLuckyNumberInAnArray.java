package com.pulkit.ds.practice.leetCode.Array;

//Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
//Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
public class FindLuckyNumberInAnArray {

	public static void main(String[] args) {
		int arr[] = {2,2,2,3,3};
		int num = findLucky(arr);
		System.out.println(num);
	}

	private static int findLucky(int[] arr) {
		int[] num = new int[501];
		for (int i = 0; i < arr.length; i++) {
			num[arr[i]]++;
		}
		for (int i = num.length-1; i>0; i--) {
			if(i==num[i]){
				return i;
			}
		}
		return -1;
	}

}
