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
        findAllPath(generateArea(numRows, numColumns, area), 0, 0, 0);
        return minimum_distance - 1;
    }
    public static int[][] generateArea(int numRows, int numColumns, List<List<Integer>> area) {
        int[][] result = new int[numRows][];
        for(int i = 0; i < numRows; i++) {
            result[i] = new int[numColumns];
            List<Integer> column = area.get(i);
            for(int j = 0; j < column.size(); j++) {
                result[i][j] = column.get(j);
            }
        }
        return result;
    }
    public static void findAllPath(int[][] area, int start_x, int start_y, int position) {
        if (start_y > area.length - 1 || start_y < 0 || start_x > area[0].length - 1 || start_x < 0 || area[start_x][start_y] == 0 || area[start_x][start_y] == 2) {
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
		if (area[start_x][start_y] == 9) {
			compareOneRoute();
		} else {
			area[start_x][start_y] = 2;
		    // right
			findAllPath(area, start_x + 1, start_y, position + 1);
			// up
			findAllPath(area, start_x, start_y + 1, position + 1);
			// left
			findAllPath(area, start_x - 1, start_y, position + 1);
			// down
			findAllPath(area, start_x, start_y - 1, position + 1);
		}
		return;
    }
    public static void compareOneRoute() {
        int currentDis = route.size();
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
    	System.out.println(minimumDistance(5,4,test_case));
    }
}