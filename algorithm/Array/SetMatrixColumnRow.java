// 7. Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
import java.util.*;
public class SetMatrixColumnRow {
	public static int[][] SetZeroInMatrix(int[][] iniMatrix) {
		int[] columns = new int[iniMatrix[0].length];
		int pointer = 0;
		for (int[] row:iniMatrix) {
			boolean hasZeroValue = false;
			for (int i = 1; i <= row.length; i++) {
				if (row[i - 1] == 0 && !Arrays.asList(columns).contains(i)) {
					hasZeroValue = true;
					columns[pointer] = i;
					pointer++;
				}
			}
			if (hasZeroValue) {
				Arrays.fill(row, 0);
			}
		}
		for (int j = 0; j < pointer; j++) {
			for (int m = 0; m < iniMatrix.length; m++) {
				iniMatrix[m][columns[j] - 1] = 0;
			}
		}
		return iniMatrix;
	}
	public static int[][] SetZeroInMatrixSecondWay(int[][] iniMatrix) {
		boolean[] columns = new boolean[iniMatrix.length];
		boolean[] rows = new boolean[iniMatrix[0].length];
		for (int i = 0; i < iniMatrix.length; i++) {
			for (int j = 0; j < iniMatrix[i].length; j++) {
				if (iniMatrix[i][j] == 0) {
					columns[i] = true;
					rows[j] = true;
				}
			}
		}
		for(int m = 0; m < iniMatrix.length; m++) {
			for (int n = 0; n < iniMatrix[m].length; n++) {
				if (columns[m] || rows[n]) {
					iniMatrix[m][n] = 0;
				}
			}
		}
		return iniMatrix;
	}
	public static void main(String[] args) {
		int[][] input = {
	        {1, 2, 3, 4},
	        {5, 6, 0, 8},
	        {9, 10, 11, 12},
	        {13, 14, 15, 16}
    	};
    	int[][] input1 = {
	        {1, 2, 3, 4},
	        {5, 6, 0, 8},
	        {9, 10, 11, 12},
	        {13, 14, 15, 16}
    	};
    	int[][] output = SetZeroInMatrix(input);
    	for(int i = 0; i < output.length; i++) {
    		System.out.println(Arrays.toString(output[i]));
    	}
    	int[][] output1 = SetZeroInMatrixSecondWay(input1);
    	for(int i = 0; i < output1.length; i++) {
    		System.out.println(Arrays.toString(output1[i]));
    	}
	}
}
