package com.pulkit.ds.practice.leetCode.Array;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
public class KDiffPairsInAnArray {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5 };
		int num = findPairs(nums, -1);
		System.out.println(num);
	}

	private static int findPairs(int[] nums, int k) {
		if (k < 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				if (entry.getValue() >= 2) {
					count++;
				}
			} else if (map.containsKey(entry.getKey() + k)) {
				count++;
			}
		}
		return count;
	}

}
