package Logic.Sudoku;

import Logic.Users.Person;

/**
 * Represents the instance of a ClassicSudokuGame started by the Player
 * @author Anthony
 *
 */
public class ClassicSudokuGame extends BaseGame
{
	/**
	 * Object of the actual puzzle being played.
	 */
	private ClassicSudoku mySudoku;

	/**
	 * Default constructor. 
	 * Initializing sudoku puzzle (ClassicSudoku) and initializing the arraylist of players
	 */
	public ClassicSudokuGame()// ctor
	{
		super(); // initializes ArrayList<Person>
		mySudoku = new ClassicSudoku();
	}
	
	/**
	 * Constructor with parameters only one player and the type of game.
	 * Used mainly ClassicSudoku, or any other Sudoku that is played by a single player.
	 * @param player
	 */
	public ClassicSudokuGame(Person player)
	{
		this();
		players.add(player);
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
	public boolean addNumber(int value, Coord_2D coordinates)
	{
		return mySudoku.setCell(value, coordinates.x, coordinates.y);
	}
	
//	/**
//	 * Editing a cell of the sudoku.
//	 * @param value
//	 * @param coordinates
//	 * @return true if the action was successfully completed; false otherwise.
//	 */
//	public boolean editNumber(int value, Coord_2D coordinates)
//	{
//		return mySudoku.setCell(value, coordinates.x, coordinates.y);
//	}
//	

	@Override
	public boolean isCompleted()
	{
		return this.mySudoku.isCompleted();
	}
}
