// 11. Design an algorithm to find all pairs of integers within an array which sum to a specified value.
import java.util.*;
public class FindPair {
	public static ArrayList<Integer[]> findPair(int[] iniArray, int sumValue) {
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		HashSet<Integer> codebook = new HashSet<Integer>();
		for(int item : iniArray) {
			if (!codebook.contains(item)) {
				codebook.add(item);
			}
		}
		for(int item : iniArray) {
			codebook.remove(item);
			if (codebook.contains(sumValue - item)) {
				codebook.remove(sumValue - item);
				Integer[] pair = new Integer[2];
				pair[0] = new Integer(item);
				pair[1] = new Integer(sumValue - item);
				result.add(pair);
			}
		}
		return result;
	}
	public static ArrayList<Integer[]> findPairSecond(int[] iniArray, int sumValue) {
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		HashSet<Integer> codebook = new HashSet<Integer>();
		for(int item : iniArray) {
			if (codebook.contains(sumValue - item)) {
				Integer[] pair = new Integer[2];
				pair[0] = new Integer(item);
				pair[1] = new Integer(sumValue - item);
				result.add(pair);
			} else {
				codebook.add(item);
			}
		}
		return result;
	}
	public static ArrayList<Integer[]> findPairThird(int[] iniArray, int sumValue) {
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		HashSet<Integer> codebook = new HashSet<Integer>();
		Arrays.sort(iniArray);
		int left = 0;
		int right = iniArray.length - 1;
		while (left < right) {
			if (iniArray[left] + iniArray[right] > sumValue) {
				right--;
			} else if (iniArray[left] + iniArray[right] < sumValue) {
				left++;
			} else {
				Integer[] pair = new Integer[2];
				pair[0] = new Integer(iniArray[left]);
				pair[1] = new Integer(iniArray[right]);
				result.add(pair);
				right--;
				left++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] iniSet = new int[] { 1, 4, 8, 6, 3, 9, 10, -4, -6, 11, 15, 2, 7, 19, 12, 0 };
		ArrayList<Integer[]> result = findPairThird(iniSet, 6);
		for(Integer[] item : result) {
			for(Integer element : item) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
}