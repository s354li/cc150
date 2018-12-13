// 14. Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
import java.util.*;
public class LongestPrefix {
	public static String findLongestPrefix (String[] iniStrings) {
		if (iniStrings.length == 0) {
			return "";
		}
		if (iniStrings.length == 1) {
			return iniStrings[0];
		}
		Arrays.sort(iniStrings, new LengthCompare());
		String mostPrefix = iniStrings[0];
		String result = "";
		for(int i = 1; i < mostPrefix.length() + 1; i++) {
			result = mostPrefix.substring(0, i);
			for (int j = 1; j < iniStrings.length; j++) {
				if (!iniStrings[j].startsWith(result)) {
					return mostPrefix.substring(0, i - 1);
				}
			}
		}
		return result;
	}
	public static String findLongestPrefixSec (String[] iniStrings) {
		if (iniStrings == null || iniStrings.length == 0) {
			return "";
		}
		if (iniStrings.length == 1) {
			return iniStrings[0];
		}
		String firstPrefix = iniStrings[0];
		for(int i = 0; i < iniStrings.length; i++) {
			int j = 0;
			String current = iniStrings[i];
			while (j < firstPrefix.length() && j < current.length() && firstPrefix.charAt(j) == current.charAt(j)) {
				j++;
			}
			if (j == 0) {
				return "";
			}
			firstPrefix = firstPrefix.substring(0, j);
		}
		return firstPrefix;
	}
	public static void main(String[] args) {
		System.out.println(findLongestPrefixSec(new String[] { "flower", "flow", "flight" }));
	}
}