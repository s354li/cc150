// 22. Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
import java.util.*;
public class GenerateParentheses {
	public static List<String> generateParen(int front, int back, int n, String current) {
		if (front < back) {
			return new ArrayList<String>();
		}
		if (front > back) {
			List<String> result = new ArrayList<String>();
			if (front == n) {
				result.addAll(generateParen(front, back + 1, n, current + ")"));
				return result;
			} else {
				result.addAll(generateParen(front + 1, back, n, current + "("));
				result.addAll(generateParen(front, back + 1, n, current + ")"));
				return result;
			}
		} else {
			List<String> result = new ArrayList<String>();
			if (back == n) {
				result.add(current);
				return result;
			} else {
				result.addAll(generateParen(front + 1, back, n, current + "("));
				return result;
			}
		}
	}
	public static List<String> generateParenthesis(int n) {
		int front = 0;
		int back = 0;
		return generateParen(front, back, n, "");
	}
	public static void main(String[] args) {
		List<String> result = generateParenthesis(4);
		for (String ele : result) {
			System.out.println(ele);
		}
	}
}