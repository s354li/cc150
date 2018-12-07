// 2. Write a method to shuffle a deck of cards.
// It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely. Assume that you are given a random number generator which is perfect.
import java.util.*;
public class ShuffleCard {
	public static int generateRandom(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}
	public static void ShuffleArray(int[] iniArray) {
		for(int i = 0; i < iniArray.length; i++) {
			int randomNum = generateRandom(i, iniArray.length - 1);
			System.out.println(i + " " + (iniArray.length - 1) + " " + randomNum);
			int temp = iniArray[randomNum];
			iniArray[randomNum] = iniArray[i];
			iniArray[i] = temp;
		}
	}
	public static void main(String[] args) {
		int[] test = new int[] {1,3,5,6,7,9,12,56,78};
		ShuffleArray(test);
		for(int item : test) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}