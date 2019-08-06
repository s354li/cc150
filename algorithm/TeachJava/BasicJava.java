import java.util.*;

/* 基本语法
   大小写敏感
   类名首字母大写 MyFirstClass
   方法名首字母小写 myFirstMethod;
   源文件名必须和类名相同
*/

// 对象：对象是类的一个实例
// 类：类是一个模板，它描述一类对象的行为和状态
public class BasicJava {
	// 方法：方法就是行为，一个类可以有很多方法
	// 实例变量：每个对象都有独特的实例变量，对象的状态由这些实例变量的值决定
	// 所有的Java 程序由public static void main(String args[])方法开始执行
	public static void main(String args[]) {
		double i = 3.3e4;
		String result = String.valueOf('c');
		System.out.println(result);
		//int result = BooleanExample();
		//System.out.println(result);

		//System.out.println("Hello World");
		//variableType();
	}

	// 数据类型
	/*public static void variableType() {
		// 1 byte = 8 bits; -128 to 127
		// 1 short = 2 byte; -32,768 to 32,767
		// 1 int = 4 byte; -2,147,483,648 to 2,147,483,647
		// 1 long = 8 byte; -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		byte byteEx = 127;
		System.out.println(byteEx);

		// 1 float = 4 byte; 6 to 7 decimal digits
		// 1 double = 8 byte; 15 decimal digits
		double doubleEx = 3.56;
		double doubleEx2 = 12E4d;
		System.out.println(doubleEx);
		System.out.println(doubleEx2);

		// boolean
		boolean booEx = true;
		System.out.println(booEx);

		// char = 2 byte
		char charEx = 'a';
		char charEx2 = 97;
		System.out.println(charEx);
		System.out.println(charEx2);


		// Widening Casting (automatically) - converting a smaller type to a larger type size
		// byte -> short -> char -> int -> long -> float -> double
		// Narrowing Casting (manually) - converting a larger type to a smaller size type
		// double -> float -> long -> int -> char -> short -> byte

		// String
		String sEx = "Hello World";
		System.out.println(sEx);

		// non-primitive data type: String, Array, Class, Interface
		// A primitive type has always a value, while non-primitve types can be null
		int[] arr1 = { 1, 2, 3 };
		System.out.println(arr1);
		for(int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		for(int i:arr1) {
			System.out.println(i);
		}
	}*/

	// Operators
		// Arithmetic operators: +, -, *, /, %, ++, --
		// assignment and addition assignment
		// binary operator: &, |, ^ (一样0，不一样1), ~(倒转), <<(左移，右侧用0填充), >>(右移，左侧用0填充，第一位为符号位)
		// comparason operator
		// logic operator && || !

	// String

	public static int BooleanExample() {
		//boolean i = 3 > 5;

		// print false;
		//System.out.println(i);

		// boolean flag
		//int[] input = {1,2,3};
		String input = "Hello World";
		return input.length();
		/*if(input.length > 0) {
			for(int i = 0; i < input.length(); i++) {
				if(input[i] == 3) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}*/



		//boolean duplicate = false;
		//for(int i = 0; i < input.lenghth(); i++) {
		//	if(input[i] == 3) {
		//		duplicate = true;
		//		break;
		//	}
		//}
		//return duplicate



		//String a1 = "Hello World";
		//boolean i = a1.contains("H");
		//System.out.println(i);

		//System.out.println(a1.contains("H"));
	}

	public static void stringExamples() {
		String s1 = "Hello Hello World";
		System.out.println(s1.length());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.indexOf("Wor"));
		System.out.println(s1.concat("aaaaa"));
		// escape character: \' \" \\ \n(new line) \r(return) \t(tab) \b(backspace)
	}
}
