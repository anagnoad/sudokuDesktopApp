/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Sudoku;

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
public class HyperSudokuGame2Test {
    
    public HyperSudokuGame2Test() {
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

    /**
     * Test of getHelp method, of class HyperSudokuGame.
     */
    @Test
    public void testGetHelp() {
        System.out.println("getHelp");
        Coord_2D cell = null;
        HyperSudokuGame instance = new HyperSudokuGame();
        int[] expResult = null;
        int[] result = instance.getHelp(cell);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNumber method, of class HyperSudokuGame.
     */
    @Test
    public void testAddNumber() {
        System.out.println("addNumber");
        int value = 0;
        Coord_2D coordinates = null;
        HyperSudokuGame instance = new HyperSudokuGame();
        boolean expResult = false;
        boolean result = instance.addNumber(value, coordinates);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCompleted method, of class HyperSudokuGame.
     */
    @Test
    public void testIsCompleted() {
        System.out.println("isCompleted");
        HyperSudokuGame instance = new HyperSudokuGame();
        boolean expResult = false;
        boolean result = instance.isCompleted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSudokuStatus method, of class HyperSudokuGame.
     */
    @Test
    public void testGetSudokuStatus() {
        System.out.println("getSudokuStatus");
        HyperSudokuGame instance = new HyperSudokuGame();
        sudokuStatus expResult = null;
        sudokuStatus result = instance.getSudokuStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onQuitGame method, of class HyperSudokuGame.
     */
    @Test
    public void testOnQuitGame() {
        System.out.println("onQuitGame");
        boolean toSave = false;
        HyperSudokuGame instance = new HyperSudokuGame();
        boolean expResult = false;
        boolean result = instance.onQuitGame(toSave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrixValue method, of class HyperSudokuGame.
     */
    @Test
    public void testGetMatrixValue() {
        System.out.println("getMatrixValue");
        int i = 0;
        int j = 0;
        HyperSudokuGame instance = new HyperSudokuGame();
        int expResult = 0;
        int result = instance.getMatrixValue(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsEditableMatrix method, of class HyperSudokuGame.
     */
    @Test
    public void testGetIsEditableMatrix() {
        System.out.println("getIsEditableMatrix");
        HyperSudokuGame instance = new HyperSudokuGame();
        boolean[][] expResult = null;
        boolean[][] result = instance.getIsEditableMatrix();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
