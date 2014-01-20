package Logic.Users;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a player inside the game. With this class, it is able to login and have your stats saved.
 * @author Steve
 *
 */
public class Person {
    /* -------------- Member vars --------------*/
    /**
     * Unique identifier of each object. Takes its value from the hashValue of the object.
     */
    protected int id; // this has to be present in order to differentiate between different users with the same nickname.
    /**
     * String representing the given name by the user
     */
    protected String nickname;
    /**
     * Saves the IDs of the sudokus having been solved by the user
     */
    protected HashSet<Integer> sudokuSolved;
    /**
     * Saves the statistics of the current user.
     */
    protected Stats statistics;
    /**
     * Saves the timestamp of the last time the user logged in.
     * Used to present the difference to the user between diffrerent users with the same nickname.
     */
    protected Date lastLoggedIn; // will use date in order to distinguish different users with the same nickname.

    /*-------------- Methods -------------*/
    //ctor
    /**
     * Default ctor.
     * Instantiates member variables.
     */
    public Person()
    {
            this.id = this.hashCode();
            this.nickname = null;
            this.sudokuSolved = new HashSet<Integer>();
            this.statistics = new Stats();
            this.lastLoggedIn = new Date(); // gets the current date. The first time of login is when the user is created.
    }
	
    /**
     * Ctor accepting nickname.
     * Calls the default ctor and set the nickname to the given value.
     * @param nickname
     */
    public Person(String nickname)
    {
            this(); // calls the ctor without arguments
            this.nickname = nickname; // assign the given nickname
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
            return false;
        else if (!(obj instanceof Person))
            return false;
        else if (this.hashCode() !=obj.hashCode())
            return false;
        else
            return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nickname);
        hash = 97 * hash + Objects.hashCode(this.lastLoggedIn);
        return hash;
    }

    @Override
    public String toString() // this is implemented to show the results of a search in a JList
    {
        StringBuilder toBeReturned = new StringBuilder();
        toBeReturned.append(this.nickname);
        toBeReturned.append(" ");
        toBeReturned.append(this.lastLoggedIn.toString());
        return toBeReturned.toString();
    }
    // setters
    /**
     * Changes the nickname of the user to the specified value.
     * @param nickname
     */
    public void setNickname(String nickname)
    {
            this.nickname = nickname;
    }
    /**
     * Increments the number of victories of the user by 1.
     * @return
     */
    public int incrementVictories()
    {
            return ++this.statistics.numberOfVictories;
    }
    /**
     * Increments the number of defeats of the user by 1.
     * @return
     */
    public int incrementDefeats()
    {
            return ++this.statistics.numberOfDefeats;
    }
    /**
     * Adds a sudoku puzzle to the solved ones.
     * @param idOfSudokuSolved
     * @return true if added successfully, false if already in
     */
    public boolean addSudokuSolved(int idOfSudokuSolved)
    {
            return this.sudokuSolved.add(Integer.valueOf(idOfSudokuSolved));
    }
    /**
     * Updates the timestamp of last login.
     */
    public void updateTimeLastLoggedIn()
    {
            this.lastLoggedIn = new Date(); // get the current time
    }


    // getters 
    /**
     * Returns the unique identifier of the user.
     * @return the unique identifier of the user
     */
    public int getId()
    {
            return this.id;
    }

    /**
     * Returns the nickname of the user.
     * @return the user's nickname
     */
    public String getNickname()
    {return this.nickname;}

    /**
     * Returns if the user has Solved a specific sudoku puzzle
     * @param SudokuId.
     * @return true if solved, false otherwise
     */
    public boolean hasSolved(Integer SudokuId)
    {
            if (this.sudokuSolved.contains(Integer.valueOf(SudokuId)))
                    return true;
            else
                    return false;
    }

    /**
     * Returns the timestamp of last login.
     * @return last login date
     */
    public Date getTimeLastLoggedIn()
    {
            return this.lastLoggedIn;
    }

    /**
     * Returns the number of victories of the user.
     * @return the number of victories
     */
    public int getVictories()
    {
            return this.statistics.numberOfVictories;
    }

    /**
     * Returns the number of defeats of the user.
     * @return the number of defeats
     */
    public int getDefeats()
    {
            return this.statistics.numberOfDefeats;
    }
}
/**
* Container class of Player stats
* @author Steve
*
*/
class Stats // implemented as a class because Java does not have native support of structs
{
    /**
     * Represents the sum of victories of the current player
     */
    public int numberOfVictories;
    /**
     * Represents the sum of defeats of the current player
     */
    public int numberOfDefeats;
}