package Logic.Users;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a player inside the game.
 * @author Steve
 *
 */
public class Person implements Serializable{
    /* -------------- Member vars --------------*/
    /**
     * Unique identifier of each object. 
     * Takes its value from the hashValue of the object.
     */
    protected int id; // this has to be present in order to differentiate between different users with the same nickname.
    
    /**
     * String representing the given name by the user
     */
    protected String nickname;
    
    /**
     * Saves the IDs of the sudokus having been solved by the user
     */
    protected HashSet<String> sudokuSolved;
    
    /**
     * Saves the statistics of the current user.
     */
    protected Stats statistics;
    /**
     * Saves the timestamp of the user's creation.
     * Used to present the difference to the user between different users with the same nickname.
     */
    protected Date dateCreated; // will use date in order to distinguish different users with the same nickname.
    
    
    
    
    /*-------------- Methods -------------*/
    /**
     * Default ctor.
     * Instantiates member variables.
     */
    public Person()
    {
            this.nickname = null;
            this.sudokuSolved = new HashSet<>();
            this.statistics = new Stats();
            this.dateCreated = new Date(); // gets the current date. The first time of login is when the user is created.
            this.id = this.hashCode(); // the order matters here.
    }
	
    /**
     * Ctor accepting nickname.
     * Calls the default ctor and set the nickname to the given value.
     * @param nickname The name the user gives to identify themselves
     */
    public Person(String nickname)
    {
            this(); // calls the ctor without arguments
            this.nickname = nickname; // assign the given nickname
            this.id = this.hashCode();
    }

    /**
     * Overrides the equals class needed for the Database searching.
     * @param obj the object to compare with.
     * @return true if equal, false otherwise
     */
    @Override
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

    /**
     * Overrides the hashCode() method.
     * Uses nickname and date of creation as sources.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nickname);
        hash = 97 * hash + Objects.hashCode(this.dateCreated);
        return hash;
    }

    /**
     * Overrides the toString() method.
     * @return the nickname and the date of creation concatenated in a string.
     */
    @Override
    public String toString() // this is implemented to show the results of a search in a JList
    {
        StringBuilder toBeReturned = new StringBuilder();
        toBeReturned.append(this.nickname);
        toBeReturned.append(" ");
        toBeReturned.append(this.dateCreated.toString());
        return toBeReturned.toString();
    }
    
    
    
    // setters
    /**
     * Changes the nickname of the user to the specified value.
     * @param nickname the new nickname.
     */
    public void setNickname(String nickname)
    {
            this.nickname = nickname;
    }
    
    /**
     * Increments the number of victories of the user by 1.
     * @return the incremented value.
     */
    public int incrementVictories()
    {
            return ++this.statistics.numberOfVictories;
    }
    
    /**
     * Increments the number of defeats of the user by 1.
     * @return the incremented value.
     */
    public int incrementDefeats()
    {
            return ++this.statistics.numberOfDefeats;
    }
    
    
    /**
     * Add the id of the sudoku passed in the set of solved sudokus.
     * @param idOfSudokuSolved the id of the sudoku solved.
     * @return true if added, false otherwise.
     */
    public boolean addSudokuSolved(String idOfSudokuSolved)
    {
            return this.sudokuSolved.add(idOfSudokuSolved);
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
     * Returns if the user has Solved a specific sudoku puzzle.
     * @param the id of the sudoku in the query.
     * @return true if solved, false otherwise.
     */
    public boolean hasSolved(int SudokuId)
    {
            if (this.sudokuSolved.contains(String.valueOf(SudokuId)))
                    return true;
            else
                    return false;
    }

    /**
     * Returns the timestamp of creation.
     * @return the timestamp of the user creation.
     */
    public Date getTimeLastLoggedIn()
    {
            return this.dateCreated;
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
    
    public int getGamesPlayed()
    {
        return this.sudokuSolved.size()+this.getDefeats()+this.getVictories();
    }
    
    public HashSet<String> getSudokusSolved()
    {
        return this.sudokuSolved;
    }
    
    /** 
     * Resets the statistics of the player.
     */
    public void reset()
    {
        this.sudokuSolved = new HashSet<>();
        this.statistics.numberOfDefeats = 0;
        this.statistics.numberOfVictories = 0;
    }
}
/**
* Container class of Player stats
* @author Steve
*
*/
class Stats implements Serializable // implemented as a class because Java does not have native support of structs
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