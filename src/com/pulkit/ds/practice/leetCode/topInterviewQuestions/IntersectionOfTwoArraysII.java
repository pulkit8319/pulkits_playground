package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] num = intersectUsingHashMap(nums1,nums2);
	}

	private static int[] intersectUsingHashMap(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();	
		for(int i=0;i<nums1.length;i++){
			map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
		}
		for(int i=0;i<nums2.length;i++){
			if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}
		int[] num = new int[list.size()];
		for(int k = 0;k<list.size();k++){
			num[k] = list.get(k);
		}
		return num;
	}

	private static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<>();
		int n1 = nums1.length;
		int n2 = nums2.length;
		int i=0,j=0;
		while(i<n1 && j<n2){
			if(nums1[i]==nums2[j]){
				list.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i]<nums2[j]){
				i++;
			}else{
				j++;
			}
		}
		int[] num = new int[list.size()];
		for(int k = 0;k<list.size();k++){
			num[k] = list.get(k);
		}
		return num;
	}

}
