package Logic.Sudoku;

import Logic.Users.Person;
import java.io.Serializable;

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
            this.isAnonymous = true;
    }

    /**
     * Constructor that takes as parameters the array of the puzzle and the puzzle's id.
     * @param array the 2D array of the puzzle
     * @param id the id of the puzzle
     */
    public ClassicSudokuGame(int[][] array, String id)
    {
            this();
            mySudoku = new ClassicSudoku(array,id);
    }
    
    /**
     * Constructor taking as parameters the array of the puzzle, the puzzle's id and the Person playing it.
     * @param array the 2D array of the puzzle
     * @param id the id of the puzzle
     * @param p the Person playing it.
     */
    public ClassicSudokuGame(int[][] array, String id, Person p)
    {
            this();
            mySudoku = new ClassicSudoku(array,id);
            this.players.add(p);
            this.isAnonymous = false;
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
            this.isAnonymous = false;
    }

    /**
     * Returns hints for a particular cell of the puzzle.
     * @param cell the coordinates of the cell that you would like help on.
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

    @Override
    public boolean isCompleted()
    {
            return this.mySudoku.isCompleted();
    }
    
    /**
     * Method returning current sudoku status: FINISHED, NOTFINISHED and FAILED.
     * @return the current status of sudoku.
     */
    public sudokuStatus getSudokuStatus() // this may go to an abstract class sudoku
    {
            return this.mySudoku.getSudokuStatus();
    }
    
    @Override
    public boolean onQuitGame(boolean toSave)
    {
        boolean tempRes = super.onQuitGame(toSave);
        if (!this.isAnonymous && this.isCompleted())
        {
            this.players.get(0).addSudokuSolved(this.mySudoku.id);
        }
        return tempRes;
    }
    
    /**
     * Function returning the value of the sudoku in a particular cell [i,j]
     * @param i the 'x' coordinate of the cell
     * @param j the 'y' coordinate of the cell
     * @return value in the sudoku puzzle.
     */
    public int getMatrixValue(int i, int j)
    {
        return this.mySudoku.getMatrix()[i][j];
    }
    
    /**
     * Function returning the 2D array of editable cells.
     * Used mainly from the GUI, and in order to determine whether the user has the right to change the value 
     * of a particular cell or not.
     * @return the 2d boolean array of the editable cells.
     */
    public boolean[][] getIsEditableMatrix()
    {
        return this.mySudoku.isEditableArray;
    }
}
