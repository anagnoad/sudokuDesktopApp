/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.IO;

import Logic.Sudoku.BaseGame;
import Logic.Sudoku.ClassicSudokuGame;
import Logic.Sudoku.TypeOfGame;
import Logic.Users.Person;
import Logic.Users.PersonDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudokudesktopapp.GlobalConstants;

/**
 *
 * @author Anthony
 */
public class IOTest {
    private String GlobalVariables;
    
    public IOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void saveLoadPlayersDBTest()
    {
        PersonDB theDB = new PersonDB();
        theDB.addNewPerson("Stefanos");
        theDB.addNewPerson("Antonis");
        theDB.addNewPerson("Greg");
        
        if (!IO.savePlayers(GlobalConstants.PERSONDB_PATH_TESTING, theDB))
        {
            assertFalse(true);
        }
        
        PersonDB newDB = IO.loadPlayers(GlobalConstants.PERSONDB_PATH_TESTING);
        assertEquals(theDB, newDB);
    }
    
    @Test
    public void loadSudokuFromFIle()
    {
        // suppose that we have created a file containing the following puzzle
        /*
            1 0 0 0 0 0 0 0 0
            0 2 0 0 0 0 0 0 0
            0 0 3 0 0 0 0 0 0
            0 0 0 4 0 0 0 0 0
            0 0 0 0 5 0 0 0 0
            0 0 0 0 0 6 0 0 0
            0 0 0 0 0 0 7 0 0
            0 0 0 0 0 0 0 8 0
            0 0 0 0 0 0 0 0 9
        */
        
        int[][] sudokuToBeLoadedHere = new int[9][9];
        try {
            IO.loadSudokuFromFile(GlobalConstants.TESTING_PATH+"testSudokuArray.txt", TypeOfGame.CLASSIC, sudokuToBeLoadedHere);
        } catch (NoSuchFieldException ex) {
            System.err.println("Invalid type");
            int [][] modelArray = new int[9][9];
            for (int i=0;i<9;i++)
                for (int j=0;j<9;j++)
                {
                    if (i==j)
                        modelArray[i][j] = i;
                    else
                        modelArray[i][j] = 0;
                }
            assertArrayEquals(modelArray, sudokuToBeLoadedHere);
        }
        
    }
    
    
// Methods readFromFile and saveToFile will be tested in the relevant contexts.    

}
