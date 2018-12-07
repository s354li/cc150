// 5. Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
import java.util.*;
public class PalindromicString {
	public static boolean isPalindromic(String iniString) {
        if (iniString.length() == 1) {
            return true;
        }
		if (iniString.length() == 2 && iniString.charAt(0) == iniString.charAt(1)){
			return true;
		}
		return iniString.charAt(0) == iniString.charAt(iniString.length() - 1) && isPalindromic(iniString.substring(1, iniString.length() - 1));
	}
	public static String longestPalindrome (String iniString) {
		if (iniString.length() <= 1) {
			return iniString;
		}
		int maxSize = 0;
		String result = "";
		for(int i = 0; i < iniString.length(); i++) {
			for(int j = i + 1; j < iniString.length() + 1; j++) {
				String current = iniString.substring(i, j);
				if (isPalindromic(current) && maxSize < j - i) {
					maxSize = j - i;
					result = current;
				}
			}
		}
		return result;
	}

	public static String HighImproveLongestPalindrome (String iniString) {
		if (iniString.length() <= 1) {
			return iniString;
		}
		boolean[][] isPalindromic = new boolean[iniString.length()][iniString.length()];
		int maxSize = 0;
		String result = "";
		for(int i = 1; i < iniString.length(); i++) {
			for(int j = 0; j < i; j++) {
				boolean innerIsParlind = isPalindromic[j + 1][i - 1] || i - j <= 2;
				if (iniString.charAt(i) == iniString.charAt(j) && innerIsParlind) {
					isPalindromic[j][i] = true;
					if (maxSize < i - j) {
						maxSize = i - j;
						result = iniString.substring(j, i + 1);
					}
				}
			}
		}
		if (maxSize == 0) {
			result = iniString.substring(0, 1);
		}
		return result;
	}
 	public static void main(String[] args) {
		String iniString = "qmbbabbc";
		String result = HighImproveLongestPalindrome("bbabb");
		System.out.println(result);
	}
}