// 4. Write a method to decide if two strings are anagrams or not.
import java.util.*;
public class AnagramsString {
	public static boolean isAnagramsString(String srcString, String tarString) {
		if (srcString.length() != tarString.length()) { return false; }
		char[] srcCharArray = srcString.toCharArray();
		char[] tarCharArray = tarString.toCharArray();
		Arrays.sort(srcCharArray);
		Arrays.sort(tarCharArray);
		return String.valueOf(srcCharArray).equals(String.valueOf(tarCharArray));
	}
	public static boolean isAnagramsStringSecondWay(String srcString, String tarString) {
		if (srcString.length() != tarString.length()) { return false; }
		char[] srcCharArray = srcString.toCharArray();
		for (char c:srcCharArray) {
			int charIndex = tarString.indexOf(c);
			if (charIndex > -1) {
				tarString = tarString.substring(0, charIndex) + tarString.substring(charIndex + 1);
			}
		}
		return tarString.length() == 0;
	}
	public static boolean isAnagramsStringThirdWay(String srcString, String tarString) {
		if (srcString.length() != tarString.length()) { return false; }
		HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
		for (char c:srcString.toCharArray()) {
			if (dic.containsKey(c)) {
				dic.put(c, dic.get(c) + 1);
			} else {
				dic.put(c, 0);
			}
		}
		for (char t:tarString.toCharArray()) {
			if (!dic.containsKey(t)) {
				return false;
			} else {
				dic.put(t, dic.get(t) - 1);
			}
		}
		for (Map.Entry<Character, Integer> entry:dic.entrySet()) {
			if (entry.getValue() > 0) { return false; }
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isAnagramsString("qwertyhgfdsazxcvbn", "hgfvbnewqdsartycxz"));
		System.out.println(isAnagramsStringSecondWay("qwertyhgfdsazxcvbn", "hgfvbnewqdsartycxz"));
		System.out.println(isAnagramsStringThirdWay("qwertyhgfdsazxcvbn", "hgfvbnewqdsartycxz"));
	}
}
