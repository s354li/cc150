import java.util.*;
// 类： class 类名： DataTypeExample -》 必须和文件名一致
public class DataTypeExample {
	// 一个类中要用属性和方法
	// 类的变量 可以应用在类的所有地方
	public static String firstString = "Hello World";
	// 类的方法，main函数是一个程序的入口函数。 因为这个类就是一个程序，所以必须定义入口函数
	// 方法： 方法的scope + 返回的类型 + 方法名 + （input的数据类型 + input的变量名）
	public static void main(String[] args) {
		byte b1 = 126;
		short s1 = 30000;
		long i1 = 5000000;

		// ID: 16位GUID String ：123e4567-e89b-12d3-a456-426655440000

		char c1 = 'a';
		char c2 = 97;

		String ss1 = "Hello";
		String ss2 = "World";

		int[] a1 = {1,2,3,4};
		String[] a2 = {"I", "am", "programmer"};

		// escapt character \n 回车 \t Tab \r return \b 删除
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(i1);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("----------------");
		System.out.print(ss1);
		System.out.println(ss2);
		System.out.println("----------------");
		//循环语句
		for(int i = 0; i < a1.length; i++) {
			// a1[index] 	提取出数组中的值
			System.out.println(a1[i]);
		}
	}
}