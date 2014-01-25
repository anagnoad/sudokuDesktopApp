/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Sudoku;

import Logic.IO.IO;
import Logic.Users.Person;
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
public class DuidokuGameTest {

    private DuidokuGame g;

    public DuidokuGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        g = new DuidokuGame();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testingUserPlay() {
        assertTrue(g.addNumber(3, new Coord_2D(0, 2)));
        assertFalse(g.addNumber(4, new Coord_2D(0, 2)));
    }

    @Test
    public void testingComputerPlay() {
        assertTrue(g.computerAddNumber());
    }

    @Test
    public void testingIsCompletedAndWhoWon() {
        assertFalse(g.isCompleted());
        assertTrue(g.whoWon() == null);
    }

    /**
     * Test of commonAddNumber method, of class DuidokuGame.
     */
    @Test
    public void testAddNumber() {
        assertTrue(g.addNumber(3, new Coord_2D(1, 1)));
        assertFalse(g.addNumber(1, new Coord_2D(1, 1)));
    }
//
//    This test cannot be evaluated, since we do not know where the 
//    cpu will play.
//    /**
//     * Test of getHelp method, of class DuidokuGame.
//     */
//    @Test
//    public void testGetHelp() {
//        g.addNumber(1, new Coord_2D(0,0));
//        
//    }

    /**
     * Test of getSudokuStatus method, of class DuidokuGame. Only available for
     * not finished sudokus, because any other case cannot be evaluated in
     * tests.
     */
    @Test
    public void testGetSudokuStatus() {
        g.addNumber(2, new Coord_2D(0, 0));
        assertEquals(g.getSudokuStatus(), sudokuStatus.NOTFINISHED);
    }

    /**
     *Test of onQuitGame method, of class DuidokuGame.
     **/
     @Test
     public void testOnQuitGame() {
         g = new DuidokuGame(new Person("Test"));
         g.onQuitGame(true);
         DuidokuGame gTest= (DuidokuGame) IO.readFromFile(GlobalConstants.SAVES_PATH + g.players.get(0).getId()+"_prev");
         assertFalse(gTest==null);
     }
}
