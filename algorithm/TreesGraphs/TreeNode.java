import java.util.*;
public class TreeNode<T> {
	public T value;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public boolean visited;
	public TreeNode(T data) {
		value = data;
		left = null;
		right = null;
		visited = false;
	}
}