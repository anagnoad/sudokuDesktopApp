/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Sudoku;

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
public class DuidokuGameTest {
    
    private DuidokuGame g = new DuidokuGame();
    
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testingUserPlay()
    {
        assertTrue(g.addNumber(3, new Coord_2D(0,2)));
        assertFalse(g.addNumber(4,new Coord_2D(0,2)));
    }
    
    @Test
    public void testingComputerPlay()
    {
        assertTrue(g.computerAddNumber());
    }
    
    @Test
    public void testingIsCompletedAndWhoWon()
    {
        assertFalse(g.isCompleted());
        assertTrue(g.whoWon()==null);
    }
    
}
