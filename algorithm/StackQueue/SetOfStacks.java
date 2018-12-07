// 3. Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
// Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
// Implement a data structure SetOfStacks that mimics this. 
// SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity. 
// SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
import java.util.*;
public class SetOfStacks<T> {
	public ArrayList<Stack<T>> setStacks;
	private int maxStackSize;
	public int currentStackIndex;
	private int currentStackSize;
	public SetOfStacks(int maxSize){
		setStacks = new ArrayList<Stack<T>>();
		maxStackSize = maxSize;
		currentStackSize = 0;
		currentStackIndex = 0;
		setStacks.add(new Stack<T>());
	}
	public T push(T value) {
		if (++currentStackSize > maxStackSize) {
			setStacks.add(new Stack<T>());
			currentStackIndex++;
			setStacks.get(currentStackIndex).push(value);
			currentStackSize = 1;
		} else {
			setStacks.get(currentStackIndex).push(value);
		}
		return value;
	}
	public T pop() {
		T result = setStacks.get(currentStackIndex).pop();
		if (--currentStackSize == 0) {
			if (currentStackIndex < 0) {
				currentStackIndex = 0;
				currentStackSize = 0;
			} else {
				currentStackSize = maxStackSize;
				currentStackIndex--;
				setStacks.remove(currentStackIndex + 1);
			}
		}
		return result;
	}
	public boolean empty() {
		return currentStackSize == 0 && currentStackIndex == 0 && setStacks.get(0).empty();
	}
	public T peek() {
		return setStacks.get(currentStackIndex).peek();
	}
	public T popAt(int setNumber) {
		if (setNumber > currentStackIndex + 1) {
			throw new ArrayIndexOutOfBoundsException("There is not this stack");
		}
		T result = setStacks.get(setNumber - 1).pop();
		if (setStacks.get(setNumber - 1).empty()) {
			setStacks.remove(setNumber - 1);
			currentStackIndex--;
		}
		return result;
	}
}
