// 21. Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.
import java.util.*;
public class MergeSortedList {
	public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				if (l2 != null) {
					if (l1.val <= l2.val) {
						current.next = l1;
						l1 = l1.next;
					} else {
						current.next = l2;
						l2 = l2.next;
					}
				} else {
					current.next = l1;
					l1 = l1.next;
				}
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		return result.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode result = mergeTwoSortedLists(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}


