// 19. Given a linked list, remove the n-th node from the end of list and return its head.
import java.util.*;
public class RemoveNthNode {
	public static ListNode removeNthNodeFromEnd (ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		Stack<ListNode> tank = new Stack<ListNode>();
		while (head != null) {
			tank.push(head);
			head = head.next;
		}
		int position = 1;
		ListNode result = null;
		ListNode temp = null;
		while (!tank.empty()) {
			ListNode current = tank.pop();
			if (position != n) {
				current.next = temp;
				temp = current;
				result = current;
			}
			position++;
		}
		return result;
	}

	public static ListNode removeNthNodeFromEndSec (ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		ListNode backPointer = head;
		ListNode frontPointer = head;
		int position = 1;
		while (frontPointer != null && position <= n) {
			
		}
	}

	public static void main(String[] args) {
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		test.next.next.next = new ListNode(4);
		test.next.next.next.next = new ListNode(5);
		test.next.next.next.next.next = new ListNode(6);
		ListNode result = removeNthNodeFromEnd(test, 2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}