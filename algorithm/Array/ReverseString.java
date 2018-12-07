// 2. Write code to reverse a C-Style String. (C-String means that "abcd" is represented as five characters, including the null character.)
import java.util.*;
public class ReverseString {
	public static String reverseInput(String iniString) {
		char[] iniStringChar = iniString.toCharArray();
		for(int i = 0; i < iniString.length()/2; i++) {
			char temp = iniStringChar[i];
			iniStringChar[i] = iniStringChar[iniString.length() - i - 1];
			iniStringChar[iniString.length() - i - 1] = temp;
		}
		return new String(iniStringChar);
	}

	public static String reverseInputSecondWay(String iniString) {
		char[] iniStringChar = iniString.toCharArray();
		int low = 0;
		int high = iniString.length() - 1;
		while(low < high) {
			char temp = iniStringChar[low];
			iniStringChar[low] = iniStringChar[high];
			iniStringChar[high] = temp;
			low++;
			high--;
		}
		return new String(iniStringChar);
	}

	public static void main (String[] args) {
		String[] testWord = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : testWord) {
			System.out.println(word + ": " + " " + reverseInput(word));
		}
	}
}
