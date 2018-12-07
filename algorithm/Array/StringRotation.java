// 8. Assume you have a method isSubstring which checks if one word is a substring of another. 
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring ( i.e., "waterbottle" is a rotation of "erbottlewat").
import java.util.*;
public class StringRotation {
	private static boolean isSubstring(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1.indexOf(s2) > -1;
		}
		return s2.indexOf(s1) > -1;
	}
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() <= 0) {
			return false;
		}
		return isSubstring(s1 + s1, s2);
	}
	public static void main(String[] args) {
		System.out.println("waterbottle is " + (isRotation("waterbottle", "erbottlewat") ? "" : "not ") + "a rotation of erbottlewat");
	}
}
