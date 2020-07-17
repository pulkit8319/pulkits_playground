package com.pulkit.ds.practice.leetCode.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//Given an array of integers nums.
//A pair (i,j) is called good if nums[i] == nums[j] and i < j.
//Return the number of good pairs.
public class NumbeOfGoodPairs {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 1, 3 };
		int num = numIdenticalPairs(nums);
		System.out.println(num);
	}

	private static int numIdenticalPairs(int[] nums) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			count+=map.get(nums[i])-1;
		}
		return count;
	}

}
