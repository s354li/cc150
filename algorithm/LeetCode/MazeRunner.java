import java.util.*;
public class MazeRunner {
	public static ArrayList<List<Integer>> route = new ArrayList<List<Integer>>();
    public static int minimum_distance = Integer.MAX_VALUE;
    public static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        // WRITE YOUR CODE HERE
        if (numRows < 1 || numRows > 1000 || numColumns < 1 || numColumns > 1000) {
            return -1;
        }
        int[][] maze = generateArea(numRows, numColumns, area);
        findAllPath(maze, 0, 0, 0);
        return minimum_distance;
    }
    public static int[][] generateArea(int numRows, int numColumns, List<List<Integer>> area) {
        int[][] result = new int[numRows][];
        for(int i = 0; i < numRows; i++) {
            result[i] = new int[numColumns];
            List<Integer> column = area.get(i);
            for(int j = 0; j < numColumns; j++) {
                result[i][j] = column.get(j);
            }
        }
        for(int[] item:result) {
            for(int element:item) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        return result;
    }
    public static void findAllPath(int[][] maze, int start_x, int start_y, int position) {
        if (start_x > maze.length - 1 || start_x < 0 || start_y > maze[0].length - 1 || start_y < 0 || maze[start_x][start_y] == 0 || maze[start_x][start_y] == 2) {
			return;
		}
		List<Integer> location = new ArrayList<Integer>();
		location.add(start_x);
		location.add(start_y);
		if (route.size() > position) {
			route.set(position, location);
		} else {
			route.add(position, location);
		}
		if (maze[start_x][start_y] == 9) {
			compareOneRoute();
		} else {
			maze[start_x][start_y] = 2;
		    // down
			findAllPath(maze, start_x + 1, start_y, position + 1);
			// right
			findAllPath(maze, start_x, start_y + 1, position + 1);
			// up
			findAllPath(maze, start_x - 1, start_y, position + 1);
			// left
			findAllPath(maze, start_x, start_y - 1, position + 1);
		}
		return;
    }
    public static void compareOneRoute() {
        int currentDis = route.size();
        for (int i = 0; i < route.size(); i++) {
            System.out.print("(" + route.get(i).get(0) + ", " + route.get(i).get(1) + ") ");
        }
        System.out.println("---------------");
        System.out.println("distance: " + currentDis);
        if (currentDis < minimum_distance) {
            minimum_distance = currentDis;
        }
    }
    public static void main(String[] args) {
    	List<List<Integer>> test_case = new ArrayList<List<Integer>>();
    	List<Integer> first = new ArrayList<Integer>();
    	first.add(1);
    	first.add(1);
    	first.add(1);
    	first.add(1);
    	test_case.add(first);
    	List<Integer> second = new ArrayList<Integer>();
    	second.add(0);
    	second.add(1);
    	second.add(1);
    	second.add(1);
    	test_case.add(second);
    	List<Integer> third = new ArrayList<Integer>();
    	third.add(1);
    	third.add(1);
    	third.add(9);
    	third.add(1);
    	test_case.add(third);
    	List<Integer> fourth = new ArrayList<Integer>();
    	fourth.add(0);
    	fourth.add(0);
    	fourth.add(1);
    	fourth.add(1);
    	test_case.add(fourth);
        List<Integer> fifth = new ArrayList<Integer>();
        fifth.add(0);
        fifth.add(0);
        fifth.add(1);
        fifth.add(1);
        test_case.add(fifth);
    	System.out.println(minimumDistance(5,4,test_case));
    }
}