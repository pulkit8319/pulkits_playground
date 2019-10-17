package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.List;

/*Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.*/
public class LeetCodeValidSudoku {
	
	public static void main(String[] args) {
		char board[][] = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		          };
		boolean isValid = isValidSudoku(board);
	}

	private static boolean isValidSudoku(char[][] board) {
		List<Integer> list;
		for (int i = 0; i < 9; i++) {
			list = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int k = Integer.parseInt(String.valueOf(board[i][j]));
					if (k < 1 || k > 9 || list.contains(k)) {
						return false;
					}
					list.add(k);
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			list = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					int k = Integer.parseInt(String.valueOf(board[i][j]));
					if (k < 1 || k > 9 || list.contains(k)) {
						return false;
					}
					list.add(k);
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			list = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != '.') {
					int k = Integer.parseInt(String.valueOf(board[i][j]));
					if (k < 1 || k > 9 || list.contains(k)) {
						return false;
					}
					list.add(k);
				}
			}
		}
		return false;
	}

	

}
