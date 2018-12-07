// 5. Write a method to replace all spaces in a string with '%20'.
import java.util.*;
public class SpaceReplacement {
	public static char[] SpaceReplace(char[] iniCharArray) {
		String iniString = new String(iniCharArray);
		return iniString.replace(" ", "%20").toCharArray();
	}
	public static void main(String[] args) {
		String[] testWords = {"abca   cccee  kde", "hea  l gg lo", "ap sss ssle", " kcccc ccci  te ", "   paaaa aaaa dle"};
		for (String word : testWords) {
			System.out.println(word + ": " + " " + Arrays.toString(SpaceReplace(word.toCharArray())));
		}
	}
}
