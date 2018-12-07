// 3. Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer. NOTE: One or two additional variables are fine. An extra copy of the array is not.
import java.util.*;
public class RemoveDuplicate {
	// using additional char array to store exist char
	public static String removeDuplicateChar(String iniString) {
		if (iniString.length() < 2) {
			return iniString;
		}
		boolean[] trackExist = new boolean[256];
		for (int i = 0; i < iniString.toCharArray().length; i++) {
			if (trackExist[(int) iniString.charAt(i)]) {
				iniString = iniString.substring(0, i) + " " + iniString.substring(i + 1);
			} else {
				trackExist[(int) iniString.charAt(i)] = true;
			}
		}
		return iniString.replaceAll(" ","");
	}
	// no additional char array storing anything
	public static String removeDuplicateCharSecondWay(String iniString) {
		char[] iniChar = iniString.toCharArray();
		if (iniChar.length < 2) {
			return iniString;
		}
		for (int i = 0; i < iniChar.length; i++) {
			if (iniChar[i] == '\0') { continue; }
			else {
				for (int j = i + 1; j < iniChar.length; j++) {
					if (iniChar[j] == iniChar[i]) {
						iniChar[j] = '\0';
					}
				}
			}
		}
		String targetString = new String(iniChar);
		return targetString.replaceAll("\0","");
	}

	public static void main(String[] args) {
		String[] testWords = {"abcaaadddccceeeekkkkkde", "heaaaaaaaalgggggglo", "appsssssssle", "kcccccccite", "paaaaaaaadle"};
		for (String word : testWords) {
			System.out.println(word + ": " + " " + removeDuplicateChar(word));
			System.out.println(word + ": " + " " + removeDuplicateCharSecondWay(word));
		}
	}
}