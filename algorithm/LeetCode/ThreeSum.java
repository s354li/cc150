// 15. Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.
import java.util.*;
public class ThreeSum {
	public static boolean duplicateList(List<List<Integer>> allGroup, List<Integer> current) {
		for(List<Integer> item:allGroup) {
			List<Integer> temp = new ArrayList<Integer>(item);
			for(int num:current) {
				int pos = temp.indexOf(num);
				if (pos > -1) {
					temp.remove(pos);
				}
			}
			if(temp.size() == 0) {
				return true;
			}
		}
		return false;
	}
	public static List<List<Integer>> getAllGroups(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result; 
		}
		for(int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for(int q = j + 1; q < nums.length; q++) {
					if (nums[i] + nums[j] + nums[q] == 0) {
						List<Integer> current = new ArrayList<Integer>();
						current.add(nums[i]);
						current.add(nums[j]);
						current.add(nums[q]);
						if (!duplicateList(result, current)) {
							result.add(current);
						}
					}
				}
			}
		}
		return result;
	}
	public static List<List<Integer>> getFourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) {
			return result;
		}
		int first = 0;
		while (first < nums.length - 3 && nums[first] <= target) {
			int firstEle = nums[first];
			List<List<Integer>> threeSumResult = getThreeSum(Arrays.copyOfRange(nums, first + 1, nums.length), target - firstEle);
			for(List<Integer> item:threeSumResult) {
				item.add(firstEle);
				result.add(item);
			}
			while (first + 1 < nums.length && nums[first + 1] == nums[first]) {
				first++;
			}
			first++;
		}
		return result;
	}
	public static List<List<Integer>> getThreeSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		int first = 0;
		while (first < nums.length - 2 && nums[first] <= target) {
			int firstEle = nums[first];
			List<List<Integer>> twoSumResult = getTwoSum(Arrays.copyOfRange(nums, first + 1, nums.length), target - firstEle);
			for(List<Integer> item:twoSumResult) {
				item.add(firstEle);
				result.add(item);
			}
			while (first + 1 < nums.length && nums[first + 1] == nums[first]) {
				first++;
			}
			first++;
		}
		return result;
	}
	public static List<List<Integer>> getTwoSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 2) {
			return result;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				List<Integer> current = new ArrayList<Integer>();
				current.add(nums[left]);
				current.add(nums[right]);
				result.add(current);
				while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
					left++;
				}
				left++;
				while (right - 1 > -1 && nums[right - 1] == nums[right]) {
					right--;
				}
				right--;
			} else if (nums[left] + nums[right] < target) {
				while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
					left++;
				}
				left++;
			} else {
				while (right - 1 > -1 && nums[right - 1] == nums[right]) {
					right--;
				}
				right--;
			}
		}
		return result;
	}
	public static List<Integer> getThreeSumClosest(int[] nums, int target) {
		
	}
	public static void main(String[] args) {
		int[] test_case = new int[] {0,1,1};
		Arrays.sort(test_case);
		List<List<Integer>> two_sum_result = getThreeSum(test_case, 0);
		for(List<Integer> item:two_sum_result) {
			for(int singleNum:item) {
				System.out.print(singleNum + " ");
			}
			System.out.println();
		}
	}
}