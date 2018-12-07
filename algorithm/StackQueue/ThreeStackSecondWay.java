// 1. Describe how you could use a single array to implement three stacks.
import java.util.*;
public class ThreeStackSecondWay<T> {
	public ArrayList<StackNode<T>> stackArray;
	public List<StackNode<T>> stacksLocation;
	public ThreeStackSecondWay() {
		stackArray = new ArrayList<StackNode<T>>();
		stacksLocation = new ArrayList<StackNode<T>>();
		stacksLocation.add(null);
		stacksLocation.add(null);
		stacksLocation.add(null);
	}
	public boolean push(T value, int stackNumber) {
		StackNode<T> newItem = new StackNode<T>();
		newItem.data = value;
		newItem.previous = stacksLocation.get(stackNumber - 1);
		stacksLocation.set(stackNumber - 1, newItem);
		stackArray.add(newItem);
		return true;
	}
	public T pop(int stackNumber) {
		StackNode<T> result = stacksLocation.get(stackNumber - 1);
		stacksLocation.set(stackNumber - 1, result.previous);
		stackArray.remove(result);
		return result.data;
	}
	public T peek(int stackNumber) {
		return stacksLocation.get(stackNumber - 1).data;
	}
	public boolean empty(int stackNumber) {
		if (stacksLocation.get(stackNumber - 1) == null) {
			return true;
		}
		return false;
	}
	public List<Set<Integer>> search(T value) {
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		for (int i = 0; i < 3; i++) {
			StackNode<T> currentStack = stacksLocation.get(i);
			int count = 1;
			while (currentStack != null) {
				if (currentStack.data == value) {
					Set<Integer> currentResult = new HashSet<Integer>();
					currentResult.add(i + 1);
					currentResult.add(count);
					result.add(currentResult);
				}
				currentStack = currentStack.previous;
				count++;
			}
		}
		return result;
	}
}
