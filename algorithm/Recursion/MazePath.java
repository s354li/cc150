// 2. Imagine a robot sitting on the upper left hand corner of an NxN grid.
// The robot can only move in two directions: right and down. How many possible paths are there for the robot?
import java.util.*;
import java.lang.*;
public class MazePath {
	public static Stack<Point> pathTrace = new Stack<Point>();
	public static ArrayList<Point> route = new ArrayList<Point>();
	public static int routeNumber(int x, int y) {
		if (x == 1 || y == 1) {
			return 1;
		}
		return routeNumber(x - 1, y) + routeNumber(x, y - 1);
	}
	public static Point[][] createMaze(char[][] charMaze) {
		Point[][] maze = new Point[charMaze.length][];
		for(int i = 0; i < charMaze.length; i++) {
			maze[i] = new Point[charMaze[i].length];
			for(int j = 0; j < charMaze[i].length; j++) {
				if (charMaze[i][j] == '1') {
					Point newPoint = new Point(i, j, false, true);
					maze[i][j] = newPoint;
				} else {
					Point newPoint = new Point(i, j, false, false);
					maze[i][j] = newPoint;
				}
			}
		}
		return maze;
	}
	public static void PrintMaze(Point[][] maze) {
		System.out.println("aaaaaaaaaaaa");
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j].isRoute ? "x" : "o");
			}
			System.out.println();
		}
	}
	public static void findOnePath(Point[][] maze, int start_x, int start_y, int end_x, int end_y) {
		Stack<Point> route = new Stack<Point>();
		Point start = maze[start_x][start_y];
		Point end = maze[end_x][end_y];
		start.setVisited(true);
		route.push(start);
		while(!route.empty()) {
			Point nowPoint = route.peek();
			if (nowPoint.PointEquals(end)) {
				nowPoint = end;
				while(!route.empty()) {
					Point current = route.pop();
					if (Math.abs(current.x - nowPoint.x) + Math.abs(current.y - nowPoint.y) <= 1) {
						maze[current.x][current.y].setRoute();
						nowPoint = current;
					}
				}
				System.out.println("-----------------");
				PrintMaze(maze);
				return;
			} else {
				boolean deadPoint = true;
				for(int i = 0; i < 4; i++) {
					Point nextStep = null;
					switch(i) {
						// up
						case 0:
							if (nowPoint.x > 0) {
								nextStep = maze[nowPoint.x - 1][nowPoint.y];
							}
							break;
						// down
						case 1:
							if (nowPoint.x < maze.length - 1) {
								nextStep = maze[nowPoint.x + 1][nowPoint.y];
							}
							break;
						// left
						case 2:
							if (nowPoint.y > 0) {
								nextStep = maze[nowPoint.x][nowPoint.y - 1];
							}
							break;
						// right
						case 3:
							if (nowPoint.y < maze[nowPoint.x].length - 1) {
								nextStep = maze[nowPoint.x][nowPoint.y + 1];
							}
							break;
						default:
							nextStep = null;
							break;
					}
					if (nextStep != null && !nextStep.isVisited && !nextStep.isBlocked) {
						nextStep.setVisited(true);
						route.push(nextStep);
						deadPoint = false;
					}
				}
				if (deadPoint) {
					route.pop();
				}
			}
		}
		System.out.println("No route found");
	}
	public static boolean getPath(Point[][] maze, int end_x, int end_y) {
		if (!maze[end_x][end_y].isBlocked) {
			pathTrace.push(maze[end_x][end_y]);
		} else {
			return false;
		}
		
		if (end_x == 0 && end_y == 0) {
			return true;
		}
		boolean success = false;
		if (end_x - 1 > -1 && !maze[end_x - 1][end_y].isBlocked) {
			success = getPath(maze, end_x - 1, end_y);
		}
		if (!success && end_y - 1 > -1 && !maze[end_x][end_y - 1].isBlocked) {
			success = getPath(maze, end_x, end_y - 1);
		}
		if (!success) {
			pathTrace.pop();
		}
		return success;
	}
	public static void printOneRoute() {
		for (int i = 0; i < route.size(); i++) {
			System.out.print("(" + route.get(i).x + ", " + route.get(i).y + ") ");
		}
		System.out.println("---------------");
	}
	public static void printAllPath(Point[][] maze, int start_x, int start_y, int end_x, int end_y, int position) {
		if (start_x > end_x || start_y > end_y || maze[start_x][start_y].isBlocked) {
			return;
		}
		if (route.size() > position) {
			route.set(position, maze[start_x][start_y]);
		} else {
			route.add(position, maze[start_x][start_y]);
		}
		if (start_x == end_x && start_y == end_y) {
			printOneRoute();
		} else {
			printAllPath(maze, start_x + 1, start_y, end_x, end_y, position + 1);
			printAllPath(maze, start_x, start_y + 1, end_x, end_y, position + 1);
		}
		return;
	}
	public static void main(String[] args) {
		System.out.println(routeNumber(4, 4));
		System.out.println("-------------------------");
		char[][] maze = new char[][] { 
			{ '0', '0', '1', '1', '0', '0', '0', '1', '1', '1' },
            { '1', '0', '1', '1', '1', '1', '0', '0', '0', '1' },
            { '1', '0', '1', '1', '1', '1', '0', '1', '0', '1' },
            { '1', '0', '1', '0', '0', '0', '0', '1', '0', '1' },
            { '1', '0', '1', '0', '0', '1', '0', '1', '0', '1' },
            { '1', '0', '1', '1', '1', '1', '0', '1', '0', '1' },
            { '1', '0', '1', '0', '0', '1', '0', '1', '0', '1' },
            { '1', '0', '0', '1', '1', '1', '0', '1', '0', '1' },
            { '1', '1', '0', '0', '0', '0', '0', '1', '0', '0' },
            { '1', '1', '1', '1', '1', '1', '1', '1', '1', '0' }, 
        };
        Point[][] newMaze = createMaze(maze);
        findOnePath(newMaze, 0, 0, 9, 9);

        System.out.println("---------------------------");
        char[][] secnewMaze = new char[][] { 
			{ '0', '0', '0', '1', '0', '0', '0', '1', '1', '1' },
            { '0', '0', '0', '1', '1', '1', '0', '0', '0', '1' },
            { '0', '0', '0', '1', '1', '1', '0', '1', '0', '1' },
            { '0', '0', '0', '0', '0', '0', '0', '1', '0', '1' },
            { '0', '0', '1', '0', '0', '1', '0', '0', '0', '0' },
            { '0', '0', '1', '0', '1', '1', '0', '0', '0', '1' },
            { '0', '0', '1', '0', '0', '1', '0', '0', '0', '0' },
            { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0' },
            { '0', '1', '0', '0', '0', '0', '0', '0', '0', '0' },
            { '1', '1', '1', '1', '1', '1', '1', '1', '0', '0' }, 
        };
        Point[][] secondMaze = createMaze(secnewMaze);
        if (getPath(secondMaze, 9, 9)) {
        	while (!pathTrace.empty()) {
        		System.out.print("(" + pathTrace.peek().x + ", " + pathTrace.peek().y + ") ");
        		pathTrace.pop();
        	}
        	System.out.println();
        } else {
        	System.out.println("No Route Found");
        }

        char[][] thirdnewMaze = new char[][] {
        	{ '0', '0', '0', '0' },
        	{ '0', '1', '0', '0' },
        	{ '0', '0', '1', '0' },
        	{ '0', '0', '0', '0' },
        };
        Point[][] thirdMaze = createMaze(thirdnewMaze);
        printAllPath(thirdMaze, 0, 0, 3, 3, 0);
	}
}