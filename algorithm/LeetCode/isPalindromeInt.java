// 9. Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
import java.util.*;
public class isPalindromeInt {
	public static boolean isPalindrome(int iniInt){
		if (iniInt < 0) {
			return false;
		}
		if (iniInt >= 0 && iniInt < 10) {
			return true;
		}
		ArrayList<Integer> allInts = new ArrayList<Integer>();
		while (iniInt / 10 > 0) {
			allInts.add(iniInt % 10);
			iniInt /= 10;
		}
		allInts.add(iniInt);
		for(int i = 0; i < allInts.size() / 2; i++) {
			if (allInts.get(i) != allInts.get(allInts.size() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(1));
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(Integer.MAX_VALUE));
	}
}