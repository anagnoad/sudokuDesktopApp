package Logic.Sudoku;

import Logic.Users.Person;
import java.util.Iterator;
import java.util.Random;


/**
 * Class representing the Duidoku game.
 * Can be extended to work with more than one player.
 * @author Steve
 *
 */
public class DuidokuGame    extends BaseGame // this can be easily extended to be played with more than one player. It's constructor constrained for now.
                                               implements Multiplayer
{
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
     * Member variable showing if you play against another player or against the cpu.
     */
    protected boolean computerPlays;
    
    /**
     * Member variable showing the number of players of the game.
     */
    protected int numberOfPlayers;
    
    /**
     * Random generator in case we play against the computer.
     */
    private Random randGenerator;
    
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
     * Ctor initializing the game vs. the cpu
     * @param player the player of the game
     */
    public DuidokuGame(Person player)
    {
        this();
        this.players.add(player);
        this.computerPlays = true;
        this.numberOfPlayers = 2;
        this.randGenerator = new Random();
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
            this.computerPlays = false;
            this.numberOfPlayers = this.players.size();
    }

    @Override
    public boolean addNumber(int value, Coord_2D coordinates) {
            boolean isValid = mySudoku.setCell(value, coordinates.x, coordinates.y);
            if (isValid)
                    stepCounter++;
            return isValid;
    }
    
    public boolean computerAddNumber(){
        int value;
        Coord_2D coords;
        if (!this.isCompleted())
        {
            do
            {
                value = this.randGenerator.nextInt(9)+1; // it cannot put 0
                coords = new Coord_2D(this.randGenerator.nextInt(9), this.randGenerator.nextInt(9));
            }
            while (!addNumber(value, coords));
            return true;
        }
        return false;
    }


    @Override
    public Person whoWon() { // returns the winner for updating statistics
        
            if (this.isCompleted())
                if (!this.computerPlays && !this.isAnonymous)
                    return this.players.get(this.stepCounter%this.numberOfPlayers); // this will not work on an anonymous game
            
            return null;
    }

    @Override
    public int getNumberOfPlayers() {
            return this.numberOfPlayers;
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

    @Override
    public boolean onQuitGame(boolean toSave)
    {
        boolean tempRes = super.onQuitGame(toSave);
       // update stats
        if (!this.isAnonymous && this.isCompleted())
        {
            Person winner = this.whoWon();
            winner.incrementVictories();
            Iterator<Person> it = players.iterator();
            while (it.hasNext())
            {
                Person temp = it.next();
                if (temp!=winner)
                    temp.incrementDefeats();
            }
        }
        return tempRes;
    }
}
