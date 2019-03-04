// 27. Given an array nums and a value val, remove all instances of that value in-place and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length
import java.util.*;
public class RemoveEle {
	public static int findLastIndex(int[] nums, int val, int endIndex, int startIndex) {
		for(int i = startIndex; i > endIndex; i--) {
			if (nums[i] != val) {
				return i;
			}
		}
		return -1;
	}
	public static int removeElement(int[] nums, int val) {
		int lastIndex = nums.length - 1;
		for(int i = 0; i < nums.length; i++) {
			if (i > lastIndex) {
				break;
			}
			int current = nums[i];
			if (current == val) {
				int currentLastIndex = findLastIndex(nums, val, i, lastIndex);
				if (currentLastIndex != -1) {
					nums[i] = nums[currentLastIndex];
					nums[currentLastIndex] = val;
					lastIndex = currentLastIndex;
				} else {
					lastIndex = i - 1;
				}
			}
		}
		return lastIndex + 1;
	}
	public static void main(String[] args) {
		int[] test_case = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		int length = removeElement(test_case, 3);
		System.out.println(length);
		for(int ele:test_case) {
			System.out.print(ele + ",");
		}
		System.out.println();
	}
}