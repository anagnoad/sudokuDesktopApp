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
public class ClassicSudokuGame2Test {
    
    public ClassicSudokuGame2Test() {
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
     * Test of addNumber method, of class ClassicSudokuGame.
     */
    @Test
    public void testAddNumber() {
        System.out.println("addNumber");
        int value = 0;
        Coord_2D coordinates = null;
        ClassicSudokuGame instance = new ClassicSudokuGame();
        boolean expResult = false;
        boolean result = instance.addNumber(value, coordinates);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCompleted method, of class ClassicSudokuGame.
     */
    @Test
    public void testIsCompleted() {
        System.out.println("isCompleted");
        ClassicSudokuGame instance = new ClassicSudokuGame();
        boolean expResult = false;
        boolean result = instance.isCompleted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSudokuStatus method, of class ClassicSudokuGame.
     */
    @Test
    public void testGetSudokuStatus() {
        System.out.println("getSudokuStatus");
        ClassicSudokuGame instance = new ClassicSudokuGame();
        sudokuStatus expResult = null;
        sudokuStatus result = instance.getSudokuStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onQuitGame method, of class ClassicSudokuGame.
     */
    @Test
    public void testOnQuitGame() {
        System.out.println("onQuitGame");
        boolean toSave = false;
        ClassicSudokuGame instance = new ClassicSudokuGame();
        boolean expResult = false;
        boolean result = instance.onQuitGame(toSave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrixValue method, of class ClassicSudokuGame.
     */
    @Test
    public void testGetMatrixValue() {
        System.out.println("getMatrixValue");
        int i = 0;
        int j = 0;
        ClassicSudokuGame instance = new ClassicSudokuGame();
        int expResult = 0;
        int result = instance.getMatrixValue(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsEditableMatrix method, of class ClassicSudokuGame.
     */
    @Test
    public void testGetIsEditableMatrix() {
        System.out.println("getIsEditableMatrix");
        ClassicSudokuGame instance = new ClassicSudokuGame();
        boolean[][] expResult = null;
        boolean[][] result = instance.getIsEditableMatrix();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
