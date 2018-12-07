// 9. Write a method to generate a random number between 1 and 7, given a method that generates a random number between 1 and 5 
// (i.e., implement rand7() using rand5()).
public class RandomNumber {
	public static int Random5() {
		return (int)(Math.random() * 5) + 1;
	}
	public static int Random7() {
		int result = (int) 5 * (Random5() - 1) + Random5();
		if (result >= 1 && result <= 7) {
			return result;
		} else {
			return Random7();
		}
	}
	public static void main(String[] args) {
		System.out.println(Random7());
		System.out.println(Random7());
		System.out.println(Random7());
		System.out.println(Random7());
		System.out.println(Random7());
		System.out.println(Random7());
		System.out.println(Random7());
	}
}