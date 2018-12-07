// 3. Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
import java.util.*;
public class DeleteMiddleNode {
	public static boolean deleteMiddleNode(LinkedListNode middle) {
		if (middle == null || middle.next == null) {
			return false;
		}
		LinkedListNode next = middle.next;
		middle.data = next.data;
		middle.next = next.next;
		return true;
	}
	public static void main(String[] args) {
		LinkedListNode testData = new LinkedListNode(21);
		testData.add(23);
		testData.add(22);
		testData.add(45);
		testData.add(22);
		testData.add(23);
		if (deleteMiddleNode(testData.next.next)) {
			while (testData.next != null) {
				System.out.println(testData.data);
				testData = testData.next;
			}
			System.out.println(testData.data);
		}
	}
}
