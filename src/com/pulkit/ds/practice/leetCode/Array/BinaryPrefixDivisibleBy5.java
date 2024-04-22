package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.List;

//Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
//Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
public class BinaryPrefixDivisibleBy5 {

	public static void main(String[] args) {
		int A[] = { 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0,
				0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1,
				0 };
		List<Boolean> can = prefixesDivBy5(A);
		System.out.println(can);
	}

	private static List<Boolean> prefixesDivBy5(int[] A) {
		int num = 0;
		List<Boolean> list = new ArrayList<>();
		for (int j = 0; j < A.length; j++) {
			num = ((num << 1) ^ A[j])%5;
			System.out.println(num);
			list.add(num==0?true:false);
		}
		return list;
	}

}
