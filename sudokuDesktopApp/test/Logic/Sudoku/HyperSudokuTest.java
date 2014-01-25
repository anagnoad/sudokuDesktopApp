/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Sudoku;

import java.util.Arrays;
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
public class HyperSudokuTest {
    
    private HyperSudoku puzzle;
    
    public HyperSudokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        puzzle = new HyperSudoku();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkRules method, of class ClassicSudoku, per line.
     */
    @Test
    public void testCheckRulesPerLine() {
       puzzle.setCell(3, 0, 0);
       assertFalse(puzzle.setCell(3, 0, 6));  
    }
    /**
     * Test of checkRules method, of class ClassicSudoku, per line.
     */
    @Test
    public void testCheckRulesPerColumn() {
       puzzle.setCell(3, 0, 0);
       assertFalse(puzzle.setCell(3, 6, 0));
    }
    /**
     * Test of checkRules method, of class ClassicSudoku, per line.
     */
    @Test
    public void testCheckRulesPerBlock() {
       puzzle.setCell(3, 0, 0);
       assertFalse(puzzle.setCell(3, 2, 2));
    }
    
    /**
     * Test of checkRules method, of class ClassicSudoku, per line.
     */
    @Test
    public void testCheckRulesPerInnerSudoku() {
       puzzle.setCell(3, 1, 1);
       assertFalse(puzzle.setCell(3, 3, 3));
    }


    /**
     * Test of returnHint method, of class HyperSudoku.
     */
    @Test
    public void testReturnHint() {
        puzzle.setCell(3, 1, 1);
        puzzle.setCell(1, 2, 2);
        puzzle.setCell(5, 1, 5);
        puzzle.setCell(4,3,2);
        int[] exp = new int[]{2,6,7,8,9};
        int[] hints = puzzle.returnHint(new Coord_2D(3,3));
        assertTrue(Arrays.equals(hints, hints));
    }
    
}
