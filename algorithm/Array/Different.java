// 1. Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
import java.util.*;
public class Different {
	public static boolean checkDifferent (String iniString) {
		if (iniString.length() > 256)
			return false;
		boolean[] uniqueChar = new boolean[256];
		for (int i = 0; i < iniString.length() - 1; i++) {
			if (iniString.charAt(i) < 0 || iniString.charAt(i) > 255)
				return false;
			if (uniqueChar[i])
				return false;
			uniqueChar[i] = true;
		}
		return true;
	}

	public static void main (String[] args) {
		String[] testWords = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : testWords) {
			System.out.println(word + ": " + " " + checkDifferent(word));
		}
	}
}