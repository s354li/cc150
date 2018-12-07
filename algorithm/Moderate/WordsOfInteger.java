// 6. Given an integer between 0 and 999,999, print an English phrase that describes the integer (eg, “One Thousand, Two Hundred and Thirty Four”)
import java.util.*;
import java.lang.*;
public class WordsOfInteger {
	public static String BelowThousandWord(int input) {
		String[] number = new String[] { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		String[] tenLevel = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String[] tensLevel = new String[] { "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] hundredLevel = new String[] { "", "", "hundred" };
		String result = "";
		boolean tenlevelWord = false;
		for (int i = 2; i > -1; i--) {
			int level = (int) Math.pow(10, i);
			if (level == 10 && input/level > 1) {
				result += tensLevel[input/level - 1] + " " + hundredLevel[i];
				input -= input/level * level;
				continue;
			} else if (level == 10 && input/level == 1) {
				tenlevelWord = true;
				input -= input/level * level;
				continue;
			}
			if (level == 1 && tenlevelWord) {
				result += tenLevel[input/level] + " " + hundredLevel[i];
				input -= input/level * level;
				continue;
			}
			result += number[input/level - 1] + " " + hundredLevel[i];
			input -= input/level * level;
		}
		return result;
	}
	public static String IntegerWord(int input) {
		String result = "";
		int thousandInt = input/1000;
		if (thousandInt > 0) {
			result += BelowThousandWord(thousandInt) + " Thousand " + BelowThousandWord(input - thousandInt * 1000);
		} else {
			result += BelowThousandWord(input);
		}
		return result;
	}
	public static String numToString(int input) {

	}
	public static void main(String[] args) {
		String result = IntegerWord(324657);
		System.out.println(result);
		System.out.println(numToString(324657));
	}
}