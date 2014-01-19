package Logic.Sudoku;

public abstract class BasePuzzle {
	/* --------------- Member vars ----------------*/
	/**
	 * id of the current puzzle. Must be unique.
	 */
	protected int id;
	/**
	 * The x-dimension size of the matrix representing the game.
	 */
	private int dimX;
	/**
	 * The y-dimension size of the matrix representing the game.
	 */
	private int dimY;
	/**
	 * The matrix representing the game played.
	 */
	protected int[][] matrix;
	
	/* ---------- Methods ---------- */
	
	/** Method that checks the matrix's current state in the game.
	 * 
	 * @return true if completed;
	 * false otherwise.
	 */
	public abstract boolean isCompleted();
	
	/**
	 * Makes the necessary checks when inserting a value in the matrix.
	 * Checks dimensions, input and rules of the puzzle.
	 * @param value
	 * @param x
	 * @param y
	 * @return true if valid; false otherwise.
	 */
	public boolean checkValue(int value, int x, int y)
	{
		return dimensionCheck(x,y) && inputCheck(value) && checkRules(value,x,y); 
	}
	// calls inputCheck, dimensionCheck and maybe others, depending on the puzzle
	
	/**
	 * Makes the necessary checks, based on the rules of the puzzle.
	 * @param value
	 * @param x
	 * @param y
	 * @return true if valid; false otherwise.
	 */
	protected abstract boolean checkRules(int value, int x, int y); // called by hints() and checkValue()
	
	/**
	 * Makes the necessary checks on the value to be inserted in the matrix.
	 * It's body depends on the rules of the game.
	 * @param value
	 * @return true if valid; false otherwise.
	 */
	protected abstract boolean inputCheck(int value); // depends on the game's rules
	
	/**
	 * Makes the necessary bound checks for the position in the matrix, when inserting a value.
	 * @param x
	 * @param y
	 * @return true if valid; false otherwise.
	 */
	protected boolean dimensionCheck(int x, int y) // checking if the input ecxeeds the dimensions of the puzzle
	{
		if (x<0 || y<0 || x>=dimX || y>=dimY)
		{
			// invalid dimensions
			return false;
		}
		return true;
	}
	
	// setters
	/**
	 * Sets the value of a cell.
	 * @param value
	 * @param x
	 * @param y
	 * @return true if valid; false otherwise.
	 */
	
	public boolean setCell(int value, int x, int y) //implemented methods in abstract class can call abstract methods, whose body will be called from child class which implements it. 
	{
		if (checkValue(value, x, y))
		{
			this.matrix[x][y] = value;
			return true;
		}
		return false;
	}
	
	/* for extendibility purposes */
	/**
	 * Sets the x-dimension of the matrix.
	 * @param x
	 */
	protected boolean setDimX(int x)
	{
		if (x>=0 && Math.sqrt(x)%1==0 )
		{
			this.dimX = x;
			return true;
		}
		return false;
	}
	
	/**
	 * Sets the y-dimension of the matrix.
	 * @param y
	 */
	protected boolean setDimY(int y)
	{
		if (y>=0 && Math.sqrt(y)%1 == 0)
		{
			this.dimY = y;
			return true;
		}
		return false;
	}
	/* --------------------------------- */
	
	// getters
	/**
	 * Gets the x-dimension of the matrix.
	 * @return x-dimension of matrix[][]
	 */
	public int getX()
	{
		return this.dimX;
	}
	
	/**
	 * Gets the y-dimension of the matrix
	 * @return y-dimension of matrix[][]
	 */
	public int getY()
	{
		return this.dimY;
	}
	
	/**
	 * Gets the Matrix representing the game.
	 * @return matrix[][]
	 */
	public int[][] getMatrix()
	{
		return this.matrix;
	}
	
	// %%%%%%%%%%%%% NOT FOR LOADING SAVED STATES OF SUDOKU GAMES!!! 
	// %%%%%%%%%%%%% JUST FOR NEW ONES!!!
	// Called from constructor.
	
	/**
	 * Loads loaded new games of the application.
	 * 
	 * @param array
	 * @return
	 */
	public abstract boolean loadFromArray(int[][] array);
	
	
	/**
	 * Gives the possible inputs for a specific cell. Depends on the game.
	 * @param cell
	 * @return all the possible inputs for cell
	 */
	public abstract int[] returnHint(Coord_2D cell);
}
