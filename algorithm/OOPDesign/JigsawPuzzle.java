// 6. Implement a jigsaw puzzle. Design the data structures and explain an algorithm to solve the puzzle.
public enum Type {
	FLAT(0), INNER(1), OUTTER(2);
	private int value;
	private static final Map<Integer, Type> MY_MAP = new HashMap<Integer, Type>();
  	static {
    	for (Type myEnum : values()) {
      		MY_MAP.put(myEnum.getValue(), myEnum);
    	}
  	}
	public Type(int value) {
		this.value = value;
	}
}
public class Edge {
	public Type type;
	public Edge(Type type) {
		this.type = type;
	}
	public boolean fitWith(Edge neighbour) {
		if (type == Type.FALT || neightbour.type == Type.FLAT) {
			return false;
		}
		else if (type != neighbour.type){
			return true;
		}
	}
}
public class Piece {
	public Edge left, right, up, bottom;
	public int solvedOrientation;
	public Piece(Edge left, Edge right, Edge up, Edge bottom) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.bottom = bottom;
		this.solvedOrientation = 0;
	}

}
public class Puzzle {
	public HashSet<Piece> allPieces;
	public Piece[][] solution;
	public Hashtable<Edge, HashSet<Piece>>() sorted_piece;
	public Puzzle(HashSet<Piece> pieces) {
		this allPieces = pieces;
		sorted_piece.put(new Edge(Type.FLAT), new HashSet<Piece>());
		sorted_piece.put(new Edge(Type.INNER), new HashSet<Piece>());
		sorted_piece.put(new Edge(Type.OUTTER), new HashSet<Piece>());
		sorting();
	}
	public void sorting() {
		
	}
	public void solvePuzzle() {

	}

}