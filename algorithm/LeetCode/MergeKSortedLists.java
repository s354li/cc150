// 23. Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
import java.util.*;
public class MergeKSortedLists {
	public static int getSmallestNum(ArrayList<Integer> numList, int validNum) {
		if (numList == null || numList.size() == 0 || validNum == 0) {
			return -1;
		}
		int smallest = numList.get(0);
		int index = 0;
		for(int i = 1; i < numList.size(); i++) {
			if (numList.get(i) < smallest) {
				smallest = numList.get(i);
				index = i;
			}
		}
		return index;
	}
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		}
		ArrayList<Integer> numList = new ArrayList<Integer>();
		int validNum = 0;
		for(int i = 0; i < lists.length; i++) {
			if (lists[i] == null) {
				numList.add(Integer.MAX_VALUE);
			} else {
				numList.add(lists[i].val);
				validNum++;
			}
		}
		int smallestIndex = getSmallestNum(numList, validNum);
		if (smallestIndex == -1) {
			return null;
		}
		ListNode result = new ListNode(numList.get(smallestIndex));
		lists[smallestIndex] = lists[smallestIndex].next;
		result.next = mergeKLists(lists);
		return result;
	}

	public static void main(String[] args) {
		ListNode[] test_case = new ListNode[3];
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		test_case[0] = l1;
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		test_case[1] = l2;
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		test_case[2] = l3;
		ListNode result = mergeKLists(test_case);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}