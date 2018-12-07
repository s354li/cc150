// 11. Given n non-negative integers a1, a2, …, an, where each represents a point at coordinate (i, ai). 
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
// Find two lines, which together with x-axis forms a container, such that the container contains the most water.
import java.util.*;
public class MostWaterCon {
	public static int[] getMostWaterContainer(int[] allLength) {
		int space = 0;
		int[] twoCon = new int[] {0, 0};
		if (allLength.length <= 2) {
			return allLength;
		}
		for(int i = 1; i <= allLength.length; i++) {
			int height = allLength[i - 1];
			if (height > 0) {
				for(int j = i + 1; j <= allLength.length; j++) {
					int secondHeight = allLength[j - 1];
					if (secondHeight > 0) {
						int waterAmount = Math.min(height, secondHeight) * (j - i);
						if (waterAmount > space) {
							twoCon[0] = i;
							twoCon[1] = j;
							space = waterAmount;
						}
					}
				}
			}
		}
		return twoCon;
	}
	public static int MostWaterSpace(int[] allCon) {
		int space = 0;
		int left = 0;
		int right = allCon.length - 1;
		if (allCon.length < 2) {
			return 0;
		}
		if (allCon.length == 2) {
			return allCon[0] * allCon[1];
		}
		while (left < right) {
			int waterAmount = Math.min(allCon[left], allCon[right]) * (right - left);
			space = Math.max(space, waterAmount);
			if (allCon[left] < allCon[right]) {
				left++;
			} else {
				right--;
			}
		}
		return space;
	}
	public static void main(String[] main) {
		int[] containers = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] result = getMostWaterContainer(containers);
		for(int element:result) {
			System.out.print(element + " ");
		}

		System.out.println(MostWaterSpace(containers));
	}
}