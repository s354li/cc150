// 2. Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
import java.util.*;
public class TicTacToe {
	public static int hasWon(int[][] board) {
		if (board.length < 1 || board[0].length < 1) {
			return 0;
		}
		for(int i = 0; i < board.length; i++) {
			int[] row = board[i];
			if (row[0] > 0) {
				int current = row[0];
				boolean isWin = true;
				for(int item : row) {
					if (item != current) {
						isWin = false;
						break;
					}
				}
				if (isWin) {
					return current;
				}
			}
		}
		for(int j = 0; j < board[0].length; j++) {
			if (board[0][j] > 0) {
				int current = board[0][j];
				boolean isWin = true;
				for(int q = 0; q < board.length; q++) {
					if (board[q][j] != current) {
						isWin = false;
						break;
					}
				}
				if (isWin) {
					return current;
				}
			}
		}
		// check the diagnoal
		boolean diagnoalWin = true;
		int diagnoal = board[0][0];
		if (diagnoal > 0) {
			for (int m = 0; m < board.length; m++) {
				if (board[m][m] != diagnoal) {
					diagnoalWin = false;
					break;
				}
			}
		} else {
			diagnoalWin = false;
		}
		if (diagnoalWin) {
			return diagnoal;
		}
		// check the reverse diagnoal
		boolean reverseDiagnoalWin = true;
		int reverseDiagnoal = board[0][board[0].length - 1];
		if (reverseDiagnoal > 0) {
			for (int n = 0; n < board.length; n++) {
				if (board[n][board[n].length - n - 1] != reverseDiagnoal) {
					reverseDiagnoalWin = false;
					break;
				}
			}
		} else {
			reverseDiagnoalWin = false;
		}
		if (reverseDiagnoalWin) {
			return reverseDiagnoal;
		}
		return 0;
	}
	public static void main(String[] args) {
		int[][] board = new int[][] {
			{ 1, 0, 2, 2 },
			{ 1, 0, 2, 0 },
			{ 2, 2, 1, 2 },
			{ 2, 0, 2, 1 }	
		};
		if (hasWon(board) > 0) {
			System.out.println(hasWon(board));
		} else {
			System.out.println("Nobody won");
		}
		
	}
}