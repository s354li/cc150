// Tree Traversal
import java.util.*;
public class TreeTraversal {
	public static void DeepFirstTraversal(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> path = new Stack<TreeNode<Integer>>();
		path.push(root);
		while(!path.empty()) {
			root = path.pop();
			System.out.print(root.value + " ");
			if (root.right != null) {
				path.push(root.right);
			}
			if (root.left != null) {
				path.push(root.left);
			}
		}
	}
	public static void DeepFirstTraversalSecond(TreeNode<Integer> root) {
		System.out.print(root.value + " ");
		if (root.left != null) {
			DeepFirstTraversalSecond(root.left);
		}
		if (root.right != null) {
			DeepFirstTraversalSecond(root.right);
		}
	}
	public static void BreadFirstTraversal(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> path = new LinkedList<TreeNode<Integer>>();
		path.add(root);
		while (!path.isEmpty()) {
			root = path.poll();
			if (root.left != null) {
				path.add(root.left);
			}
			if (root.right != null) {
				path.add(root.right);
			}
			System.out.print(root.value + " ");
		}
	}
	public static void PreOrderTraversal(TreeNode<Integer> root) {
		System.out.print(root.value + " ");
		if (root.left != null) {
			PreOrderTraversal(root.left);
		}
		if (root.right != null) {
			PreOrderTraversal(root.right);
		}
	}
	public static void PreOrderTraversalSecond(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> path = new Stack<TreeNode<Integer>>();
		path.add(root);
		while (!path.empty()) {
			root = path.pop();
			System.out.print(root.value + " ");
			if (root.left != null) {
				path.add(root.left);
			}
			if (root.right != null) {
				path.add(root.right);
			}
		}
	}
	public static void InOrderTraversal(TreeNode<Integer> root) {
		if (root.left != null) {
			InOrderTraversal(root.left);
		}
		System.out.print(root.value + " ");
		if (root.right != null) {
			InOrderTraversal(root.right);
		}
	}
	public static void InOrderTraversalSecond(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> path = new Stack<TreeNode<Integer>>();
		path.push(root);
		while (!path.empty()) {
			TreeNode<Integer> current = path.peek();
			if ((current.left == null && current.right == null) ||
				((current.left == null || current.left.visited == true))) {
				current = path.pop();
				current.visited = true;
				System.out.print(current.value + " ");
			}
			if (current.left != null && current.left.visited == false) {
				path.push(current.left);
			} else if (current.right != null && current.right.visited == false){
				path.push(current.right);
			}
		}
	}
	public static void PostOrderTraversal(TreeNode<Integer> root) {
		if (root.right != null) {
			PostOrderTraversal(root.right);
		}
		if (root.left != null) {
			PostOrderTraversal(root.left);
		}
		System.out.print(root.value + " ");
	}
	public static void PostOrderTraversalSecond(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> path = new Stack<TreeNode<Integer>>();
		path.push(root);
		while(!path.empty()) {
			TreeNode<Integer> current = path.peek();
			if ((current.left == null && current.right == null) ||
				((current.right == null || current.right.visited == true) && (current.left == null || current.left.visited == true))) {
				current = path.pop();
				current.visited = true;
				System.out.print(current.value + " ");
			}
			if (current.right != null && current.right.visited == false) {
				path.push(current.right);
			} else if (current.left != null && current.left.visited == false) {
				path.push(current.left);
			}
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);
		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		root.right.left = new TreeNode<Integer>(6);
		root.right.right = new TreeNode<Integer>(7);
		System.out.println("DeepFirstTraversal--------------------------");
		DeepFirstTraversal(root);
		System.out.println();
		System.out.println("DeepFirstTraversalSecond--------------------------");
		DeepFirstTraversalSecond(root);
		System.out.println();
		System.out.println("BreadFirstTraversal--------------------------");
		BreadFirstTraversal(root);
		System.out.println();
		System.out.println("PreOrderTraversal--------------------------");
		PreOrderTraversal(root);
		System.out.println();
		System.out.println("PreOrderTraversalSecond--------------------------");
		//PreOrderTraversalSecond(root);
		System.out.println();
		System.out.println("InOrderTraversal--------------------------");
		InOrderTraversal(root);
		System.out.println();
		System.out.println("InOrderTraversalSecond--------------------------");
		//InOrderTraversalSecond(root);
		System.out.println();
		System.out.println("PostOrderTraversal--------------------------");
		PostOrderTraversal(root);
		System.out.println();
		System.out.println("PostOrderTraversalSecond--------------------------");
		PostOrderTraversalSecond(root);
		System.out.println();
	}
}