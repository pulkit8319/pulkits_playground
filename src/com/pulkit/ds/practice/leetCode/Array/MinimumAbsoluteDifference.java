package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 
//Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//a, b are from arr
//a < b
//b - a equals to the minimum absolute difference of any two elements in arr
public class MinimumAbsoluteDifference {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 6, 10, 15 };
		List<List<Integer>> list = minimumAbsDifference(nums);
		System.out.println(list);
	}

	private static List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int currDiff = arr[i + 1] - arr[i];
			if (currDiff < diff) {
				list.clear();
				diff = currDiff;
				list.add(Arrays.asList(arr[i], arr[i + 1]));
			} else if (currDiff == diff) {
				list.add(Arrays.asList(arr[i], arr[i + 1]));
			}
		}
		return list;
	}

}
