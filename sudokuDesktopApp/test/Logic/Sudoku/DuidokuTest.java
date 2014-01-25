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
public class DuidokuTest {
    
    Duidoku g;
    public DuidokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = new Duidoku();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCell method, of class Duidoku.
     */
    @Test
    public void testSetCell() {
        
    }

    /**
     * Test of checkRules method, of class Duidoku.
     */
    @Test
    public void testCheckRulesPerBlock() {
        g.setCell(1, 0, 0);
        assertFalse(g.checkRules(1, 1, 1));
    }

    /**
     * Test of checkRules method, of class Duidoku.
     */
    @Test
    public void testCheckRulesPerRow() {
        g.setCell(1, 0, 0);
        assertFalse(g.checkRules(1, 0, 2));
    }
    
    /**
     * Test of checkRules method, of class Duidoku.
     */
    @Test
    public void testCheckRulesPerColumn() {
        g.setCell(1, 0, 0);
        assertFalse(g.checkRules(1, 2, 0));
    }
    
    /**
     * Test of getSudokuStatus method, of class Duidoku.
     */
    @Test
    public void testGetSudokuStatus() {
        assertEquals(g.getSudokuStatus(), sudokuStatus.NOTFINISHED);
    }

    /**
     * Test of returnHint method, of class Duidoku.
     */
    @Test
    public void testReturnHint() {
        g.setCell(1, 0, 0);
        g.setCell(2, 1, 1);
        g.setCell(3, 2, 0);
        int[] exp = new int[]{4};
        int[] hints = g.returnHint(new Coord_2D(1,0));
    }
    
}
