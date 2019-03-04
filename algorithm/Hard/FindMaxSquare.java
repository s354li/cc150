// 11. Imagine you have a square matrix, where each cell is filled with either black or white.
// Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
import java.util.*;
public class FindMaxSquare {
	public static boolean isValidSquare(int[][] square, int row, int col, int size) {
		for(int i = 0; i < size; i++) {
			if (square[row][col + i] != 1 || square[row + size - 1][col + i] != 1 || square[row + i][col] != 1 || square[row + i][col + size - 1] != 1) {
				return false;
			}
		}
		return true;
	}
	public static int findMaxSize(int[][] square) {
		int maxSize = 2;
		for(int i = 0; i < square.length; i++) {
			for(int j = 0; j < square[i].length; j++) {
				if (square[i][j] == 1) {
					// find the smallest one
					int boundary = i;
					if (j > i) {
						boundary = j;
					}
					// set as the left top corner
					for(int m = 2; m <= square.length - boundary; m++) {
						if (isValidSquare(square, i, j, m) && m > maxSize) {
							maxSize = m;
						}
					}
				}
			}
 		}
 		return maxSize;
	}
	public static void main(String[] args) {
		int[][] test_case = {
			{ 0, 0, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 0 },
			{ 0, 0, 0, 1, 1, 1, 0, 0 },
		};
		System.out.println(findMaxSize(test_case));
	}
}