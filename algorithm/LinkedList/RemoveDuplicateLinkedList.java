// 1. Write code to remove duplicates from an unsorted linked list.
// Follow up: How would you solve this problem if a temporary buffer is not allowed?
import java.util.*;
public class RemoveDuplicateLinkedList {
	public static LinkedList<Student> removeDuplicateWithBuffer(LinkedList<Student> iniLinkedList) {
		Hashtable<Integer, Student> entries = new Hashtable<Integer, Student>();
		boolean[] markDuplicate = new boolean[iniLinkedList.size()];
		int position = 0;
		for (int i = 0; i < iniLinkedList.size(); i++) {
			Student temp = (Student) iniLinkedList.get(i);
			if (entries.containsValue(temp)) {
				markDuplicate[i] = true;
			} else {
				entries.put(position, temp);
				position++;
			}
		}
		for (int j = markDuplicate.length - 1; j > -1; j--) {
			if (markDuplicate[j]) {
				iniLinkedList.remove(j);
			}
		}
		return iniLinkedList;
	}
	public static LinkedListNode removeDuplicateNoBuffer(LinkedListNode iniLinkedList) {
		if (iniLinkedList == null) {
			return iniLinkedList;
		}
		LinkedListNode previous = iniLinkedList;
		while(previous.next != null) {
			LinkedListNode current = previous.next;
			while (current.next != null) {
				if (current.data == previous.data) {
					iniLinkedList.remove(current.data);
				}
				current = current.next;
			}
			if (current.data == previous.data) {
				iniLinkedList.remove(current.data);
			}
			previous = previous.next;
		}
		return iniLinkedList;
	}
	public static void main(String[] args) {
		LinkedList<Student> testData = new LinkedList<Student>();
		testData.add(new Student(1, "Grace", 26));
		testData.add(new Student(2, "Jocelyn", 27));
		testData.add(new Student(3, "Rufus", 25));
		testData.add(new Student(1, "Grace", 26));
		testData.add(new Student(3, "Rufus", 25));
		LinkedList<Student> testResult = removeDuplicateWithBuffer(testData);
		for (Student student:testResult) {
			System.out.println(student.printStudent());
		}

		LinkedListNode testData1 = new LinkedListNode(21);
		testData1.add(23);
		testData1.add(22);
		testData1.add(45);
		testData1.add(22);
		testData1.add(23);
		System.out.println(testData1.data + " " + testData1.next.data);
		LinkedListNode testResult1 = removeDuplicateNoBuffer(testData1);
		while (testResult1.next != null) {
			System.out.println(testResult1.data);
			testResult1 = testResult1.next;
		}
		System.out.println(testResult1.data);
	}
}
