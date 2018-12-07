// 5. Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
import java.util.*;
public class ListPairParentheses {
	public static void printParenthese(int left, int right, char[] parentheseChar, int count) {
		if (left < 0 || right < 0 || right < left) {
			return;
		}
		if (left == 0 && right == 0) {
			System.out.println(new String(parentheseChar));
			return;
		}
		if (left > 0) {
			parentheseChar[count] = '(';
			printParenthese(left - 1, right, parentheseChar, count + 1);
		}
		if (right > left) {
			parentheseChar[count] = ')';
			printParenthese(left, right - 1, parentheseChar, count + 1);
		}
	}
	public static void main(String[] args) {
		// three pairs of parenthese
		char[] parenthese = new char[6];
		printParenthese(3, 3, parenthese, 0);
	}
}
