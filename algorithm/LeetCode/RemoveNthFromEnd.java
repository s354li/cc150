// 19. Given a linked list, remove the n-th node from the end of list and return its head.
import java.util.*;
public class RemoveNthFromEnd {
	// use stack to pop the nth from the last
	public static ListNode removeNth(ListNode head, int nth) {
		if (nth < 1) {
			return head;
		}
		Stack<ListNode> code = new Stack<ListNode>();
		ListNode current = head;
		while (current != null) {
			code.push(current);
			current = current.next;
		}
		int start = 1;
		ListNode temp = null;
		while (!code.empty()) {
			if (start == nth) {
				code.pop();
				start++;
			} else {
				ListNode upper = code.pop();
				upper.next = temp;
				temp = upper;
				start++;
			}
		}
		return temp;
	}
	// calculate the size first and then minus the nth find the position
	public static ListNode removeNthSec(ListNode head, int nth) {
		if (nth < 1) {
			return head;
		}
		int total = 0;
		ListNode current = head;
		while (current != null) {
			total++;
			current = current.next;
		}
		int position = total - nth;
		if (position == 0) {
            return head.next;
        }
		total = 0;
		current = head;
		while (current != null) {
			if (total == position - 1) {
				current.next = current.next.next;
			}
			current = current.next;
			total++;
		}
		return head;
	}
	// two pointer distance is nth, and move together until the front one reach the end and modify the late pointer to delete the after node
	public static ListNode removeNthThrid(ListNode head, int nth) {
		if (nth < 1 || head == null) {
			return head;
		}
		int start = 0;
		ListNode front = head;
		ListNode late = head;
		while (start != nth) {
			front = front.next;
			start++;
		}
		if (front == null) {
			return head.next;
		}
		while (front.next != null) {
			front = front.next;
			late = late.next;
		}
		late.next = late.next.next;
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode result = removeNthSec(head, 2);
		ListNode current = result;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	} 
}