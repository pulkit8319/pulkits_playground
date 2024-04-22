package com.pulkit.ds.practice.leetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//For example, given the following triangle
public class Triangle {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(Arrays.asList(2));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(3, 4));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(6, 5, 7));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));

		List<List<Integer>> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		int sum = minimumTotalDP1DArray(list);
		System.out.println(sum);
	}

	private static int minimumTotalDP1DArray(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[] dp = new int[size];
		List<Integer> lst = triangle.get(size-1);
		for (int i = 0; i < size; i++) {
			dp[i] = lst.get(i);
		}
		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0];
	}

	private static int minimumTotalDP2DArray(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[][] dp = new int[size][size];
		for (int i = 0; i < size; i++) {
			List<Integer> l = triangle.get(i);
			for (int j = 0; j < l.size(); j++) {
				dp[i][j] = l.get(j);
			}
		}
		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
			}
		}
		return dp[0][0];
	}

}
