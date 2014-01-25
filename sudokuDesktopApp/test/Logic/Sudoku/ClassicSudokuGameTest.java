/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Sudoku;

import Logic.IO.IO;
import Logic.Users.Person;
import java.util.Arrays;
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
public class ClassicSudokuGameTest {

    private ClassicSudokuGame g;

    public ClassicSudokuGameTest() {
        g = new ClassicSudokuGame();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        g = new ClassicSudokuGame();
        g.addNumber(2, new Coord_2D(0, 0));
        g.addNumber(3, new Coord_2D(0, 2));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testingConstructor() {
        Person p = new Person("Test");
        g = new ClassicSudokuGame(dummyMatrix(), String.valueOf(1), p);
        assertEquals(p, g.players.get(0));
    }

    @Test
    public void testingHintsPerColumn() {
        int[] r = g.getHelp(new Coord_2D(3, 0));
        assertTrue(Arrays.equals(r, new int[]{1, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void testingHintsPerLine() {
        int[] r = g.getHelp(new Coord_2D(0, 3));
        assertTrue(Arrays.equals(r, new int[]{1, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void testingHintsPerBlock() {
        int[] r = g.getHelp(new Coord_2D(1, 1));
        assertTrue(Arrays.equals(r, new int[]{1, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void testAddNumber() {
        assertTrue(g.addNumber(1, new Coord_2D(1, 1)));
        assertFalse(g.addNumber(1, new Coord_2D(0, 0)));
    }

    @Test
    public void testGetSudokuStatus() {
        assertEquals(g.getSudokuStatus(), sudokuStatus.NOTFINISHED);
    }

    @Test
    public void testingIfCompleted() {
        assertFalse(g.isCompleted());
    }

    @Test
    public void testingIsEditable() {
        g = new ClassicSudokuGame(dummyMatrix(), String.valueOf(1));
        assertFalse(g.getIsEditableMatrix()[1][1]);
        assertTrue(g.getIsEditableMatrix()[1][2]);
    }

    /**
     *Test of onQuitGame method, of class ClassicSudokuGame.
     **/
     @Test
     public void testOnQuitGame() {
         g = new ClassicSudokuGame(dummyMatrix(), "1", new Person("Test"));
         g.onQuitGame(true);
         ClassicSudokuGame gTest= (ClassicSudokuGame) IO.readFromFile(GlobalConstants.SAVES_PATH + g.players.get(0).getId()+"_prev");
         assertFalse(gTest==null);
     }
     
    private int[][] dummyMatrix() {
        int[][] array = new int[9][9];
        array[1][1] = 2;
        array[2][7] = 9;
        array[4][0] = 1;
        array[4][5] = 3;
        array[8][7] = 4;
        return array;
    }

}
