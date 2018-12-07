// 3. Write an algorithm which computes the number of trailing zeros in n factorial.
import java.util.*;
public class CountN {
	public static int zeroInTail(int factorial) {
		if (factorial < 0) {
			return -1;
		}
		int result = 0;
		for(int i = 5; i <= factorial; i *= 5) {
			result += factorial / i;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(zeroInTail(26));
		System.out.println(zeroInTail(126));
	}
}