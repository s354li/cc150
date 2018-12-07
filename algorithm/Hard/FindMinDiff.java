// 5. You have a large text file containing words.
// Given any two words, find the shortest distance (in terms of number of words) between them in the file.
// Can you make the searching operation in O(1) time? What about the space complexity for your solution?
import java.util.*;
import java.lang.*;
public class FindMinDiff {
	public static int findMinimumDifference(String[] test, String word1, String word2) {
		int diffpos = Integer.MAX_VALUE;
		int word1pos = -1;
		int word2pos = -1;
		for (int i = 0; i < test.length; i++) {
			if (test[i].equals(word1)) {
				word1pos = i;
				if (word2pos > 0 && Math.abs(word1pos - word2pos) < diffpos) {
					diffpos = Math.abs(word1pos - word2pos);
				}
			}
			if (test[i].equals(word2)) {
				word2pos = i;
				if (word1pos > 0 && Math.abs(word1pos - word2pos) < diffpos) {
					diffpos = Math.abs(word1pos - word2pos);
				}
			}
		}
		return diffpos;
	}
	public static int findMinimumDifferenceSecond(String[] test, String word1, String word2) {
		Hashtable<String, ArrayList<Integer>> wordbook = new Hashtable<String, ArrayList<Integer>>();
		for(int i = 0; i < test.length; i++) {
			if (wordbook.containsKey(test[i])) {
				wordbook.get(test[i]).add(i);
			} else {
				wordbook.put(test[i], new ArrayList<Integer>());
				wordbook.get(test[i]).add(i);
			}
		}
		ArrayList<Integer> word1pos = wordbook.get(word1);
		ArrayList<Integer> word2pos = wordbook.get(word2);
		int min = Math.abs(word1pos.get(0) - word2pos.get(0));
		int apos = 0;
		int bpos = 0;
		while(true) {
			if (apos >= word1pos.size() || bpos >= word2pos.size()) {
				break;
			}
			int currentmin = Math.abs(word1pos.get(apos) - word2pos.get(bpos));
			if (currentmin < min) {
				min = currentmin;
			}
			if (word1pos.get(apos) > word2pos.get(bpos)) {
				bpos++;
			} else {
				apos++;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		String[] test = new String[] { "My", "name", "is", "Grace", "Who", "is", "Grace", "Grace", "is", "my", "name" };
		System.out.println("Min pos diff is " + findMinimumDifference(test, "Grace", "name"));
		System.out.println("Min pos diff is " + findMinimumDifferenceSecond(test, "Grace", "name"));
	}
}