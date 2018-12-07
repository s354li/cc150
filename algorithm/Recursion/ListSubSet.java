// 3. Write a method that returns all subsets of a set.
import java.util.*;
import java.lang.*;
public class ListSubSet {
	public static ArrayList<ArrayList<Integer>> listAllSubSet(ArrayList<Integer> iniSet) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int max_limit = 0;
		for(int i = 0; i < iniSet.size(); i++) {
			max_limit += Math.pow(2, i);
		}
		System.out.println(max_limit);
		for(int j = 0; j <= max_limit; j++) {
			ArrayList<Integer> oneSet = new ArrayList<Integer>();
			int[] currentSet = new int[iniSet.size()];
			for(int i = 0; i < currentSet.length; i++) {
				currentSet[i] = 0;
			}
			int currentBinary = j;
			int position = currentSet.length - 1;
			while (currentBinary > 0) {
				currentSet[position] = currentBinary % 2;
				currentBinary = currentBinary / 2;
				position--;
			}
			for(int m = 0; m < currentSet.length; m++) {
				if (currentSet[m] == 1) {
					oneSet.add(iniSet.get(m));
				}
			}
			result.add(oneSet);
		}
		return result;
	}
	public static ArrayList<ArrayList<Integer>> listAllSubSetSecondWay(ArrayList<Integer> iniSet) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (iniSet.size() == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		ArrayList<Integer> iniSetClone = (ArrayList<Integer>) iniSet.clone();
		for(int i = 0; i < iniSet.size(); i++) {
			int extra = iniSet.get(i);
			iniSetClone.remove(new Integer(extra));
			ArrayList<ArrayList<Integer>> roundResult = listAllSubSetSecondWay(iniSetClone);
			for (int j = 0; j < roundResult.size(); j++) {
				ArrayList<Integer> current = (ArrayList<Integer>) roundResult.get(j).clone();
				current.add(extra);
				result.add(current);
			}
		}
		result.add(new ArrayList<Integer>());
		return result;
	}
	public static void main(String[] args) {
		ArrayList<Integer> iniSet = new ArrayList<Integer>();
		iniSet.add(1);
		iniSet.add(2);
		iniSet.add(3);
		iniSet.add(4);
		ArrayList<ArrayList<Integer>> result = listAllSubSet(iniSet);
		for(ArrayList<Integer> item : result) {
			System.out.print("{");
			for(Integer element : item) {
				System.out.print(" " + element);
			}
			System.out.print(" }");
			System.out.println();
		}
		System.out.println("---------------------");
		ArrayList<ArrayList<Integer>> secResult = listAllSubSetSecondWay(iniSet);
		// ArrayList<ArrayList<Integer>> finalResult = removeDuplicate(secResult);
		System.out.println(secResult.size());
		for(ArrayList<Integer> item : secResult) {
			System.out.print("{");
			for(Integer element : item) {
				System.out.print(" " + element);
			}
			System.out.print(" }");
			System.out.println();
		}
	}
}
