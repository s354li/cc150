// 5. Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
import java.util.*;
public class CircularLink {
	public static LinkedListNode beginLoopNode(LinkedListNode iniCircularLink) {
		LinkedListNode list1 = iniCircularLink.next;
		LinkedListNode list2 = iniCircularLink.next.next;
		while (list1 != list2) {
			list1 = list1.next;
			list2 = list2.next.next;
		}
		list1 = iniCircularLink;
		while (list1 != list2) {
			list1 = list1.next;
			list2 = list2.next;
		}
		return list2;
	}
	public static LinkedListNode beginLoopNodeSecond(LinkedListNode iniCircularLink) {
		Hashtable<Integer, LinkedListNode> locationHash = new Hashtable<Integer, LinkedListNode>();
		int position = 0;
		while (iniCircularLink.next != null) {
			if (locationHash.containsValue(iniCircularLink)) {
				break;
			}
			locationHash.put(position, iniCircularLink);
			position++;
			iniCircularLink = iniCircularLink.next;
		}
		return iniCircularLink;
	}
	public static void main(String[] args) {
		LinkedListNode testlink = new LinkedListNode();
		testlink.data = 1;
		int testLimit = 2;
		while (testLimit < 10) {
			LinkedListNode current = new LinkedListNode();
			current.data = testLimit;
			current.next = null;
			LinkedListNode location = testlink;
			while(location.next != null) {
				location = location.next;
			}
			location.next = current;
			testLimit++;
		}

		LinkedListNode loopbegin = testlink.next.next.next;
		System.out.println(loopbegin.data);

		LinkedListNode location = testlink;
		while(location.next != null) {
			location = location.next;
		}
		location.next = loopbegin;
		
		LinkedListNode result = beginLoopNodeSecond(testlink);
		
		System.out.println(result.data);
	}
}
