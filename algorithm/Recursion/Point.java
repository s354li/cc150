import java.util.*;
public class Point {
	public int x;
	public int y;
	public boolean isVisited;
	public boolean isBlocked;
	public boolean isRoute;
	public Point(int valuex, int valuey) {
		super();
		x = valuex;
		y = valuey;
		isVisited = false;
		isBlocked = false;
		isRoute = false;
	}
	public Point(int valuex, int valuey, boolean visited, boolean blocked) {
		super();
		x = valuex;
		y = valuey;
		isVisited = visited;
		isBlocked = blocked;
		isRoute = false;
	}
	public void setVisited(boolean visited) {
		isVisited = visited;
	}
	public void setBlock(boolean blocked) {
		isBlocked = true;
	}
	public void setRoute() {
		isRoute = true;
	}
	public boolean PointEquals(Point compared) {
		return compared.x == this.x && compared.y == this.y;
	}
}