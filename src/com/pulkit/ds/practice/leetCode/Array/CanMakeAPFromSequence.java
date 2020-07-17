package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;

//Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
//Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.
public class CanMakeAPFromSequence {

	public static void main(String[] args) {
		int arr[] = {1,2,4};
		boolean can = canMakeArithmeticProgression(arr);
		System.out.println(can);
	}

	private static boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		for (int i = 1; i < arr.length-1; i++) {
			if((arr[i]-arr[i-1])!=(arr[i+1]-arr[i])){
				return false;
			}
		}
		return true;
	}

}
