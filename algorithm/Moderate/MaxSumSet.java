// 7. You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum. Return the sum.
import java.util.*;
public class MaxSumSet {
	public static ArrayList<Integer> getMaxSumSet(int[] iniArray) {
		int sumResult = 0;
		int sum = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		for(int i = 0; i < iniArray.length; i++) {
			sum += iniArray[i];
			currentList.add(iniArray[i]);
			if (sum < 0) {
				currentList.clear();
				sum = 0;
			} else if (sumResult < sum) {
				result = (ArrayList<Integer>) currentList.clone();
				sumResult = sum;
			}
		}
		System.out.println("sum is " + sumResult);
		return result;
	}
	public static void main(String[] args) {
		int[] iniSet = new int[] { 2, -8, 3, -2, 4, -10 };
		ArrayList<Integer> result = getMaxSumSet(iniSet);
		int sum = 0;
		for(Integer item : result) {
			sum += item;
			System.out.print(item + " ");
		}
		System.out.println();
	}
}