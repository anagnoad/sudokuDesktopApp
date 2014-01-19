package Logic.Sudoku;

/**
 * Basic class for 2-d points in the sudoku.
 * e.g. Cell 4 of Row 1, would be x = 1; y = 4;
 * @author Anthony
 *
 */
public class Coord_2D {
	public int x;
	public int y;
	
	public Coord_2D()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Coord_2D(int x, int y)
	{
		this.setXY(x, y);
	}
	
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
