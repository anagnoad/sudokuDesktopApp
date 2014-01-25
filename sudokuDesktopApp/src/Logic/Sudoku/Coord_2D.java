package Logic.Sudoku;

/**
 * Basic class for 2-d points in the sudoku.
 * e.g. Cell 4 of Row 1, would be x = 1; y = 4;
 * @author Anthony
 *
 */
public class Coord_2D {
    /**
     * The x-dimension of the coordinates.
     */
    public int x;
    /**
     * The y-dimension of the coordinates.
     */
    public int y;

    /**
     * Constructor that initializes the coordinates to (0,0)
     */
    public Coord_2D()
    {
            this.x = 0;
            this.y = 0;
    }

    /**
     * Constructor that initializes the coordinates to given (x,y) points
     * @param x the x-dimension of the coordinates
     * @param y the y-dimension of the coordinates
     */
    public Coord_2D(int x, int y)
    {
            this.setXY(x, y);
    }

    /**
     * Setter for modifying the (x,y) point. 
     * @param x the x-dimension of the coordinates
     * @param y the y-dimension of the coordinates
     */
    public void setXY(int x, int y)
    {
            this.x = x;
            this.y = y;
    }
}
