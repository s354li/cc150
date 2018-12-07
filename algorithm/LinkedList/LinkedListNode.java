import java.util.*;
public class LinkedListNode {
	public int data;
	public LinkedListNode next;
	public LinkedListNode(int value) {
		data = value;
		next = null;
	}
	public LinkedListNode() {

	}
	public void add(int value) {
		LinkedListNode newNode = new LinkedListNode(value);
		newNode.next = null;
		LinkedListNode nowNode = this;
		while(nowNode.next != null) {
			nowNode = nowNode.next;
		}
		nowNode.next = newNode;
	}
	public void remove(int value) {
		LinkedListNode previous = this;
		if (previous == null) {
			return;
		}
		if (previous.data == value) {
			data = previous.next == null ? null : previous.next.data;
			next = previous.next == null ? null : previous.next.next;
			return;
		}
		while(previous.next != null) {
			if (previous.next.data == value) {
				previous.next = previous.next.next;
				break;
			} else {
				previous = previous.next;
			}
		}
		return;
	}
	public LinkedListNode deleteNode(LinkedListNode head, int value) {
		LinkedListNode n = head;
		if (n.data == value) {
			return head.next; /* moved head */
		}
		while(n.next != null) {
			if (n.next.data == value) {
				n.next = n.next.next;
				return head; /* head didn’t change */
			}
			n = n.next;
		}
		return head;
	}
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof LinkedListNode))
	        return false;
	    if (obj == this)
	        return true;
	    return this.data == ((LinkedListNode) obj).data && this.next == ((LinkedListNode) obj).next;
	} 
}