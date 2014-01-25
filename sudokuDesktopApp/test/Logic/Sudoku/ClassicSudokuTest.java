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
public class ClassicSudokuTest {
    
    private ClassicSudoku puzzle;
        
    public ClassicSudokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        puzzle = new ClassicSudoku();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isCompleted method, of class ClassicSudoku, when it is not.
     */
    @Test
    public void testIsCompletedWhenItIsNot() {
        assertFalse(puzzle.isCompleted());
    }

//    /**
//     * Test of isCompleted method, of class ClassicSudoku, when it is.
//     */
//    @Test
//    public void testIsCompletedWhenItIs() {
//        int[][] matrix = new int[9][9];
//        for(int i=0; i<9; i++)
//        {
//            for (int j = 0; j < 9; j++) 
//            {
//                matrix[i][j] = i*j + 1;
//            }
//        }
//        puzzle = new ClassicSudoku(matrix,String.valueOf(1));
//        assertTrue(puzzle.isCompleted());
//    }
    
//    /**
//     * Test of getSudokuStatus method, of a finished ClassicSudoku.
//     */
//    @Test
//    public void testGetSudokuStatusFinished() {
//        int[][] matrix = new int[9][9];
//        for(int i=0; i<9; i++)
//        {
//            for (int j = 0; j < 9; j++) 
//            {
//                matrix[i][j] = i*j + 1;
//            }
//        }
//        puzzle = new ClassicSudoku(matrix,String.valueOf(1));
//        assertEquals(puzzle.getSudokuStatus(), sudokuStatus.FINISHED);
//    }

    
    /**
     * Test of getSudokuStatus method, of an unfinished ClassicSudoku.
     */
    @Test
    public void testGetSudokuStatusNOTFinished() {
        assertEquals(puzzle.getSudokuStatus(), sudokuStatus.NOTFINISHED);
    }
    
    /**
     * Test of getSudokuStatus method, of a failed ClassicSudoku.
     */
    @Test
    public void testGetSudokuStatusFailed() {
        int[][] matrix = new int[9][9];
        for(int i=0; i<9; i++)
        {
            matrix[0][i] = i;
        }
        matrix[1][0] = 9;
        puzzle = new ClassicSudoku(matrix,String.valueOf(1));
        assertEquals(puzzle.getSudokuStatus(), sudokuStatus.FAILED);
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
     * Test of inputCheck method, of class ClassicSudoku.
     */
    @Test
    public void testInputCheck() {
       assertTrue(puzzle.inputCheck(2));
       assertFalse(puzzle.inputCheck(-2));
    }

    /**
     * Test of returnHint method, of class ClassicSudoku.
     */
    @Test
    public void testReturnHint() {
        puzzle.setCell(3, 0, 0);
        puzzle.setCell(1, 2, 2);
        puzzle.setCell(5, 1, 5);
        int[] exp = new int[]{2,4,6,7,8,9,};
        int[] hints = puzzle.returnHint(new Coord_2D(1,1));
        assertTrue(Arrays.equals(hints, hints));
    }

    /**
     * Test of loadFromArray method, of class ClassicSudoku.
     */
    @Test
    public void testLoadFromArray() {
        int[][] matrix = dummyMatrix();
        puzzle.loadFromArray(matrix);
        assertEquals(puzzle.getMatrix(), matrix);
    }

    /**
     * Test of isValidArray method, of class ClassicSudoku.
     */
    @Test
    public void testIsValidArray() {
        assertTrue(puzzle.isValidArray(dummyMatrix()));
    }

    private int[][] dummyMatrix()
    {
        int[][] array = new int[9][9];
        array[1][1] = 2;
        array[2][7] = 9;
        array[4][0] = 1;
        array[4][5] = 3;
        array[8][7] = 4;
        return array;
    }
}
