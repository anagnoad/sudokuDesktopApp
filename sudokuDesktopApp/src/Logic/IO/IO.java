package Logic.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;



import com.example.sudokuapp.Logic.Sudoku.BaseGame;
import com.example.sudokuapp.Logic.Sudoku.ClassicSudoku;
import com.example.sudokuapp.Logic.Sudoku.ClassicSudokuGame;
import com.example.sudokuapp.Logic.Sudoku.Coord_2D;
import com.example.sudokuapp.Logic.Sudoku.Duidoku;
import com.example.sudokuapp.Logic.Sudoku.HyperSudoku;
import com.example.sudokuapp.Logic.Sudoku.TypeOfGame;
import com.example.sudokuapp.Logic.Users.PersonDB;

public class IO {

	// Remember that Android is using Java 6. You cannot use the try(Reader) ... catch syntax.
	// Remember to close the streams opened for files.
	
	
	static public boolean loadPlayers(String filename, PersonDB playersDB, Context appContext)
	{
		try {
			ObjectInputStream input = new ObjectInputStream(appContext.getApplicationContext().openFileInput(filename));
			playersDB = (PersonDB) input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	static public boolean savePlayers(String filename, PersonDB playersDB, Context appContext)
	{
		try {
			ObjectOutputStream output = new ObjectOutputStream(appContext.getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE));
			output.writeObject(playersDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Loads a presaved sudoku from internal memory
	 * @param filename
	 * @param type
	 * @param array
	 * @param appContext
	 * @return true if read successfully, false otherwise
	 */
	static public boolean loadSudokuFromFile(String filename, TypeOfGame type, int[][] array, Context appContext)
	{
		// the file should be saved in text format and will be implementation unaware.
		// we set a space char as the delimeter for each element and \n as a delimeter for different lines.
		// no supplementary checks have been implemented as to what the file may have.
		Coord_2D dimensions = new Coord_2D();
		switch (type)
		{
		case CLASSIC:
			// read a 9x9 matrix from a file
			// note that there is no break on purpose. The same code is executed, whether a classic or a hyper sudoku is being
			// loaded
			dimensions.setXY(9, 9);
		case HYPERDOKU:
			break;
		case DUIDOKU: // decided to implement this in order to raise the difficulty for the players of this type of game
			dimensions.setXY(4, 4);
			break;
		default:
			return false;
		}
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new 
			        File(appContext.getApplicationContext().getFilesDir()+File.separator+"MyFile.txt")));
			for (int i=0;i<dimensions.x;i++)
			{
				int[] lineElements = new int[9];
				int tempCounter = 0;
				for (String s : bufferedReader.readLine().split(" "))
				{
					lineElements[tempCounter] = Integer.parseInt(s);
					++tempCounter;
				}
				for (int j=0;j<dimensions.y;j++)
				{
					array[i][j] = lineElements[j];
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	// needs checking definitely
	/**
	 * Reads saved game from file.
	 * @param filename
	 * @param gameLoadedFromFile
	 * @param appContext
	 * @return
	 */
	static public boolean readFromFile(String filename, BaseGame gameLoadedFromFile, Context appContext)
	{
		try {
			ObjectInputStream input = new ObjectInputStream(appContext.getApplicationContext().openFileInput(filename));
			try {
				gameLoadedFromFile = (BaseGame) input.readObject(); // at this time, you don't know the type of the game
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			input.close(); // important!!
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Saves current game to file.
	 * @param filename
	 * @param gameToSave
	 * @param appContext
	 * @return
	 */
	static public boolean saveToFile(String filename, BaseGame gameToSave, Context appContext)
	{
		try {
			ObjectOutputStream output = new ObjectOutputStream(appContext.getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE));
			output.writeObject(gameToSave);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
}
