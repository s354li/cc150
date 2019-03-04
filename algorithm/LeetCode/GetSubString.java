// 30. You are given a string, s, and a list of words, words, that are all of the same length.
// Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
import java.util.*;
public class GetSubString {
	public static List<String> combinations(String[] words) {
		if (words.length == 0) {
			return new ArrayList<String>();
		} else if (words.length == 1) {
			List<String> result = new ArrayList<String>();
			result.add(words[0]);
			return result;
		} else {
			List<String> result = new ArrayList<String>();
			for(int i = 0; i < words.length; i++) {
				String current = words[i];
				List<String> restCombination = combinations(Arrays.copyOfRange(words, 1, words.length));
				for(String ele:restCombination) {
					result.add(current + ele);
				}
			}
			return result;
		}
	}
	public static List<Integer> findSubstring(String s, String[] words) {
		List<String> allCombination = combinations(words);
		for(String ele:allCombination) {
			
		}

	}
	public static void main(String[] args) {

	}
}