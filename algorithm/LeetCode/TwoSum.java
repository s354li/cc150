// 1. Two Sum: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
import java.util.*;
public class TwoSum{
	public static int[] getIndices(int[] iniArray, int target) {
		if (iniArray.length < 1) {
			return null;
		}
		for(int i = 0; i < iniArray.length; i++) {
			for(int j = i; j < iniArray.length; j++) {
				if(iniArray[i] + iniArray[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
	public static int[] getIndicesSecond(int[] iniArray, int target) {
		if (iniArray.length < 1) {
			return null;
		}
		Hashtable<Integer, Integer> bookcode = new Hashtable<Integer, Integer>();
		for(int i = 0; i < iniArray.length; i++) {
			if (bookcode.containsKey(target - iniArray[i])) {
				return new int[] { bookcode.get(target - iniArray[i]), i };
			}
			if (!bookcode.containsKey(iniArray[i])) {
				bookcode.put(iniArray[i], i);
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[] iniArray = new int[] { 2, 7, 11, 15 };
		int[] result = getIndices(iniArray, 9);
		for(int item:result) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("-------------------------");
		int[] result2 = getIndicesSecond(iniArray, 9);
		for(int item:result2) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}