package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
public class LeetCodeSumIndexes {
	
	public static void main(String[] args) {
		int arr[] = {3,2,4};
		int target = 5;
		int newNum[] = twoSumUsingMap(arr, target);	
		for (int i = 0; i < newNum.length; i++) {
			System.out.println(newNum[i]);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		 int[] dup = new int[nums.length];
		 for (int i = 0; i < nums.length; i++) {
			 dup[i] = nums[i];
		}
		 Arrays.sort(dup);//2,3,4
		 int arr[] =new int[2];
		 int l = 0;
		 int r = dup.length-1;
		while (l < r) {
			if (dup[l] + dup[r] < target) {
				l++;
			} else if (dup[l] + dup[r] > target) {
				r--;
			} else {
				l = dup[l];//3
				r = dup[r];//3
				break;
			}
		}
		for(int i=0;i<nums.length;i++) {
			if(l==nums[i]) {
				arr[0] = i;
				break;
			}
		}
		for(int i=0;i<nums.length;i++) {//3,2,4
			if(r==nums[i] && i!=arr[0]) {
				arr[1] = i;
				break;
			}
		}
	        return arr;
	    }
										//3,2,4			//6
	public static int[] twoSumUsingMap(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();//{3,0},{4,1}
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return new int[] {map.get(nums[i]),i};
			}else {
				map.put(target-nums[i], i);
			}
		}
		return new int[2];
	}

}
