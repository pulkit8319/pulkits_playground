package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;

//Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
public class SquaresOfASortedArray {

	public static void main(String[] args) {
		int[] arr = { -4, -1, 0, 3, 10 };
		int[] nums = sortedSquaresOptimized(arr);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] *= A[i];
		}
		Arrays.sort(A);
		return A;
	}

	private static int[] sortedSquaresOptimized(int[] A) {
		int mid = 0;
		int n = A.length;
		int ans[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (A[i] >= 0) {
				if (A[i] == 0) {
					mid = i;
				} else {
					mid = i - 1;
				}
				break;
			}
		}
		int r = mid + 1;
		int i = 0;
		int n1 = 0;
		int n2 = 0;
		while (mid >= 0 && r < n) {
			n1 = A[mid];
			n2 = A[r];
			if (n1 * n1 < n2 * n2) {
				ans[i++] = n1 * n1;
				mid--;
			} else {
				ans[i++] = n2 * n2;
				r++;
			}
		}
		while (mid >= 0) {
			n1 = A[mid];
			ans[i++] = n1 * n1;
			mid--;
		}
		while (r < n) {
			n2 = A[r];
			ans[i++] = n2 * n2;
			r++;
		}
		return ans;
	}

}
