// 25. Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
// k is a positive integer and is less than or equal to the length of the linked list. 
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
import java.util.*;
public class ReverseNodes {
	public static ListNode findFront(ListNode head, int k) {
		ListNode front = head;
		int tempIndex = 1;
		while (front != null) {
			if (tempIndex < k) {
				front = front.next;
			} else if (tempIndex == k) {
				break;
			}
			tempIndex++;
		}
		return front;
	}
	public static ListNode movePointer(ListNode current, int k) {
		int tempIndex = 0;
		while (tempIndex < k) {
			current = current.next;
			tempIndex++;
		}
		return current;
	}
	public static ListNode reverseListNodes(ListNode start, ListNode end) {
		Stack<ListNode> tank = new Stack<ListNode>();
		ListNode result = new ListNode(1);
		ListNode current = result;
		ListNode following = end.next;
		while (start != end) {
			tank.push(start);
			start = start.next;
		}
		tank.push(end);
		while (!tank.empty()) {
			current.next = tank.pop();
			current = current.next;
		}
		current.next = following;
		return result.next;
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		ListNode previous = new ListNode(0);
		previous.next = head;
		ListNode result = previous;
		ListNode front = findFront(previous, k);
		
		while (previous != null && previous.next != null && front != null && front.next != null) {
			ListNode reversed = reverseListNodes(previous.next, front.next);
			previous.next = reversed;
			previous = movePointer(previous, k);
			front = findFront(previous, k);
		}
		return result.next;
	}
	public static void main(String[] args) {
		ListNode test_case = new ListNode(1);
		test_case.next = new ListNode(2);
		test_case.next.next = new ListNode(3);
		test_case.next.next.next = new ListNode(4);
		test_case.next.next.next.next = new ListNode(5);
		test_case.next.next.next.next.next = new ListNode(6);
		test_case.next.next.next.next.next.next = new ListNode(7);
		ListNode result = reverseKGroup(test_case, 4);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}