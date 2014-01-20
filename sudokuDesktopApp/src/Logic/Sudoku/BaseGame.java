package Logic.Sudoku;

import Logic.Users.Person;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Abstract class that is used for a particular game of a puzzle.
 * @author Anthony
 *
 */
public abstract class BaseGame implements Serializable{
	
	/**
	 * The players that are currently playing on the puzzle.
	 */
	protected ArrayList<Person> players;
	
	//ctor
	/**
	 * ctor
	 * Default constructor, initializing the players list.
	 */
	protected BaseGame()
	{
		players = new ArrayList<Person>();
	}
	
	/**
	 * Adding a number to a specified cell.
	 * @param value
	 * @param coordinates
	 * @return true if the action was successfully completed; false otherwise.
	 */
	public abstract boolean addNumber(int value, Coord_2D coordinates);
	
//	/**
//	 * Abstract method for saving current status of the game.
//	 * @return true if operation was successful; false otherwise.
//	 */
//	public abstract boolean saveGame();
//	
//	/**
//	 * Abstract method for loading a status of the game.
//	 * @return true if operation was successful; false otherwise.
//	 */
//	public abstract boolean loadGame();
//	
	
	/**
	 * Returns true if the puzzle is completed; false otherwise.
	 */
	
	public abstract boolean isCompleted();
	
	/**
	 * Performs all the required actions, that are needed so as to quit the game.
	 */
	public void quitGame(boolean toSave)
	{ 
		/*cleaning up and saving new features*/
//		if (!toSave)
//		else
//			return;
	}
	
	
}
