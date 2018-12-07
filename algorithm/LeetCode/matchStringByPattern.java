// 10. Given an input string and a pattern, implement regular expression matching with support for '.' and '*'
import java.util.*;
public class matchStringByPattern {
	public static boolean isMatch(String iniString, String pattern) {
		if (iniString.length() == 0 && pattern.length() == 0) {
			return true;
		}
		if (pattern.length() == 0 || pattern.equals("*") || iniString.length() < pattern.length()) {
			return false;
		}
		for(int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != '.' && pattern.charAt(i) != '*') {
				if (iniString.charAt(i) == pattern.charAt(i)) {
					
				} else {
					return false;
				}
			}
		}
	}
}