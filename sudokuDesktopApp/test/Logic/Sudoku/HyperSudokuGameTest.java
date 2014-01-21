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
public class HyperSudokuGameTest {
    
    private HyperSudokuGame g = new HyperSudokuGame();
    
    public HyperSudokuGameTest() {
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
    public void testingHintsPerColumn() {
            g = new HyperSudokuGame();
            g.addNumber(2, new Coord_2D(0,0));
            g.addNumber(3, new Coord_2D(0,2));
            int[] r = g.getHelp(new Coord_2D(3,0));
            assertTrue(Arrays.equals(r, new int[]{1,3,4,5,6,7,8,9}));
    }
    
    @Test
    public void testingHintsPerLine() {
            g = new HyperSudokuGame();
            g.addNumber(2, new Coord_2D(0,0));
            g.addNumber(3, new Coord_2D(0,2));
            int[] r = g.getHelp(new Coord_2D(0,3));
            assertTrue(Arrays.equals(r, new int[]{1,4,5,6,7,8,9}));
    }
    @Test
    public void testingHintsPerBlock() {
            g = new HyperSudokuGame();
            g.addNumber(2, new Coord_2D(0,0));
            g.addNumber(3, new Coord_2D(0,2));
            int[] r = g.getHelp(new Coord_2D(1,1));
            assertTrue(Arrays.equals(r, new int[]{1,4,5,6,7,8,9}));
    }
    @Test
    public void testingIfCompleted(){
            g = new HyperSudokuGame();
            g.addNumber(2, new Coord_2D(0,0));
            g.addNumber(3, new Coord_2D(0,2));
            assertFalse(g.isCompleted());
    }

    
}