/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.IO;

import Logic.Sudoku.BaseGame;
import Logic.Sudoku.ClassicSudokuGame;
import Logic.Users.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anthony
 */
public class IOTest {
    
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
//    /**
//     * Test of readFromFile method, of class IO.
//     */
//    @Test
//    public void testReadFromFile() {
//        System.out.println("readFromFile");
//        String filename = "";
//        BaseGame gameLoadedFromFile = null;
//        boolean expResult = false;
//        boolean result = IO.readFromFile(filename, gameLoadedFromFile);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of saveToFile method, of class IO.
     */
    @Test
    public void testSaveToFile() {
        ClassicSudokuGame game = new ClassicSudokuGame();
        System.out.println("saveToFile");
        String filename = "";
        BaseGame gameToSave = null;
        boolean expResult = false;
        boolean result = IO.saveToFile(filename, gameToSave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
