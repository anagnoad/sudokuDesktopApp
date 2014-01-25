package Logic.IO;

import Logic.Sudoku.BaseGame;
import Logic.Sudoku.Coord_2D;
import Logic.Sudoku.TypeOfGame;
import static Logic.Sudoku.TypeOfGame.CLASSIC;
import static Logic.Sudoku.TypeOfGame.DUIDOKU;
import static Logic.Sudoku.TypeOfGame.HYPERDOKU;
import Logic.Users.PersonDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import sudokudesktopapp.GlobalConstants;


public class IO {

    // Remember that Android is using Java 6. You cannot use the try(Reader) ... catch syntax.
    // Remember to close the streams opened for files.

    /**
     * Load the saved Database from the specified file.
     * @param filename The filename containing the Database
     * @return The PersonDB read from the file, if found, otherwise false.
     */
    static public PersonDB loadPlayers(String filename)
    {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));){
                    return (PersonDB) input.readObject();
            } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    System.err.println("Wrong class exception.");
                    e.printStackTrace();
                    return null;
            } 
            catch (StreamCorruptedException e) {
                    System.err.println("Stream corrupted exception raised while loading the PersonDB");
                    e.printStackTrace();
                    return null;
            } catch (FileNotFoundException e) {
                System.err.println("File not found while loading the PersonDB");
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                System.err.println("General IO Exception while loading the PersonDB");
                    e.printStackTrace();
                    return null;
            }

    }
    /**
     * Save the current player database to the specified file.
     * @param filename the filename to which the database will be saved.
     * @param playersDB the database to be saved
     * @return true if saved, false otherwise
     */
    static public boolean savePlayers(String filename, PersonDB playersDB)
    {
            try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
                    output.writeObject(playersDB);
            } catch (FileNotFoundException e) {
                    System.err.println("File not found.");
                    e.printStackTrace();
                    return false;
            } catch (IOException e) {
                    System.err.println("General IO Exception while saving the PersonDB");
                    e.printStackTrace();
                    return false;
            }
            return true;
    }

    /**
     * Load an incomplete pre-saved sudoku from the file specified.
     * The file should be saved in text format and will be implementation unaware.
     * The delimeter of the sudoku value will be a " " for elements in the same line and %n for different lines.
     * @param filename the filename of the sudoku file to load
     * @param type the type of the sudoku to load [CLASSIC, HYPERDOKU, DUIDOKU]
     * @param array the array in which to save the matrix of the sudoku read.
     * @return 
     */
    static public boolean loadSudokuFromFile(String filename, TypeOfGame type, int[][] array) throws NoSuchFieldException
    {
            Coord_2D dimensions = new Coord_2D();
            // Set the correct dimensions according to the type of sudoku read from file.
            switch (type)
            {
            case CLASSIC:
                    // read a 9x9 matrix from a file
                    // note that there is no break on purpose. The same code is executed, whether a classic or a hyper sudoku is being
                    // loaded
            case HYPERDOKU:
                    dimensions.setXY(9, 9);
                    break;
            case DUIDOKU: // decided to implement this in order to raise the difficulty for the players of this type of game
                    dimensions.setXY(4, 4);
                    break;
            default:
                    throw new NoSuchFieldException();
            }

            // Read the file
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new 
                            File(GlobalConstants.RESOURCES_PATH+filename)));){
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
            } catch (FileNotFoundException e) {
                System.err.println("File not found while loading presaved sudoku");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                System.err.println("General IO exception while loading presaved sudoku");
                e.printStackTrace();
                return false;
            }
            return true;
    }

    /**
     * Reads saved game from file.
     * @param filename
     * @param gameLoadedFromFile
     * @param appContext
     * @return
     */
    public static BaseGame readFromFile(String filename)
    {
        BaseGame gameLoadedFromFile = null;
            try {
                    ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
                    try {
                            gameLoadedFromFile = (BaseGame) input.readObject(); // at this time, you don't know the type of the game
                    } catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            return null;
                    }
                    input.close(); // important!!
            } catch (StreamCorruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
            } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
            }

            return gameLoadedFromFile;
    }

    /**
     * Saves current game to file.
     * @param filename
     * @param gameToSave
     * @param appContext
     * @return
     */
    static public boolean saveToFile(String filename, BaseGame gameToSave)
    {
            try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
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
