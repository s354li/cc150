// 4. You have two numbers represented by a linked list, where each node contains a single digit. 
// The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
// Write a function that adds the two numbers and returns the sum as a linked list.
import java.util.*;
import java.lang.Math;
public class SumTwoLinkedList {
	// cause a problem for big number overwhelm than the int or long datatype; should switch to the secondway
	private static int getLinkedListNumber(LinkedListNode iniLinkedList) {
		int tenTimes = 0;
		int result = 0;
		while(iniLinkedList.next != null) {
			result += Math.pow(10, tenTimes) * iniLinkedList.data;
			tenTimes++;
			iniLinkedList = iniLinkedList.next;
		}
		result += Math.pow(10, tenTimes) * iniLinkedList.data;
		System.out.println(result);
		return result;
	}
	public static LinkedListNode sumTwoLinkedList(LinkedListNode num1, LinkedListNode num2) {
		int sumResult = getLinkedListNumber(num1) + getLinkedListNumber(num2);
		int tenTimes = 1;
		LinkedListNode result = new LinkedListNode((int) (sumResult % Math.pow(10, tenTimes)));
		sumResult -= result.data;
		result.next = null;
		while(sumResult > 0) {
			LinkedListNode current = new LinkedListNode((int) ((int) (sumResult % Math.pow(10, tenTimes)) / (int) Math.pow(10, tenTimes - 1)));
			current.next = null;
			int position = tenTimes - 2;
			LinkedListNode location = result;
			while (position > 0) {
				location = location.next;
				position--;
			}
			location.next = current;
			sumResult -= current.data * Math.pow(10, tenTimes - 1);
			tenTimes++;
		}
		return result;

	}
	public static LinkedListNode sumTwoLinkedListSecondWay(LinkedListNode num1, LinkedListNode num2) {
		LinkedListNode result = new LinkedListNode();
		int extraPoint = 0;
		int totalNum = 0;
		while (num1 != null) {
			LinkedListNode current = new LinkedListNode();
			int currentData = num1.data + (num2 != null ? num2.data : 0) + extraPoint;
			if (currentData >= 10) {
				current.data = currentData - 10;
				extraPoint = 1;
			} else {
				current.data = currentData;
				extraPoint = 0;
			}
			current.next = null;
			LinkedListNode location = result;
			int position = totalNum;
			while (position > 0) {
				location = location.next;
				position--;
			}
			location.next = current;
			totalNum++;
			num1 = num1.next;
			num2 = (num2 != null) ? num2.next : null;
		}
		while (num2 != null) {
			LinkedListNode current = new LinkedListNode();
			if (num2.data + extraPoint >= 10) {
				current.data = num2.data - 10 + extraPoint;
				extraPoint = 1;
			} else {
				current.data = num2.data + extraPoint;
				extraPoint = 0;
			}
			current.next = null;
			LinkedListNode location = result;
			int position = totalNum;
			while (position > 0) {
				location = location.next;
				position--;
			}
			location.next = current;
			totalNum++;
			num2 = num2.next;
		}
		return result.next;
	}
	public static void main(String[] args) {
		LinkedListNode testNum1 = new LinkedListNode(3);
		testNum1.add(1);
		testNum1.add(6);
		testNum1.add(8);
		testNum1.add(6);
		testNum1.add(8);
		testNum1.add(6);
		testNum1.add(8);
		LinkedListNode testNum2 = new LinkedListNode(5);
		testNum2.add(9);
		testNum2.add(2);
		LinkedListNode result = sumTwoLinkedListSecondWay(testNum1, testNum2);
		while(result.next != null) {
			System.out.println(result.data);
			result = result.next;
		}
		System.out.println(result.data);
	} 
}
