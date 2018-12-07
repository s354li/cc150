// 4. Design a chess game using object oriented principles
public abstract Piece {
	public String name;
	public int blackWhite;
	public Piece(String value) {
		name = value;
	}
	public abstract Grid TurnAction(int direction, Grid grid);
}
public class King extends Piece {
	public King(int black) {
		super("King");
		this.blackWhite = black;
	}
	@Override
	public Grid TurnAction(int direction, Grid grid, int stepNum) {

	}
}
public class Queen extends Piece {
	public Queen(int black) {
		super("Queen");
		this.blackWhite = black;
	}
	@Override
	public Grid TurnAction(int direction, Grid grid, int stepNum) {
		
	}
}
public class Grid {
	public int position_x;
	public int position_y;
	public Piece currentPiece;
	public Grid(int x, int y) {
		position_x = x;
		position_y = y;
		currentPiece = null;
	}
	public Grid getTurned(int direction, int stepNum) {
		Grid newGrid = currentPiece.TurnAction(direction, this, stepNum);
		currentPiece = null;
		return newGrid;
	}
}
public class Board {
	public Grid[][] boardGrid;
	public Board() {
		boardGrid = new Grid[8][8];
	}
}
public class ComputerPlayer {
	public Stack<Board> steps;
	public int difficulty;
	public ComputerPlayer(int diff) {
		difficulty = diff;
		steps = new Stack<Board>();
	}
	private Board calculateNextStep() {
		// use the Grid.getTurned in this function
		// change the new Grid being the Piece
	}
	public Board getNextStep() {
		// calculate the next position
		Board calculateNextStep = calculateNextStep();
		steps.push(calculateNextStep);
	}
}
public class HumanPlayer {
	private Board thinkNextStep() {
		// use the Grid.getTurned in this function
	}
	public Board getNextStep() {
		Board thinkNextStep = thinkNextStep();
	}
}