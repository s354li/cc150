// 8. implement atoi which converts a string to an integer.
import java.util.*;
import java.lang.*;
public class ConvertToInt {
	public static int convertFromString(String iniString) {
		if (iniString == null) {
			return 0;
		}
		String discardSpace = iniString.trim();
		int mark = 1;
		String discardMark;
		if (discardSpace.length() == 0) {
			return 0;
		}
		if (discardSpace.charAt(0) == '-' || discardSpace.charAt(0) == '+') {
			discardMark = discardSpace.substring(1);
			mark = discardSpace.charAt(0) == '-' ? -1 : 1;
		} else {
			try {
				int currentInt = Integer.parseInt(discardSpace.substring(0, 1));
				discardMark = discardSpace;
			}
			catch(NumberFormatException ex) {
				return 0;
			}
		}
		Stack<Integer> allInts = new Stack<Integer>();
		for(int i = 0; i < discardMark.length(); i++) {
			char current = discardMark.charAt(i);
			try {
				int currentInt = Integer.parseInt(String.valueOf(current));
				allInts.push(currentInt);
			}
			catch(NumberFormatException ex) {
                break;
            }
		}
        if (allInts.empty()) {
            return 0;
        }
		int power = 0;
		int result = 0;
        if (mark == 1) {
            while (!allInts.empty()) {
                result += Math.pow(10, power) * allInts.pop();
                if (result == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
			    power++;
            }
		} else {
            while (!allInts.empty()) {
                result -= Math.pow(10, power) * allInts.pop();
                if (result == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
			    power++;
            }
        }
		
		return result;
	}
	public static void main(String[] args) {
		int result = convertFromString("-12345");
		System.out.println(result);
	}
}