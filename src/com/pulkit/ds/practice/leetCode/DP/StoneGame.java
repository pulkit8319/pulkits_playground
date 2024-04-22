package com.pulkit.ds.practice.leetCode.DP;

import java.util.Arrays;

//Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
//The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
//Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
//Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
public class StoneGame {
	public static void main(String[] args) {
		int[] piles = { 3, 7, 2, 3 };
		boolean b = stoneGame(piles);
		System.out.println(b);
	}

	private static boolean stoneGame(int[] nums) {
		int size = nums.length;
		if (size == 0) {
			return true;
		}
		int[][] dp = new int[size][size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		return game(nums, 0, size - 1, true, 0, 0, dp) == 1;
	}

	private static int game(int[] piles, int start, int end, boolean aTurn, int a, int b, int[][] dp) {
		if (start == end) {
			if (b + piles[start] < a) {
				return 1;
			} else {
				return 0;
			}
		}
		if (dp[start][end] == Integer.MIN_VALUE) {
			if (aTurn) {
				if (game(piles, start + 1, end, false, a + piles[start], b, dp) == 1
						|| game(piles, start, end - 1, false, a + piles[end], b, dp) == 1) {
					dp[start][end] = 1;
				} else {
					dp[start][end] = 0;
				}
			} else {
				if (game(piles, start + 1, end, true, a, b + piles[start], dp) == 1
						|| game(piles, start, end - 1, true, a, b + piles[end], dp) == 1) {
					dp[start][end] = 1;
				} else {
					dp[start][end] = 0;
				}
			}
		}
		return dp[start][end];
	}
}
