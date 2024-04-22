package com.pulkit.ds.practice.leetCode.Array;

import java.util.HashSet;
import java.util.Set;

//Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
//More formally check if there exists two indices i and j such that :
//i != j
//0 <= i, j < arr.length
//arr[i] == 2 * arr[j]
public class CheckIfNAndItsDoubleExist {

	public static void main(String[] args) {
		int arr[] = {4,-7,11,4,18};
		boolean b = checkIfExist(arr);
		System.out.println(b);
	}

	private static boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				return true;
			}
			if (arr[i] % 2 == 0) {
				set.add(arr[i] / 2);
			}
			set.add(2 * arr[i]);
		}
		return false;
	}

}
