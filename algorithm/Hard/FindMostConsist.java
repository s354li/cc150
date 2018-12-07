// 7. Write a program to find the longest word made of other words.
import java.util.*;
public class FindMostConsist {
	public static boolean canBeDivided(String[] elementArray, String targetString) {
		for (int i = 1; i <= targetString.length(); i++) {
			String current = targetString.substring(0, i);
			if (i == targetString.length() && Arrays.asList(elementArray).contains(current)) {
				return true;
			}
			if (Arrays.asList(elementArray).contains(current) && canBeDivided(elementArray, targetString.substring(i + 1))) {
				return true;
			}
		}
		return false;
	}
	public static String findMostConsistElement(String[] iniArray) {
		Arrays.sort(iniArray, new LengthCompare());
		for(int i = 0; i < iniArray.length; i++) {
			String temp = iniArray[i];
			if (canBeDivided(Arrays.copyOfRange(iniArray, i, iniArray.length), temp)) {
				return temp;
			}
		}
		return "Can not find answer";

	}
	public static void main(String[] args) {
		String[] test = new String[] { "test", "tester", "testertest", "testing", 
			"apple", "seattle", "banana",  "batting", "ngcat", 
			"batti","bat", "testingtester", "testbattingcat" };
		System.out.println(findMostConsistElement(test));
	}
}