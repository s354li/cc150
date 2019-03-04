// 26. Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
import java.util.*;
public class RemDupFromSortArr {
	public static int findCloseIndex(int[] nums, int target, int startIndex) {
		for(int i = startIndex; i < nums.length; i++) {
			if (nums[i] != target) {
				return i;
			}
		}
		return -1;
	}
	public static int removeDuplicates(int[] nums) {
		if(nums.length < 2) {
			return nums.length;
		}
		for(int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[0]) {
				break;
			}
			int current = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == current) {
					int currentCloseIndex = findCloseIndex(nums, current, j + 1);
					if (currentCloseIndex != -1) {
						nums[j] = nums[currentCloseIndex];
						nums[currentCloseIndex] = current;
					}
				}
			}
		}
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[0]) {
				return i;
			}
		}
		return nums.length;
	}
	public static void main(String[] args) {
		int[] test_case = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 0 };
		int length = removeDuplicates(test_case);
		System.out.println("final length is " + length);
		for(int ele:test_case) {
			System.out.print(ele + ", ");
		}
	}
}