// 3. Given a string, find the length of the longest substring without repeating characters.
import java.util.*;
import java.lang.*;
public class LongestSubStringNoRepeat {
	public static int findMaxSubString(String iniString) {
		if (iniString.length() < 2) {
			return iniString.length();
		}
		int maxLength = 0;
		int position_front = 0;
		int position_back = 0;
		List<Character> existedCode = new ArrayList<Character>();
		while (position_back < iniString.length()) {
			char currentChar = iniString.charAt(position_back);
			Character currentCharacter = new Character(currentChar);
			if (!existedCode.contains(currentCharacter)) {
				existedCode.add(currentCharacter);
				position_back++;
				maxLength = Math.max(maxLength, position_back - position_front);
			} else {
                char frontChar = iniString.charAt(position_front);
			    Character frontCharacter = new Character(frontChar);
				existedCode.remove(frontCharacter);
				position_front++;
			}
		}
		return maxLength;
	}
	public static ArrayList<String> findSubString(String iniString) {
		ArrayList<String> result = new ArrayList<String>();
		if (iniString.length() < 2) {
			result.add(iniString);
			return result;
		}
		Hashtable<Character, Integer> codebook = new Hashtable<Character, Integer>();
		int maxLength = 0;
		int position_front = 0;
		int position_back = 0;
		while (position_back < iniString.length() && position_front <= position_back) {
			char currentChar = iniString.charAt(position_back);
			Character currentCharacter = new Character(currentChar);
			if (codebook.containsKey(currentCharacter)) {
				int currentLength = position_back - position_front;
				if (currentLength > maxLength) {
					result.clear();
					result.add(iniString.substring(position_front, position_back));
					maxLength = currentLength;
				} else if (currentLength == maxLength) {
					result.add(iniString.substring(position_front, position_back));
				}
				int previousPos = codebook.get(currentCharacter);
				position_front = previousPos + 1;
				Set<Character> setOfChar = codebook.keySet();
				Set<Character> clonedCharSet = new HashSet<Character>();
				clonedCharSet.addAll(setOfChar);
				for(Character item:clonedCharSet) {
					if (codebook.get(item) <= previousPos) {
						codebook.remove(item);
					}
				}
				codebook.put(currentCharacter, position_back);
				position_back++;
			} else {
				codebook.put(currentCharacter, position_back);
				position_back++;
			}
		}
		int currentLength = position_back - position_front;
        if (currentLength > maxLength) {
            result.clear();
			result.add(iniString.substring(position_front, position_back));
			maxLength = currentLength;
        } else if (currentLength == maxLength) {
			result.add(iniString.substring(position_front, position_back));
		}
		return result;
	}
	public static void main(String[] args) {
		String iniString = "abcabcbb";
		ArrayList<String> result = findSubString(iniString);
		for(String item : result) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println(result.get(0).length());
		int lengthResult = findMaxSubString(iniString);
		System.out.println(lengthResult);
	}
}