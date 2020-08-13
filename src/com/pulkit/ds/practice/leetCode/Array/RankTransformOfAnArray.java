package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//Given an array of integers arr, replace each element with its rank.
//The rank represents how large the element is. The rank has the following rules:
//Rank is an integer starting from 1.
//The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//Rank should be as small as possible.
public class RankTransformOfAnArray {

	public static void main(String[] args) {
		int[] arr = { 37, 12, 28, 9, 100, 56, 80, 5, 12 };
		int[] num = arrayRankTransformTreeSet(arr);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}

	private static int[] arrayRankTransformTreeSet(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		Map<Integer,Integer> map = new HashMap<>();
		int j = 1;
		for(Integer i : set){
			map.put(i, j++);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = map.get(arr[i]);
		}
		return arr;
	}

	//using array
	private static int[] arrayRankTransform(int[] arr) {
		int[] arr1 = arr.clone();
		Arrays.sort(arr1);
		Map<Integer, Integer> map = new HashMap<>();
		int k = 1;
		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				map.put(arr1[i], k++);
			}
		}
		System.out.println(map);
		for (int j = 0; j < arr.length; j++) {
			arr1[j] = map.get(arr[j]);
		}
		return arr1;
	}

}
