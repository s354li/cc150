// 1. Write a function that adds two numbers. You should not use + or any arithmetic operators.
public class AddOperator {
	public static int addTwoNums(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return addTwoNums(sum, carry);
	}
	public static void main(String[] args) {
		System.out.println(addTwoNums(567, 739));
	}
}