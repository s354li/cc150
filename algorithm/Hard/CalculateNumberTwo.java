// 4. Write a method to count the number of 2s between 0 and n.
import java.util.*;
import java.lang.*;
public class CalculateNumberTwo {
	public static int CountNumberTwo(int max) {
		int total = 0;
		for(int i = 0; i <= max; i++) {
			int len = 0;
			while((int)(i / Math.pow(10, len)) > 0) {
				len++;
			}
			int value = i;
			for(int j = len - 1; j > -1; j--) {
				if ((int)(value / Math.pow(10, j)) == 2) {
					total++;
				}
				value %= Math.pow(10, j);
			}
		}
		return total;
	}
	public static int CountNumberTwoSecond(int max) {
		int total = 0;
		int len = 0;
		while((int)(max / Math.pow(10, len)) > 0) {
			len++;
		}
		int previous = 0;
		int currentNum = max;
		for(int j = len - 1; j > -1; j--) {
			if ((int)(currentNum / Math.pow(10, j)) > 2) {
				total += (previous + 1) * Math.pow(10, j);
			} else if ((int)(currentNum / Math.pow(10, j)) == 2) {
				total = total + (int)(previous * Math.pow(10, j)) + (int)(max % Math.pow(10, j)) + 1;
			} else {
				total += (int)(previous * Math.pow(10, j));
			}
			previous = (int)(max / Math.pow(10, j));
			currentNum %= Math.pow(10, j);
		}
		return total;
	}
	public static int CountNumberTwoThird(int max) {
		if (max == 0) {
			return max;
		}
		int power = 1;
		while (10 * power < max) {
			power *= 10;
		}
		int first = (int)(max / power);
		int reminder = max % power;
		if (first > 2) {
			return first * CountNumberTwoThird(power - 1) + CountNumberTwoThird(reminder) + power;
		} else if (first == 2) {
			return first * CountNumberTwoThird(power - 1) + CountNumberTwoThird(reminder) + reminder + 1;
		} else {
			return first * CountNumberTwoThird(power - 1) + CountNumberTwoThird(reminder);
		}
	}
	public static void main(String[] args) {
		System.out.println("There are " + CountNumberTwo(12013) + " twos from 0 to 12013");
		System.out.println("There are " + CountNumberTwoSecond(12013) + " twos from 0 to 12013");
		System.out.println("There are " + CountNumberTwoThird(12013) + " twos from 0 to 12013");
	}
}