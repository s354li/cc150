// 3. Write a method to randomly generate a set of m integers from an array of size n. Each element must have equal probability of being chosen.
import java.util.*;
public class RandomChoose {
	public static int RandomNum(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}
	public static List<Integer> chooseNum(int[] iniArray, int m){
		ArrayList<Integer> codebook = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < iniArray.length; i++) {
			codebook.add(iniArray[i]);
		}
		for(int j = 0; j < m; j++) {
			int randomNum = RandomNum(0, iniArray.length - 1 - j);
			result.add(codebook.get(randomNum));
			codebook.remove(codebook.get(randomNum));
		}
		return result;
	}
	public static List<Integer> chooseNumSecond(int[] iniArray, int m){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			int random = RandomNum(i, iniArray.length - 1);
			result.add(iniArray[random]);
			int temp = iniArray[random];
			iniArray[random] = iniArray[i];
			iniArray[i] = temp;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] test = new int[] {1,3,5,6,2,4,7,9,12,45,38,98};
		List<Integer> result = chooseNumSecond(test, 5);
		for(Integer item : result) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}