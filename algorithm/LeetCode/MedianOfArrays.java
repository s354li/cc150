// 4. There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
import java.util.*;
public class MedianOfArrays {
	public static double FindMedian (int[] sortedArr1, int[] sortedArr2) {
		int totalNum = sortedArr1.length + sortedArr2.length;
		boolean oneNumMedian = true;
		int medianStartPos;
		if (totalNum % 2 == 0) {
			oneNumMedian = false;
			medianStartPos = totalNum/2 - 1;
		} else {
			medianStartPos = totalNum/2;
		}
		int positionArr1 = 0;
		int positionArr2 = 0;
		while (positionArr1 + positionArr2 < medianStartPos) {
			if (sortedArr1[positionArr1] < sortedArr2[positionArr2]) {
				positionArr1++;
			} else {
				positionArr2++;
			}
		}
		if (oneNumMedian) {
			return Math.min(sortedArr1[positionArr1], sortedArr2[positionArr2]);
		}
		int firstMedian = Math.min(sortedArr1[positionArr1], sortedArr2[positionArr2]);
		if (sortedArr1[positionArr1] < sortedArr2[positionArr2]) {
			positionArr1++;
		} else {
			positionArr2++;
		}
		int secondMedian = Math.min(sortedArr1[positionArr1], sortedArr2[positionArr2]);
		return (firstMedian + secondMedian) / 2.0;
	}

	// use a recrution way to solve the problem to improve the performance
	public static int findKthNum (int[] sortedArr1, int startArr1, int[] sortedArr2, int startArr2, int k) {
		if (startArr1 > sortedArr1.length - 1) {
			return sortedArr2[startArr2 + k - 1];
		}
		if (startArr2 > sortedArr2.length - 1) {
			return sortedArr1[startArr1 + k - 1];
		}
		if (k == 1) {
			return Math.min(sortedArr1[startArr1], sortedArr2[startArr2]);
		}
		int indexArr1 = startArr1 + k / 2 - 1;
		int indexArr2 = startArr2 + k / 2 - 1;
		if (indexArr1 > sortedArr1.length - 1) {
			return findKthNum(sortedArr1, startArr1, sortedArr2, startArr2 + k / 2, k - k / 2);
		} else if (indexArr2 > sortedArr2.length - 1) {
			return findKthNum(sortedArr1, startArr1 + k / 2, sortedArr2, startArr2, k - k / 2);
		} else {
			if (sortedArr1[indexArr1] < sortedArr2[indexArr2]) {
				return findKthNum(sortedArr1, startArr1 + k / 2, sortedArr2, startArr2, k - k / 2);
			} else {
				return findKthNum(sortedArr1, startArr1, sortedArr2, startArr2 + k / 2, k - k / 2);
			}
		}
	}

	public static double CalMedian (int[] sortedArr1, int[] sortedArr2) {
		int totalNum = sortedArr1.length + sortedArr2.length;
		if (totalNum % 2 == 0) {
			return (findKthNum(sortedArr1, 0, sortedArr2, 0, totalNum / 2) + findKthNum(sortedArr1, 0, sortedArr2, 0, totalNum / 2 + 1)) / 2.0;
		}
		return findKthNum(sortedArr1, 0, sortedArr2, 0, totalNum / 2  + 1);
	}
	public static void main (String[] args) {
		int[] arr1 = new int[] {1,4,7,10,33,45};
		int[] arr2 = new int[] {2,3,7,22,67,90, 199};
		double result = CalMedian(arr1, arr2);
		System.out.println(result);
	}
}