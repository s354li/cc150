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
		while (first < nums.length - 3) {
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
		while (first < nums.length - 2) {
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
	public static List<Integer> getTwoSumClosest(int[] nums, int target) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length < 2) {
			return result;
		}
		int left = 0;
		int right = nums.length - 1;
		int closestValue = Integer.MAX_VALUE;
		while (left < right) {
			if (Math.abs(nums[left] + nums[right] - target) < closestValue) {
				closestValue = Math.abs(nums[left] + nums[right]);
				result.clear();
				result.add(nums[left]);
				result.add(nums[right]);
			}
			if (nums[left] + nums[right] == target) {
				return result;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
	public static List<Integer> getThreeSumClosest(int[] nums, int target) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		int first = 0;
		int closestValue = Integer.MAX_VALUE;
		while (first < nums.length - 2) {
			int firstEle = nums[first];
			List<Integer> twoSumResult = getTwoSumClosest(Arrays.copyOfRange(nums, first + 1, nums.length), target - firstEle);
			int twoTotal = 0;
			for(int item:twoSumResult) {
				twoTotal += item;
			}
			if(Math.abs(twoTotal + firstEle - target) < closestValue) {
				closestValue = Math.abs(twoTotal + firstEle - target);
				result.clear();
				result.addAll(twoSumResult);
				result.add(firstEle);
			}
			first++;
		}
		return result;
	}
	public static List<Integer> getThreeSumClosestSec(int[] nums, int target) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		int closestValue = nums[0] + nums[1] + nums[2];
		result.add(nums[0]);
		result.add(nums[1]);
		result.add(nums[2]);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int totalCurrent = nums[i] + nums[left] + nums[right];
				if (Math.abs(totalCurrent - target) < Math.abs(closestValue - target)) {
					result.clear();
					result.add(nums[i]);
					result.add(nums[left]);
					result.add(nums[right]);
					closestValue = totalCurrent;
				}
				if (totalCurrent == target) {
					return result;
				} else if (totalCurrent < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] test_case = new int[] {1,1,1,0};
		Arrays.sort(test_case);
		List<List<Integer>> two_sum_result = getThreeSum(test_case, 0);
		for(List<Integer> item:two_sum_result) {
			for(int singleNum:item) {
				System.out.print(singleNum + " ");
			}
			System.out.println();
		}
		List<Integer> two_sum_cloest = getThreeSumClosestSec(test_case, 0);
		for(int item:two_sum_cloest) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}