package com.pulkit.ds.practice.leetCode.Array;

//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'C', 'A', 'A' }, 
						   { 'A', 'A', 'A' }, 
						   { 'B', 'C', 'D', } };
		boolean exist = exist(board, "AAB");
		System.out.println(exist);
	}

	private static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		int k = 0;
		for (int i = 0; i < m && k < word.length(); i++) {
			for (int j = 0; j < n && k < word.length(); j++) {
				if (word.charAt(k) == board[i][j]) {
					if (findWord(k, board, i, j, m, n, word)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean findWord(int k, char[][] board, int i, int j, int m, int n, String word) {
		if (k >= word.length()) {
			return true;
		}
		if (i >= m || j >= n || i < 0 || j < 0 || board[i][j] != word.charAt(k)) {
			return false;
		}
		board[i][j]^=256;
		boolean exist =  findWord(k + 1, board, i + 1, j, m, n, word) || findWord(k + 1, board, i - 1, j, m, n, word)
				|| findWord(k + 1, board, i, j + 1, m, n, word) || findWord(k + 1, board, i, j - 1, m, n, word);
		board[i][j]^=256;
		return exist;
		
	}

}
