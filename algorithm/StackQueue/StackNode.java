import java.util.*;
public class StackNode<T> {
	public T data;
	public StackNode<T> previous;
	public StackNode(T value) {
		data = value;
		previous = null;
	}
	public StackNode() {
		data = null;
		previous = null;
	}
}