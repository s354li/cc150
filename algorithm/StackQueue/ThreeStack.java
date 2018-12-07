// 1. Describe how you could use a single array to implement three stacks.
import java.util.*;
public class ThreeStack<T> {
	public T[] stackArray;
	public int stackSize;
	public int[] currentlocation;
	public ThreeStack(int stackSizeValue) {
		stackArray = (T[]) new Object[stackSizeValue * 3];
		stackSize = stackSizeValue;
		currentlocation = new int[]{ 0, 0, 0 };
	}
	public boolean push(T value, int stackNumber) {
		if (currentlocation[stackNumber - 1] == stackNumber * stackSize) {
			throw new ArrayIndexOutOfBoundsException("Stack is already full");
		}
		stackArray[(stackNumber - 1) * stackSize + currentlocation[stackNumber - 1]] = value;
		currentlocation[stackNumber - 1]++;
		return true;
	}
	public T pop(int stackNumber) {
		if (currentlocation[stackNumber - 1] == 0) {
			throw new NullPointerException("The Stack is empty");
		}
		T result = stackArray[(stackNumber - 1) * stackSize + currentlocation[stackNumber - 1] - 1];
		currentlocation[stackNumber - 1]--;
		return result;
	}
	public T peek(int stackNumber) {
		if (currentlocation[stackNumber - 1] == 0) {
			throw new NullPointerException("The Stack is empty");
		}
		return stackArray[(stackNumber - 1) * stackSize + currentlocation[stackNumber - 1] - 1];
	}
	public boolean empty(int stackNumber) {
		if (currentlocation[stackNumber - 1] == 0) {
			return true;
		}
		return false;
	}
	public List<Set<Integer>> search(T value) {
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		for(int i = 0; i < this.stackArray.length; i++) {
			if (stackArray[i] == value) {
				int currentStackNum = i / stackSize + 1;
				int index = i % stackSize;
				Set<Integer> currentResult = new HashSet<Integer>();
				currentResult.add(currentStackNum);
				currentResult.add(index);
				result.add(currentResult);
			}
		}
		return result;
	}
}
