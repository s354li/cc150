// 6. Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is implemented. The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
import java.util.*;
public class AscendingStack {
	// like bubble sorting
	public static Stack<Integer> AscendStack(Stack<Integer> iniStack) {
		Stack<Integer> bufferStack = new Stack<Integer>();
		while (!iniStack.empty()) {
			int current = iniStack.pop();
			while (!bufferStack.empty() && bufferStack.peek() >= current) {
				iniStack.push(bufferStack.pop());
			}
			bufferStack.push(current);
		}
		return bufferStack;
	}
	public static void main(String[] args) {
		Stack<Integer> newThreeStack = new Stack<Integer>();
		newThreeStack.push(3);
		newThreeStack.push(55);
		newThreeStack.push(23);
		newThreeStack.push(12);
		newThreeStack.push(89);
		newThreeStack.push(78);
		Stack<Integer> result = AscendStack(newThreeStack);
		System.out.println(result);
	}
}
