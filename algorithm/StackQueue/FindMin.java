// 2. How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.
import java.util.*;
public class FindMin<T extends Comparable<T>> extends Stack<T> {
	private Stack<T> minStack;
	public FindMin() {
		minStack = new Stack<T>();
	}
	public T push(T value) {
		T currentValue = minStack.empty() ? null: minStack.peek();
		if (currentValue == null || currentValue.compareTo(value) >= 0) {
			minStack.push(value);
		}
		return super.push(value);
	}
	public T pop() {
		T result = super.pop();
		if (minStack.peek().compareTo(result) == 0) {
			minStack.pop();
		}
		return result;
	}
	public T findMin() {
		return minStack.peek();
	}
}
