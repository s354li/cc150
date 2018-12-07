// 5. The Game of Master Mind is played as follows:
// The computer has four slots containing balls that are red (R), yellow (Y), green (G) or blue (B). 
// For example, the computer might have RGGB (e.g., Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
// You, the user, are trying to guess the solution. 
// You might, for example, guess YRGB. 
// When you guess the correct color for the correct slot, you get a “hit”. 
// If you guess a color that exists but is in the wrong slot, you get a “pseudo-hit”. 
// For example, the guess YRGB has 2 hits and one pseudo hit.
// For each guess, you are told the number of hits and pseudo-hits. 
// Write a method that, given a guess and a solution, returns the number of hits and pseudo hits.
import java.util.*;
public class MasterMind {
	public static void getHitPseudo(String solution, String guess) {
		char[] solutionChar = solution.toCharArray();
		char[] guessChar = guess.toCharArray();
		HashSet<Integer> excludePosition = new HashSet<Integer>();
		int hit = 0;
		for(int i = 0; i < guessChar.length; i++) {
			if (i < solutionChar.length && guessChar[i] == solutionChar[i]) {
				excludePosition.add(i);
				hit++;
			}
		}
		System.out.println("hit number is " + hit);
		int pseudo = 0;
		HashSet<Character> solutionLeft = new HashSet<Character>();
		for(int j = 0; j < solutionChar.length; j++) {
			if (!excludePosition.contains(j)) {
				solutionLeft.add(solutionChar[j]);
			}
		}
		for (int n = 0; n < guessChar.length; n++) {
			if (!excludePosition.contains(n) && solutionLeft.contains(guessChar[n])) {
				pseudo++;
			}
		}
		System.out.println("Pseudo-hits number is " + pseudo);
	}
	public static void main(String[] args) {
		getHitPseudo("RGGB", "YRGB");
	}
}