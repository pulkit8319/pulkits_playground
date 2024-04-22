package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * */
public class LeetCodeContainsDuplicate {

	public static void main(String[] args) {
		int nums[] = {1,2,1};
		boolean isDupli = containsDuplicateUsingSet(nums);
		System.out.println(isDupli);
	}

	private static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]==nums[i+1]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean containsDuplicateUsingSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

}
