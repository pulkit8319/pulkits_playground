package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
//Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
public class AddToArrayFormOfInteger {

	public static void main(String[] args) {
		int A[] = {9};
		List<Integer> list = addToArrayForm(A, 99);
		System.out.println(list);
	}

	private static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> list = new ArrayList<>();
		int carry = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			int num = A[i] + K % 10 + carry;
			K = K/10;
			carry = num/10;
			list.add(num%10);
		}
		int j = carry+K;
		while(j>0){
			list.add(j%10);
			j = j/10;
		}
		Collections.reverse(list);
		return list;
	}

}
