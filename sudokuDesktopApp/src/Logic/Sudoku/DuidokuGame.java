package Logic.Sudoku;

import com.example.sudokuapp.Logic.Users.Person;
/**
 * Class representing the Duidoku game.
 * Can be extened to work with more than one player.
 * @author Steve
 *
 */
public class DuidokuGame 	extends BaseGame // this can be easily extended to be played with more than one player. It's constructor constrained for now.
							implements Multiplayer{

	/**
	 * Member variable showing the steps made in the current Game.
	 * Is used to find out who the winner is.
	 */
	private int stepCounter;
	/**
	 * Member variable representing the (4x4) duidoku board.
	 */
	protected Duidoku mySudoku;
	
	/**
	 * Default ctor.
	 * Makes the basic initializations of the class.
	 */
	public DuidokuGame()
	{
		super();
		this.mySudoku = new Duidoku();
	}
	
	/**
	 * Ctor initializing the game to a two-player game (default for duidoku)
	 * @param Player1 the main player of the game (logged in)
	 * @param Player2 the second player of the game
	 */
	public DuidokuGame(Person Player1, Person Player2)
	{
		this();
		this.players.add(Player1);
		this.players.add(Player2);
	}
	
	@Override
	public boolean addNumber(int value, Coord_2D coordinates) {
		boolean isValid = mySudoku.setCell(value, coordinates.x, coordinates.y);
		if (isValid)
			stepCounter++;
		return isValid;
	}


	@Override
	public Person whoWon() {
		if (this.isCompleted())
			return this.players.get(this.stepCounter%this.players.size());
		else
			return null;
	}

	@Override
	public int getNumberOfPlayers() {
		return this.players.size();
	}

	@Override
	public boolean isCompleted() {
		return this.mySudoku.isCompleted();
	}
	
	/**
	 * Get specific state of the sudoku.
	 * @return the specific state of the duidoku (among FINISHED, NOTFINISHED and FAILED)
	 */
	public sudokuStatus getSudokuStatus() // this may go to an abstract class sudoku
	{
		return this.mySudoku.getSudokuStatus();
	}
	

}
