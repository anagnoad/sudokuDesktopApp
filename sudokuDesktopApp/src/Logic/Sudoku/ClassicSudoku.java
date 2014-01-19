package Logic.Sudoku;

import java.util.HashSet;
import java.util.Iterator;

public class ClassicSudoku extends BasePuzzle {
	private boolean [][] isEditableArray; //inner checking of this
	public TypeOfGame type; // is needed in order to know with smaller code in which class we are in.
	
	//ctor
	/**
	 * ctor
	 * Initializing sudoku's variables.
	 */
	public ClassicSudoku()
	{
		this.setDimX(9);
		this.setDimY(9);
		matrix = new int[getX()][getY()];
		isEditableArray = new boolean[getX()][getY()];
		this.id = this.hashCode();
		this.type = TypeOfGame.CLASSIC;
		
		//DEBUG ONLY
		//isEditableArray = new boolean[9][9];
		for (int i=0; i<getX(); i++)
		{
			for(int j=0; j<getY(); j++)
			{
				isEditableArray[i][j] = true;
			}
		}
	}
	
	/**
	 * Constructor taking a sudoku matrix as a parameter, so as to load it on start.
	 * @param arrayToLoad
	 */
	public ClassicSudoku(int[][] arrayToLoad)
	{
		this();
		loadFromArray(arrayToLoad);
	}
	
	public boolean isCompleted()
	{
		sudokuStatus status = this.getSudokuStatus();
		switch(status)
		{
		case FINISHED:
			return true;
		case FAILED:
			return false;
		case NOTFINISHED:
			return false;
		}
		return false; // this won't be executed anyway.
	}
	
	public sudokuStatus getSudokuStatus()
	{
		boolean flag = false;
		for (int i=0; i<this.getX(); i++)
			for(int j=0; j<this.getY(); j++)
				if (matrix[i][j] ==0) // 0 representing empty cell
				{
					if (returnHint(new Coord_2D(i,j)).length == 0)
						return sudokuStatus.FAILED;
					return sudokuStatus.NOTFINISHED;
				}	
		return sudokuStatus.FINISHED;
	}
	
	@Override
	public boolean checkRules(int value, int x, int y)
	{
		int rootDimX = (int) Math.sqrt(getX());
		int rootDimY = (int) Math.sqrt(getY());
		
		if (value==0)
			return true;
		
		if(!isEditableArray[x][y])
			return false;
		
		for (int i=0;i<getX();i++)
		{
			if (matrix[i][y] == value)
				return false;
		}
		
		for(int i=0; i<getY(); i++)
		{
			if (matrix[x][i] == value)
				return false;
		}
		
		int squareX = x / rootDimX;
		int squareY = y / rootDimY;
		
		int X = squareX* rootDimX;
		int Y = squareY* rootDimY;
		
		for(int i=0;i<rootDimX;i++)
		{
			for (int j=0;j<rootDimY;j++)
			{
				if (X+i == x || Y+j == y)
					continue;
				if (matrix[X+i][Y+j] == value)
					return false;
			}
		}
		return true;
	}
	
	@Override
	protected boolean inputCheck(int value)
	{
		return value<=Math.max(getX(),getY()) && value>=0; // Antonis: Changed to max(dimX, dimY)
		// Steve: changed 9-->dimX and value>=0, which means deletion
	}
	
	public int[] returnHint(Coord_2D cell)
	{
		int x = cell.x;
		int y = cell.y;
		int rootDimX = (int) Math.sqrt(getX());
		int rootDimY = (int) Math.sqrt(getY());
		
		HashSet<Integer> allValues = new HashSet<Integer>();
		for(int i=1;i<=Math.max(getX(),getY()) ;i++)
		{
			allValues.add(i);
		}
		HashSet<Integer> valuesFound = new HashSet<Integer>();
		
		for (int i=0;i<getX();i++)
		{
			if (matrix[i][y] != 0)
				valuesFound.add(matrix[i][y]);	
		}
		for (int i=0; i<getY(); i++)
		{
			if (matrix[x][i] != 0)
				valuesFound.add(matrix[x][i]);
		}
		int squareX = x / rootDimX;
		int squareY = y / rootDimY;
		
		int X = squareX* rootDimX;
		int Y = squareY* rootDimY;
		
		for(int i=0;i<rootDimX;i++)
		{
			for (int j=0;j<rootDimY;j++)
			{
				if (X+i == x || Y+j == y)
					continue;
				if (matrix[X+i][Y+j] != 0)
					valuesFound.add(matrix[X+i][Y+j]);
			}
		}
		allValues.removeAll(valuesFound);
		int[] toBeReturned = new int[allValues.size()];
		int counter = 0;
		Iterator i = allValues.iterator();
		while (i.hasNext())
		{
			toBeReturned[counter] = (Integer) i.next();
			counter++;
		}
		return toBeReturned;
	}

	@Override
	public boolean loadFromArray(int[][] array) { // this function is the same for all the child classes
		if (this.isValidArray(array))
		{
			this.matrix = array;
			for (int i = 0;i<getX();i++)
				for (int j=0;j<getY();j++)
				{
					if (this.matrix[i][j] !=0)
						this.isEditableArray[i][j] = false;
					else
						this.isEditableArray[i][j] = true;
				}
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Check if the matrix loaded from file is indeed a valid sudoku.
	 * @param arrayToCheck
	 * @return true if the matrix represents a playable sudoku, false otherwise.
	 */
	protected boolean isValidArray(int[][] arrayToCheck) // this function is the same for all the child classes
	{
		// there may be needed checks for arrayTocheck dimensions
		for (int i =0;i<getX();i++)
		{
			for (int j=0;j<getY();j++)
			{
				try {
				if (!this.checkRules(arrayToCheck[i][j], i, j))
					return false;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					// handle the exception here ...
				}
			}
		}
		return true;
	}
}
