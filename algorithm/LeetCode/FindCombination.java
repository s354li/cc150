// Find all the combination that the sum is 15
import java.util.*;
public class FindCombination {
	public static int countCombination(int[] basecode, int sum) {
		int result = 0;
		if (sum < 0) {
			return result;
		}
		if (sum == 0) {
			return 1;
		}
		if (basecode.length == 1 && basecode[0] != sum) {
			return result;
		}
		if (basecode.length == 1 && basecode[0] == sum) {
			return 1;
		}
		int[] excludeFirst = Arrays.copyOfRange(basecode, 1, basecode.length); 
		result += countCombination(excludeFirst, sum - basecode[0]);
		result += countCombination(excludeFirst, sum);
		return result;
	}
	public static void main(String[] args) {
		int[] test = new int[] {2,2,3,3,4,11,10,5};  // 6
		System.out.println(countCombination(test, 15));
	}
}