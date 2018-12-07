// 4. Write a method to compute all permutations of a string
import java.util.*;
import java.lang.*;
public class StringPermutation {
	public static ArrayList<String> getPermutation(String iniString) {
		ArrayList<String> result = new ArrayList<String>();
		if (iniString.length() == 1) {
			result.add(iniString);
			return result;
		}
		String extra = iniString.substring(0, 1);
		String rest = iniString.substring(1);
		ArrayList<String> roundString = getPermutation(rest);
		for(String item : roundString) {
			for(int i = 0; i < item.length() + 1; i++) {
				String current;
				if (i == 0) {
					current = extra + item;
				} else if (i == item.length()) {
					current = item + extra;
				} else {
					current = item.substring(0, i) + extra + item.substring(i);
				}
				result.add(current);
			}
		}
		return result;
	}
	public static ArrayList<String> getPermutationSecond(String iniString) {
		ArrayList<String> result = new ArrayList<String>();
		if (iniString.length() == 1) {
			result.add(iniString);
			return result;
		}
		for(int i = 0; i < iniString.length(); i++) {
			String extra = iniString.substring(i, i + 1);
			String rest = i == iniString.length() - 1 ? iniString.substring(0, i) : iniString.substring(0, i) + iniString.substring(i + 1);
			ArrayList<String> roundString = getPermutationSecond(rest);
			for(String item : roundString) {
				String current = extra + item;
				result.add(current);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String testString= "abcd";
		System.out.println("------------------------------");
		ArrayList<String> results = getPermutation(testString);
		for(String item : results) {
			System.out.println(item);
		}
		System.out.println("---------------------------");
		ArrayList<String> secresults = getPermutationSecond(testString);
		for(String item : secresults) {
			System.out.println(item);
		}
	}
}
