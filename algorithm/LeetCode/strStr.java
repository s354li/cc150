// 28. Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
import java.util.*;
public class strStr {
	public static int strStr(String haystack, String needle) {
		if (needle == null || needle == "") {
			return 0;
		}
		if (haystack == null || haystack == "") {
			return -1;
		}
		if(haystack.startsWith(needle)) {
			return 1;
		}
		for(int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0) && strStr(haystack.substring(i + 1), needle.substring(1)) == 1) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaaaa", "bba"));
	}
}