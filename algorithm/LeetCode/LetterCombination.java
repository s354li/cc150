// 17. Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
import java.util.*;
public class LetterCombination {
	public static String[][] codebook = new String[][] {
		{"a", "b", "c"},
		{"d", "e", "f"},
		{"g", "h", "i"},
		{"j", "k", "l"},
		{"m", "n", "o"},
		{"p", "q", "r", "s"},
		{"t", "u", "v"},
		{"w", "x", "y", "z"}
	};
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
            return result;
        }
		if (digits.length() == 1) {
			int current = Integer.parseInt(digits) - 2;
			for(int i = 0; i < codebook[current].length; i++) {
				result.add(codebook[current][i]);
			}
			return result;
		}
		int first = Integer.parseInt(digits.substring(0, 1)) - 2;
		List<String> subCombination = letterCombinations(digits.substring(1));
			
		for(String item:subCombination) {
			for(int i = 0; i < codebook[first].length; i++) {
				result.add(codebook[first][i] + item);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<String> result = letterCombinations("23");
		for(String item:result) {
			System.out.print(item + " ");
		}
	}
}