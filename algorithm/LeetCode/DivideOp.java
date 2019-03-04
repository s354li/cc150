// 29. Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
// Return the quotient after dividing dividend by divisor.
// The integer division should truncate toward zero.
import java.util.*;
import java.lang.*;
public class DivideOp {
	public static int divide(int dividend, int divisor) {
		boolean positive = true;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			positive = false;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		if (dividend < divisor) {
			return 0;
		} else if (dividend == divisor) {
			return 1;
		} else {
			int posVal = 1 + divide(dividend - divisor, divisor);
			if (positive) {
				return posVal;
			} else {
				return 0 - posVal;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(divide(10, 3));
		System.out.println(divide(7, -3));
	}
}