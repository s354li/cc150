// Write a function that reverses a string. The input string is given as an array of characters char[].

import java.util.*;

public class ReverseString {
	public static void main(String[] args) {
		String iniString = "Hello World";
		char[] result = getReverseString(iniString);
		for(char r:result) {
			System.out.println(r);
		}
	}
	public static char[] getReverseString(String input) {
		char[] iniChar = input.toCharArray();
		for(int i = 0; i < iniChar.length/2; i++) {
			char temp = iniChar[i];
			iniChar[i] = iniChar[iniChar.length - i - 1];
			iniChar[iniChar.length - i - 1] = temp;
		}
		return iniChar;
	}
}