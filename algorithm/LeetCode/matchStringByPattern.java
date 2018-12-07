// 10. Given an input string and a pattern, implement regular expression matching with support for '.' and '*'
// . is the single character * is the zero or more preceding element
import java.util.*;
public class matchStringByPattern {
	public static boolean isMatch(String iniString, String pattern) {
		if (pattern.isEmpty()) {
			return iniString.isEmpty();
		}
		boolean firstMatch = !iniString.isEmpty() && (iniString.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
		if (pattern.length() > 1 && pattern.charAt(1) == '*') {
			return isMatch(iniString, pattern.substring(2)) || (firstMatch && isMatch(iniString.substring(1), pattern));
		} else {
			return firstMatch && isMatch(iniString.substring(1), pattern.substring(1));
		}
	}
	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "a*"));
		System.out.println(isMatch("", "a*"));
		System.out.println(isMatch("aaaaaaa", ".a*"));
	}
}