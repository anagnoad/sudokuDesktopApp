package Logic.Sudoku;

import Logic.Users.Person;

/**
 * Interface of Multiplaying. Any game that needs to have multiplayer functionality
 * should implement this interface.
 * @author Anthony
 */
public interface Multiplayer {
 
	/**
	 * Returns the winner of the multiplayer game.
	 * @return The person who won, if the game is completed. Otherwise null.
	 */
	public Person whoWon();
	/**
	 * Returns the number of people playing in the multiplayer game
	 * @return the number of players
	 */
	public int getNumberOfPlayers();
}
