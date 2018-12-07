// 2. You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
import java.util.*;
public class AddTwoNums {
	public static ListNode addTwoNums(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result = new ListNode(0);
		ListNode current = result;
		int carry = 0;
		while (l1 != null) {
			if (l2 != null) {
				int currentVal = l1.val + l2.val + carry;
				if (currentVal >= 10) {
					carry = 1;
					currentVal -= 10;
				} else {
					carry = 0;
				}
				ListNode temp = new ListNode(currentVal);
				current.next = temp;
				l2 = l2.next;
			} else {
				int currentVal = l1.val + carry;
				if (currentVal >= 10) {
					carry = 1;
					currentVal -= 10;
				} else {
					carry = 0;
				}
				ListNode temp = new ListNode(currentVal);
				current.next = temp;
			}
			current = current.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int currentVal = l2.val + carry;
			if (currentVal >= 10) {
				carry = 1;
				currentVal -= 10;
			} else {
				carry = 0;
			}
			ListNode temp = new ListNode(currentVal);
			current.next = temp;
			l2 = l2.next;
			current = current.next;
		}
		if (carry != 0) {
			ListNode temp = new ListNode(1);
			current.next = temp;
			current = current.next;
		}
		return result.next;
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		n1.next = new ListNode(4);
		n1.next.next = new ListNode(3);
		ListNode n2 = new ListNode(5);
		n2.next = new ListNode(6);
		n2.next.next = new ListNode(4);
		ListNode result = addTwoNums(n1, n2);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}
}