package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element. The majority element is the element that appears more than  n/2 times.
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {

	public static void main(String[] args) {
		int nums[] = {2,2,1,1,1,2,2};
		int majEle = majorityElementOptimized(nums);
		System.out.println(majEle);
	}

	
	private static int majorityElementOptimized(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}


	private static int majorityElement(int[] nums) {
		int n = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			if(map.get(nums[i])>n/2){
				return nums[i];
			}
		}
		return 0;
	}

}
