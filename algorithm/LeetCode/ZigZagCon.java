// 6. The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows.
// (you may want to display this pattern in a fixed font for better legibility)
import java.util.*;
import java.lang.*;
public class ZigZagCon {
	public static String convert(String iniString, int numRows) {
		int interval = numRows * 2 - 2;
		if (iniString == null || numRows < 2 || iniString.length() <= numRows) {
			return iniString;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			int startPos = i;
			int innerInterval = interval - 2 * i;
			while (startPos < iniString.length()) {
				sb.append(iniString.charAt(startPos));
				if (i > 0 && i < numRows - 1 && startPos + innerInterval < iniString.length()) {
					sb.append(iniString.charAt(startPos + innerInterval));
				}
				startPos += interval;
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String result = convert("PAYPALISHIRING", 4);
		System.out.println(result);
	}
}