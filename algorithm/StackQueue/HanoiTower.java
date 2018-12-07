// 4. In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide onto any tower. 
// The puzzle starts with disks sorted in ascending order of size from top to bottom
// Only one disk can be moved at a time
// A disk is slid off the top of one rod onto the next rod
// A disk can only be placed on top of a larger disk
import java.util.*;
import java.lang.*;
public class HanoiTower {
	public Stack<Integer> disks;
	public int index;
	public HanoiTower(int i) {
		this.disks = new Stack<Integer>();
		index = i;
	}
	public void add(int value) {
		if (!disks.empty() && disks.peek() <= value) {
			throw new Error("Wrong placing the disk");
		}
		disks.push(value);
	}
	public void moveDisks(int n, HanoiTower dest, HanoiTower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, dest);
			int current = disks.pop();
			System.out.println("Move disk " + current + " from Tower " + index + " to Tower " + dest.index);
			dest.add(current);
			buffer.moveDisks(n - 1, dest, this);
		}
	}
}
