// 6. Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
import java.util.*;
public class RotateImage {
	public static int[][] RatateImageQuarterCircle(int[][] iniMatrix, boolean clockWise) {
		int firstDimentional = iniMatrix.length;
		int secondDimentional = iniMatrix[0].length;
		int[][] output = new int[secondDimentional][firstDimentional];
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[i].length; j++) {
				if (clockWise) {
					output[i][j] = iniMatrix[firstDimentional - 1 - j][i];
				} else {
					output[i][j] = iniMatrix[j][firstDimentional - 1 - i];
				}
			}
		}
		return output;
	}
	// only applied to N*N: the column and row numbers are the same
	public static int[][] RatateImageQuarterCircleNoSpace(int[][] iniMatrix, boolean clockWise) {
		for (int[] row:iniMatrix) {
			for (int i = 0; i < row.length / 2; i++) {
				int temp = row[i];
				row[i] = row[row.length - 1 - i];
				row[row.length - 1 - i] = temp;
			}
		}
		if (clockWise) {
			for (int j = 0; j < iniMatrix.length - 1; j++) {
				for (int m = 0; m < iniMatrix.length - 1 - j; m++) {
					int temp = iniMatrix[j][m];
					iniMatrix[j][m] = iniMatrix[iniMatrix.length - 1 - m][iniMatrix.length - 1 - j];
					iniMatrix[iniMatrix.length - 1 - m][iniMatrix.length - 1 - j] = temp;
				}
			}
		} else {
			for (int j = 1; j < iniMatrix.length; j++) {
				for (int m = 0; m < j; m++) {
					int temp = iniMatrix[j][m];
					iniMatrix[j][m] = iniMatrix[m][j];
					iniMatrix[m][j] = temp;
				}
			}
		}
		return iniMatrix;
	}
	public static void main(String[] args) {
		int[][] input = {
	        {1, 2, 3, 4},
	        {5, 6, 7, 8},
	        {9, 10, 11, 12},
	        {13, 14, 15, 16}
    	};
    	int[][] input1 = {
	        {1, 2, 3, 4},
	        {5, 6, 7, 8},
	        {9, 10, 11, 12},
	        {13, 14, 15, 16}
    	};
    	int[][] output1 = RatateImageQuarterCircle(input, true);
    	for(int i = 0; i < output1.length; i++) {
    		System.out.println(Arrays.toString(output1[i]));
    	}
    	int[][] output2 = RatateImageQuarterCircle(input, false);
    	for(int i = 0; i < output2.length; i++) {
    		System.out.println(Arrays.toString(output2[i]));
    	}
    	int[][] output3 = RatateImageQuarterCircleNoSpace(input, true);
    	for(int i = 0; i < output3.length; i++) {
    		System.out.println(Arrays.toString(output3[i]));
    	}
    	int[][] output4 = RatateImageQuarterCircleNoSpace(input1, false);
    	for(int i = 0; i < output4.length; i++) {
    		System.out.println(Arrays.toString(output4[i]));
    	}
	}
}
