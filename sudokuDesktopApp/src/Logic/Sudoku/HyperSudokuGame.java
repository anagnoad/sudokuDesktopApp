package Logic.Sudoku;

import com.example.sudokuapp.Logic.Users.Person;

/**
 * Represents the instance of a HyperSudokuGame started by the Player
 * @author Anthony
 *
 */
public class HyperSudokuGame extends BaseGame {

	/**
	 * Object of the actual puzzle being played.
	 */
	private HyperSudoku mySudoku;
	
	/**
	 * Default constructor. 
	 * Initializing sudoku puzzle (HyperSudoku) and initializing the arraylist of players
	 */
	public HyperSudokuGame()
	{
		super();
		mySudoku = new HyperSudoku();
	}
	
	/**
	 * Constructor that takes the Person who plays the Sudoku as parameter.
	 * @param p
	 */
	public HyperSudokuGame(Person p)
	{
		this();
		players.add(p);
	}
	
	/**
	 * Constructor that takes as parameters 4 points in the sudoku puzzle, so as to define a new
	 * HyperSudoku, with "innersudokus" the ones defined by those points.
	 * 
	 * @param topLeft The upper left corner of the first inner sudoku.
	 * @param topRight The upper left corner of the second inner sudoku.
	 * @param bottomRight The upper left corner of the third inner sudoku.
	 * @param bottomLeft The upper left corner of the fourth inner sudoku.
	 */
	public HyperSudokuGame(Coord_2D topLeft, Coord_2D topRight, Coord_2D bottomRight, Coord_2D bottomLeft)
	{
		super();
		mySudoku = new HyperSudoku(topLeft, topRight, bottomRight, bottomLeft);
	}
	
	/**
	 * Constructor that takes as paramteres 4 points in the sudoku puzzle, so as to define a new
	 * HyperSudoku, with "innersudokus" the ones defined by those points and also
	 * the Person who plays the sudoku.
	 * 
	 * @param p The person playing the Sudoku puzzle.
	 * @param topLeft The upper left corner of the first inner sudoku.
	 * @param topRight The upper left corner of the second inner sudoku.
	 * @param bottomRight The upper left corner of the third inner sudoku.
	 * @param bottomLeft The upper left corner of the fourth inner sudoku.
	 */
	public HyperSudokuGame(Person p, Coord_2D topLeft, Coord_2D topRight, Coord_2D bottomRight, Coord_2D bottomLeft)
	{
		this(topLeft,topRight,bottomRight,bottomLeft);
		players.add(p);
	}
	
	/**
	 * Returns hints for a particular cell of the puzzle.
	 * @param cell
	 * @return int array with all possible integers values.
	 */
	public int[] getHelp(Coord_2D cell)
	{
		return mySudoku.returnHint(cell);
	}
	
	@Override
	public boolean addNumber(int value, Coord_2D coordinates) {
		return mySudoku.setCell(value, coordinates.x, coordinates.y);
	}


	@Override
	public boolean isCompleted() {
		return this.mySudoku.isCompleted();
	}
}
