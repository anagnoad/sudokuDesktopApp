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
        this.computerPlays = true;
        this.randGenerator = new Random();
        this.players.add(new Person("CPU"));
    }
    
    /**
     * Ctor initializing the game vs. the cpu
     * @param player the player of the game
     */
    public DuidokuGame(Person player)
    {
        this();
        this.players.add(player);
        
    }

    /**
     * Helper function that is both called for user playing the duidoku
     * as well as the CPU.
     * @param value the value of the cell in which the current user will play.
     * @param coordinates the coordinates of the cell in which the user will play.
     * @return 
     */
    public boolean commonAddNumber(int value, Coord_2D coordinates) {
        boolean isValid = mySudoku.setCell(value, coordinates.x, coordinates.y);
        if (isValid)
        {
            stepCounter++;
            this.mySudoku.isEditableArray[coordinates.x][coordinates.y] = false;
        }
        return isValid;
    }
    
    /**
     * Needs to be overriden from basegame, since Duidoku is played against the CPU.
     * So, in every movement that is being taken, the computer makes one as well.
     * @param value the value of the cell that the user wants to play.
     * @param coordinates the coordinates of the cell
     * @return true if both players played succesfully, false otherwise.
     */
    @Override
    public boolean addNumber(int value, Coord_2D coordinates)
    {
        boolean flag = commonAddNumber(value, coordinates);
        if(!flag)
            return false;
        return computerAddNumber() || flag;
    }
    
    /**
     * Helper function that is being called from addNumber.
     * Ijn every movement that the user plays, the CPU has to
     * try to play as well. This is when this method is called.
     * 
     * @return true if the CPU could play in the puzzle; false otherwise.
     */
    public boolean computerAddNumber(){
        int value;
        Coord_2D coords;
        if (!this.isCompleted() && this.getSudokuStatus() != sudokuStatus.FAILED)
        {
            do
            {
                value = this.randGenerator.nextInt(9)+1; // it cannot put 0
                coords = new Coord_2D(this.randGenerator.nextInt(9), this.randGenerator.nextInt(9));
            }
            while (!commonAddNumber(value, coords));
            return true;
        }
        return false;
    }

    /**
     * Method that returns an array with all possible values for a particular cell
     * @param coords the coordinates for the asked cell.
     * @return an array containing all possible values.
     */
    public int[] getHelp(Coord_2D coords)
    {
        return mySudoku.returnHint(coords);
    }
    
    @Override
    public Person whoWon() { // returns the winner for updating statistics
        if(this.getSudokuStatus() == sudokuStatus.FINISHED)
        {
            return this.players.get(this.stepCounter%players.size());
        }
            
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

    @Override
    public boolean onQuitGame(boolean toSave)
    {
        boolean tempRes = super.onQuitGame(toSave);
       // update stats
        if (this.isCompleted())
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
    
    /**
     * Function that returns the value of a particular cell [i,j] in the sudoku matrix.
     * Is called mainly from the GUI.
     * @param i the x-coordinate of the cell.
     * @param j the y-coordinate of the cell.
     * @return 
     */
    public int getMatrixValue(int i, int j)
    {
        return this.mySudoku.getMatrix()[i][j];
    }
    
    /**
     * Function that returns the matrix containing the editable cells.
     * @return 2-D boolean matrix, containing which cells can be edited or not.
     */
    public boolean[][] getIsEditableMatrix()
    {
        return this.mySudoku.isEditableArray;
    }
    
}
