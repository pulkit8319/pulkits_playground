package com.pulkit.ds.practice.leetCode.DP;

import java.util.Arrays;

//Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
//Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
public class PredictWinner {
	public static void main(String[] args) {
		int[] piles = { 1,5,2 };
		boolean b = PredictTheWinner(piles);
		System.out.println(b);
	}

	private static boolean PredictTheWinner(int[] nums) {
		int size = nums.length;
		if (size == 0) {
			return false;
		}
		if (size == 1) {
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
			if (aTurn) {
				if (b <= a + piles[start]) {
					return 1;
				} else {
					return 0;
				}
			} else {
				if (b + piles[start] <= a) {
					return 1;
				} else {
					return 0;
				}
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
