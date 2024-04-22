package com.pulkit.ds.practice.leetCode.DP;

//Alice and Bob take turns playing a game, with Alice starting first.
//Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
//Choosing any x with 0 < x < N and N % x == 0.
//Replacing the number N on the chalkboard with N - x.
//Also, if a player cannot make a move, they lose the game.
//Return True if and only if Alice wins the game, assuming both players play optimally.
public class DivisorGame {

	public static void main(String[] args) {
		boolean aliceWins = divisorGameRecursiveSimple(9);
		System.out.println(aliceWins);
	}

	private static boolean divisorGameRecursiveSimple(int i) {
		return i%2==0;
	}

	private static boolean divisorGameRecursive(int N) {
		return divisorGame(N, true);
	}

	private static boolean divisorGame(int n, boolean alicesTurn) {
		if (n == 1) {
			return alicesTurn ? false : true;
		}
		int i = getDivisor(n);
		return divisorGame(n - i, !alicesTurn);
	}

	private static int getDivisor(int n) {
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				return i;
			}
		}
		return 1;
	}

}
