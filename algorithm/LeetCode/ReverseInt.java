// 7. Reverse digits of an integer.
import java.util.*;
import java.lang.*;
public class ReverseInt {
	public static int getReveredInt(int iniInt) {
		if (iniInt > -10 && iniInt < 10) {
			return iniInt;
		}
		if (iniInt >= Integer.MAX_VALUE || iniInt <= Integer.MIN_VALUE) {
			return 0;
		}
		int mark = iniInt < 0 ? -1 : 1;
		iniInt = Math.abs(iniInt);
		Queue<Integer> intHolder = new LinkedList<Integer>();
		int digitNum = 0;
		while (iniInt / (int) Math.pow(10, digitNum) > 9) {
			digitNum++;
		}
		while (digitNum > -1) {
			intHolder.add(iniInt / (int) Math.pow(10, digitNum));
			iniInt -= iniInt / (int) Math.pow(10, digitNum) * Math.pow(10, digitNum);
			digitNum--;
		}
		digitNum = 0;
		int result = 0;
		while (!intHolder.isEmpty()) {
			result += Math.pow(10, digitNum) * intHolder.poll();
			if (result >= Integer.MAX_VALUE) {
				return 0;
			}
			digitNum++;
		}
		return mark * result;
	}
	public static int revert(int iniInt) {
		int revert = 0;
		while (iniInt != 0) {
			int temp = revert * 10 + iniInt % 10;
			iniInt /= 10;
			if (temp / 10 != revert) {
				return 0;
			}
			revert = temp;
		}
		return revert;
	}
	public static void main(String[] args) {
		System.out.println(getReveredInt(123));
	}
}