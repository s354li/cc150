// 1. Write a function to swap a number in place without temporary variables.
import java.util.*;
public class SwapNumbers {
	public static void SwapTwoNumbers(int a, int b) {
		b = a + b;
		a = b - a;
		b = b - a;
		System.out.print(a + " " + b);
		System.out.println();
	}
	public static void main(String[] args) {
		int a = 4;
		int b = 5;
		SwapTwoNumbers(a, b);

	}
}