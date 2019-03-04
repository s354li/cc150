// 24. Given a linked list, swap every two adjacent nodes and return its head.
import java.util.*;
public class SwapNodes {
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		int index = 0;
		ListNode previous = new ListNode(0);
		previous.next = head;
		ListNode result = previous;
		while (previous.next != null && previous.next.next != null) {
			if (index % 2 == 0) {
				ListNode temp = previous.next;
				ListNode current = temp.next;
				temp.next = current.next;
				current.next = temp;
				previous.next = current;
			}
			previous = previous.next;
			index++;
		}
		return result.next;
	}
	public static void main(String[] args) {
		ListNode test_case = new ListNode(1);
		test_case.next = new ListNode(2);
		test_case.next.next = new ListNode(3);
		test_case.next.next.next = new ListNode(4);
		ListNode result = swapPairs(test_case);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}