// 1. Write a method to generate the nth Fibonacci number.
import java.util.*;
public class Fibonacci {
	public static int generateFibonacci(int position) {
		if (position < 2) {
			return position + 1;
		}
		return generateFibonacci(position - 2) + generateFibonacci(position - 1);
	}
	public static int[] createFibonacci(int number) {
		int[] result = new int[number];
		for (int i = 0; i < number; i++) {
			result[i] = generateFibonacci(i);
		}
		return result;
	}
	public static int[] createFibonacciSecond(int number) {
		int[] result = new int[number];
		result[0] = 1;
		result[1] = 2;
		for (int i = 2; i < number; i++) {
			result[i] = result[i - 2] + result[i - 1];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] newFob = createFibonacci(10);
		for(int i:newFob) {
			System.out.println(i);
		}
		System.out.println("----------------");
		int[] anotherFob = createFibonacciSecond(10);
		for(int j:newFob) {
			System.out.println(j);
		}
	}
}
