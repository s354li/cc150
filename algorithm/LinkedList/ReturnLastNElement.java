// 2. Implement an algorithm to find the nth to last element of a singly linked list.
import java.util.*;
public class ReturnLastNElement {
	public static int returnLastNElement(LinkedListNode iniLinkedList, int lastN) {
		Stack<Integer> iniStack = new Stack<Integer>();
		while(iniLinkedList.next != null) {
			iniStack.push(iniLinkedList.data);
			iniLinkedList = iniLinkedList.next;
		}
		iniStack.push(iniLinkedList.data);
		while(lastN > 1) {
			iniStack.pop();
			lastN--;
		}
		return iniStack.pop();
	}
	public static int returnLastNElementSecondWay(LinkedListNode iniLinkedList, int lastN) {
		LinkedListNode current = iniLinkedList;
		LinkedListNode nlater = iniLinkedList;
		int pointer = 0;
		while (nlater.next != null) {
			if (pointer == lastN - 1) {
				break;
			}
			nlater = nlater.next;
			pointer++;
		}
		if (pointer < lastN - 1) {
			return -1;
		}
		while (nlater.next != null) {
			current = current.next;
			nlater = nlater.next;
		}
		return current.data;
	}
	public static void main(String[] args) {
		LinkedListNode testData = new LinkedListNode(21);
		testData.add(23);
		testData.add(22);
		testData.add(45);
		testData.add(22);
		testData.add(23);
		System.out.println(returnLastNElement(testData, 4));
		System.out.println(returnLastNElementSecondWay(testData, 4));
	}
}
