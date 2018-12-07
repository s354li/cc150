// 1. Three stack test file 2. FindMin Stack test file
import java.util.*;
public class ThreeStackTest {
	public static void main(String[] args) {
		/*ThreeStack<Integer> newThreeStack = new ThreeStack<Integer>(10);
		newThreeStack.push(3, 1);
		newThreeStack.push(4, 2);
		newThreeStack.push(5, 3);
		newThreeStack.push(6, 1);
		newThreeStack.push(8, 2);
		System.out.println(newThreeStack.search(3));
		System.out.println(newThreeStack.search(4));
		System.out.println(newThreeStack.search(8));
		System.out.println(newThreeStack.pop(1));
		System.out.println(newThreeStack.pop(2));
		System.out.println(newThreeStack.pop(3));
		System.out.println(newThreeStack.empty(1));
		System.out.println(newThreeStack.empty(2));
		System.out.println(newThreeStack.empty(3));
		System.out.println(newThreeStack.peek(1));
		System.out.println(newThreeStack.peek(2));
		System.out.println(newThreeStack.peek(3));*/

		/*ThreeStackSecondWay<Integer> newThreeStackSecond = new ThreeStackSecondWay<Integer>();
		System.out.println(newThreeStackSecond.push(3, 1));
		System.out.println(newThreeStackSecond.push(4, 2));
		System.out.println(newThreeStackSecond.push(5, 3));
		System.out.println(newThreeStackSecond.push(6, 1));
		System.out.println(newThreeStackSecond.push(8, 2));
		//System.out.println(newThreeStackSecond.search(3));
		//System.out.println(newThreeStackSecond.search(4));
		//System.out.println(newThreeStackSecond.search(8));
		System.out.println(newThreeStackSecond.pop(1));
		System.out.println(newThreeStackSecond.pop(2));
		System.out.println(newThreeStackSecond.pop(3));
		System.out.println(newThreeStackSecond.empty(1));
		System.out.println(newThreeStackSecond.empty(2));
		System.out.println(newThreeStackSecond.empty(3));
		System.out.println(newThreeStackSecond.peek(1));
		System.out.println(newThreeStackSecond.peek(2));
		System.out.println(newThreeStackSecond.peek(3));*/

		/*FindMin<Integer> newFindMinStack = new FindMin<Integer>();
		newFindMinStack.push(24);
		newFindMinStack.push(81);
		newFindMinStack.push(13);
		newFindMinStack.push(10);
		newFindMinStack.push(45);
		System.out.println(newFindMinStack.pop());
		System.out.println(newFindMinStack.findMin());
		newFindMinStack.push(34);
		System.out.println(newFindMinStack.pop());
		System.out.println(newFindMinStack.findMin());
		System.out.println(newFindMinStack.pop());
		System.out.println(newFindMinStack.findMin());*/

		/*SetOfStacks<Integer> setStacks = new SetOfStacks<Integer>(5);
		setStacks.push(23);
		setStacks.push(24);
		setStacks.push(14);
		setStacks.push(56);
		setStacks.push(34);
		setStacks.push(57);
		setStacks.push(28);
		setStacks.push(33);
		setStacks.push(90);
		setStacks.push(17);
		setStacks.push(12);
		setStacks.push(35);
		setStacks.push(48);
		setStacks.push(59);
		setStacks.push(67);
		setStacks.push(99);
		System.out.println(setStacks.pop());
		System.out.println(setStacks.pop());
		System.out.println(setStacks.pop());
		System.out.println(setStacks.pop());
		System.out.println(setStacks.pop());
		System.out.println(setStacks.pop());
		System.out.println(setStacks.pop());
		System.out.println(setStacks.peek());
		System.out.println(setStacks.empty());
		System.out.println(setStacks.popAt(1));
		System.out.println(setStacks.popAt(1));
		System.out.println(setStacks.popAt(1));
		System.out.println(setStacks.popAt(1));
		System.out.println(setStacks.popAt(1));
		System.out.println(setStacks.peek());*/

		/*int n = 5;
		HanoiTower[] towers = new HanoiTower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new HanoiTower(i + 1);
		}
		for (int j = n; j > 0; j--) {
			towers[0].add(j);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);*/

		TwoStacksQueue<Integer> myqueue = new TwoStacksQueue<Integer>();
		myqueue.QueuePush(23);
		myqueue.QueuePush(56);
		myqueue.QueuePush(98);
		myqueue.QueuePush(54);
		myqueue.QueuePush(91);
		System.out.println(myqueue.QueuePop());
		myqueue.QueuePush(93);
		System.out.println(myqueue.QueuePop());
		System.out.println(myqueue.QueuePop());
		myqueue.QueuePush(32);
		System.out.println(myqueue.QueuePop());
		System.out.println(myqueue.QueuePop());
		System.out.println(myqueue.QueuePeek());
		System.out.println(myqueue.QueueEmpty());

		System.out.println("----------------------");

		TwoStacksQueue<Integer> mysecqueue = new TwoStacksQueue<Integer>();
		mysecqueue.QueuePushSecondWay(23);
		mysecqueue.QueuePushSecondWay(56);
		mysecqueue.QueuePushSecondWay(98);
		mysecqueue.QueuePushSecondWay(54);
		mysecqueue.QueuePushSecondWay(91);
		System.out.println(mysecqueue.QueuePopSecondWay());
		mysecqueue.QueuePushSecondWay(93);
		System.out.println(mysecqueue.QueuePopSecondWay());
		System.out.println(mysecqueue.QueuePopSecondWay());
		mysecqueue.QueuePushSecondWay(32);
		System.out.println(mysecqueue.QueuePopSecondWay());
		System.out.println(mysecqueue.QueuePopSecondWay());
		System.out.println(mysecqueue.QueuePeekSecondWay());
		System.out.println(mysecqueue.QueueEmpty());
	}
}
