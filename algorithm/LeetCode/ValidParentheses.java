// 20. Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
import java.util.*;
public class ValidParentheses {
	public static boolean isValid(String iniString) {
		if (iniString == null || iniString.length() == 1) {
			return false;
		}
		Stack<Character> code = new Stack<Character>();
		for(int i = 0; i < iniString.length(); i++) {
			if (iniString.charAt(i) == '(' || iniString.charAt(i) == '{' || iniString.charAt(i) == '[') {
				code.push(iniString.charAt(i));
			} else if (iniString.charAt(i) == ')') {
				if (code.empty() || code.pop() != '(') {
					return false;
				}
			} else if (iniString.charAt(i) == ']') {
				if (code.empty() || code.pop() != '[') {
					return false;
				}
			} else if (iniString.charAt(i) == '}') {
				if (code.empty() || code.pop() != '{') {
					return false;
				}
			}
		}
		if (code.empty()) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isValid("(((({}[{}]))))"));
	}
}