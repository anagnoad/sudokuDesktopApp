package Logic.Sudoku;

import Logic.Users.Person;


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
            this.isAnonymous = true;
    }

    /**
     * Constructor that takes the Person who plays the Sudoku as parameter.
     * @param p the Person that plays the Sudoku puzzle.
     */
    public HyperSudokuGame(Person p)
    {
            this();
            players.add(p);
            this.isAnonymous = false;
    }

    /**
     * Constructor taking as parameters the array of the sudoku to load and its id.
     * @param array the array of the sudoku
     * @param id the id of the puzzle.
     */
    public HyperSudokuGame(int[][] array, String id)
    {
        this();
        this.mySudoku = new HyperSudoku(array,id);
    }
    
    /**
     * Constructor taking as parameters the array to load for the sudoku, its id
     * and the Person who is playing it.
     * @param array the array of the sudoku puzzle.
     * @param id the id of the sudoku being played.
     * @param p the Person who is playing the sudoku.
     */
    public HyperSudokuGame(int[][] array, String id, Person p)
    {
        this();
        this.mySudoku = new HyperSudoku(array,id);
        this.players.add(p);
        this.isAnonymous=false;
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
    
    /**
     * Method returning current sudoku status
     * @return FINISHED, NOTFINISHED or FAILED.
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
     * Used mainly from the GUI, and in order to determine whether the user has the
     * right to change the value 
     * of a particular cell or not.
     * @return the 2d boolean array of the editable cells.
     */
    public boolean[][] getIsEditableMatrix()
    {
        return this.mySudoku.isEditableArray;
    }
}
