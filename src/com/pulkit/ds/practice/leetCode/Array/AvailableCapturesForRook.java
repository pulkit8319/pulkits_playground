package com.pulkit.ds.practice.leetCode.Array;

//On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
//The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
//Return the number of pawns the rook can capture in one move.
public class AvailableCapturesForRook {

	public static void main(String[] args) {
		char board[][] = { { '.', '.', '.', '.', '.', '.', '.', '.' }, 
						   { '.', '.', '.', 'p', '.', '.', '.', '.' },
						   { '.', '.', '.', 'R', '.', '.', '.', 'p' }, 
						   { '.', '.', '.', '.', '.', '.', '.', '.' },
						   { '.', '.', '.', '.', '.', '.', '.', '.' }, 
						   { '.', '.', '.', 'p', '.', '.', '.', '.' },
						   { '.', '.', '.', '.', '.', '.', '.', '.' },
						   { '.', '.', '.', '.', '.', '.', '.', '.' } };
		int n = numRookCaptures(board);
		System.out.println(n);
	}

	private static int numRookCaptures(char[][] board) {
		int i = -1;
		int j = -1;
		int m = board.length;
		int n = board[0].length;
		int count = 0;
		boolean stop = false;
		for (i = 0; i < m && !stop; i++) {
			for (j = 0; j < n && !stop; j++) {
				if (board[i][j] == 'R') {
					stop = true;
				}
			}
		}
		i--;
		j--;
		//System.out.println(i+" "+j);
		int k;
		for (k = i; k < m; k++) {
			//System.out.println(i+" "+k+"  "+j);
			if (board[k][j] == 'B') {
				break;
			} else if (board[k][j] == 'p') {
			//	System.out.println("1");
				count++;
				break;
			}
			//System.out.println(i+" "+k+"  "+j);
		}
		for (k = i; k >= 0; k--) {
			//System.out.println(i+" "+k+"  "+j);
			if (board[k][j] == 'B') {
				break;
			} else if (board[k][j] == 'p') {
			//	System.out.println("2");
				count++;
				break;
			}
		}
		for (k = j; k < n; k++) {
			if (board[i][k] == 'B') {
				break;
			} else if (board[i][k] == 'p') {
				//System.out.println("3");
				count++;
				break;
			}
		}
		for (k = j; k >= 0; k--) {
			if (board[i][k] == 'B') {
				break;
			} else if (board[i][k] == 'p') {
				//System.out.println("4");
				count++;
				break;
			}
		}
		return count;
	}

}
