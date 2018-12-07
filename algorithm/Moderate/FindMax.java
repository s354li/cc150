// 4. Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
import java.util.*;
public class FindMax {
	public static int FindLarger(int a, int b) {
		int diff = a - b;
		int positive = (diff >> 31) & 1;
		return a - positive * diff;
	}
	public static void main(String args[]) {
		System.out.println(FindLarger(1009, 1890));
	}
}