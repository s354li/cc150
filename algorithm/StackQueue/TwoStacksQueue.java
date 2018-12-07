// 5. Implement a MyQueue class which implements a queue using two stacks.
import java.util.*;
public class TwoStacksQueue<T> {
	public Stack<T> pushStack;
	public Stack<T> popStack;
	public TwoStacksQueue() {
		pushStack = new Stack<T>();
		popStack = new Stack<T>();
	}
	public T QueuePush(T value) {
		while (!popStack.empty()) {
			pushStack.push(popStack.pop());
		}
		return pushStack.push(value);
	}
	public T QueuePushSecondWay(T value) {
		return pushStack.push(value);
	}
	public T QueuePop() {
		while (!pushStack.empty()) {
			popStack.push(pushStack.pop());
		}
		return popStack.pop();
	}
	public T QueuePopSecondWay() {
		if (popStack.empty()) {
			while (!pushStack.empty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.pop();
	}
	public boolean QueueEmpty() {
		return pushStack.empty() && popStack.empty();
	}
	public T QueuePeek() {
		while (!pushStack.empty()) {
			popStack.push(pushStack.pop());
		}
		return popStack.peek();
	}
	public T QueuePeekSecondWay() {
		if (popStack.empty()) {
			while (!pushStack.empty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.peek();
	}
}