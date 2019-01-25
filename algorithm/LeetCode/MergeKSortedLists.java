// 23. Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
public class MergeKSortedLists {
	public static ListNode mergeKLists(ListNode[] lists) {

	}

	public static void main(String[] args) {
		List<ListNode> test_case = new List<ListNode>();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		test_case.add(l1);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		test_case.add(l2);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		test_case.add(l3);
		ListNode result = mergeKLists(test_case);
		while (result != null) {
			System.out.println(result.val);
		}

	}
}