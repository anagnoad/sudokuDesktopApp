package Logic.Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Class of HyperSudoku.
 * @author Anthony
 *
 */
public class HyperSudoku extends ClassicSudoku {

    /**
     * ArrayList that contains all cells that represent the start of an inner sudoku block.
     */
    private ArrayList<Coord_2D> innerSudokus; 	// saves the upper left corner's coordinates

    /**
     * Helper matrix that stores in which inner sudoku, every cell is.
     * Initializes at -1. Anything else (1,2,3,4) indicates the innersudoku in which the cell is.
     */
    private int[][] sudokuMatrix;

    /**
     * Default constructor. Creates for inner sudokus, with the following upper left corners:
     * (zero based, as in Coord_2D)
     * 1,1
     * 1,5
     * 5,1
     * 5,5 
     */
    public HyperSudoku()
    {
            this(new Coord_2D(1,1), new Coord_2D(1,5), new Coord_2D(5,1), new Coord_2D(5,5));
    }

    /**
     * Constructor taking a sudoku matrix as a parameter, so as to load it on start.
     * @param arrayToLoad
     */
    public HyperSudoku(int[][] arrayToLoad, String id)
    {
            this();
            loadFromArray(arrayToLoad);
                                    this.id = id;
    }

    /**
     * Constructor of HyperSudoku.
     * Requires 4 parameters of the inner sudokus' upper left corner.
     * @param topLeft
     * @param topRight
     * @param bottomRight
     * @param bottomLeft
     */
    public HyperSudoku(Coord_2D topLeft, Coord_2D topRight, Coord_2D bottomRight, Coord_2D bottomLeft)
    {
            sudokuMatrix = new int[getX()][getY()];
            innerSudokus = new ArrayList<Coord_2D>();
            innerSudokus.add(topLeft);
            innerSudokus.add(topRight);
            innerSudokus.add(bottomLeft);
            innerSudokus.add(bottomRight);
            if(!checkIfBlocksAreValid())
            {
                    throw new IllegalArgumentException();
            }
    }

    /**
     * Helper function that checks if everything is valid with the inner sudokus provided.
     * @return
     */
    private boolean checkIfBlocksAreValid()
    {
            int rootDimX = (int) Math.sqrt(getX());
            int rootDimY = (int) Math.sqrt(getY());

            for(int i=0;i<getX();i++)
            {
                    for(int j=0; j<getY(); j++)
                    {
                            sudokuMatrix[i][j] = -1; //initialization
                    }
            }
            for(int k=0; k<innerSudokus.size(); k++)
            {
                    Coord_2D cell = innerSudokus.get(k);
                    int x = cell.x;
                    int y = cell.y;
                    try
                    {
                            for(int i=0; i<rootDimX; i++)
                            {
                                    for(int j=0; j<rootDimY; j++)
                                    {
                                            if(sudokuMatrix[x+i][y+j] != -1)
                                            {
                                                    // if we get here that means that
                                                    // two of the innersudokus coincide..
                                                    // we wouldn't want this to happen, would we...?
                                                    return false; 
                                            }
                                            sudokuMatrix[x+i][y+j] = k; // storing which "innersudoku" this cell is on.
                                    }
                            }
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                            return false;
                    }
            }
            return true;

    }
    @Override
    public boolean checkRules(int value, int x, int y)
    {
        
            if(!isEditableArray[x][y])
                return false;
            
            if (value== 0)
            return true;
            int rootDimX = (int) Math.sqrt(getX());
            int rootDimY = (int) Math.sqrt(getY());

            if (!super.checkRules(value, x, y))
            {
                    return false;
            }
            if (sudokuMatrix[x][y] != -1) //is it a cell that requires further check?
            {
                    Coord_2D cell = innerSudokus.get(sudokuMatrix[x][y]); //getting the first cell of the inner sudoku
                    int X = cell.x;
                    int Y = cell.y;
                    for(int i=0;i<rootDimX;i++)
                    {
                            for (int j=0;j<rootDimY;j++)
                            {
                                    if (matrix[X+i][Y+j] == value) // does the value already exist?
                                            return false;
                            }
                    }
            }
            return true;
    }


    @Override
    public int[] returnHint(Coord_2D cell)
    {
            int rootDimX = (int) Math.sqrt(getX());
            int rootDimY = (int) Math.sqrt(getY());

            // Needs to be overriden because of further checks.
            int[] returnedFromClassic = super.returnHint(cell);
            HashSet<Integer> values = new HashSet<Integer>();
            for(int x: returnedFromClassic)
            {
                    values.add(x);
            }

            if(sudokuMatrix[cell.x][cell.y]!=-1)
            {
                Coord_2D firstCell = innerSudokus.get(sudokuMatrix[cell.x][cell.y]);
                int X = firstCell.x;
                int Y = firstCell.y;
                HashSet<Integer> toBeRemoved = new HashSet<Integer>();
                for(int i=0;i<rootDimX;i++)
                {
                        for (int j=0;j<rootDimY;j++)
                        {
                                if (matrix[X+i][Y+j] != 0)
                                        toBeRemoved.add(matrix[X+i][Y+j]);
                        }
                }
                values.removeAll(toBeRemoved);
            }
            int[] toBeReturned = new int[values.size()];
            int counter = 0;
            Iterator i = values.iterator();
            while (i.hasNext())
            {
                    toBeReturned[counter] = (Integer) i.next();
                    counter++;
            }
            return toBeReturned;
    }
}
