/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Users;

import Logic.Sudoku.ClassicSudoku;
import java.util.Date;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steve
 */
public class PersonTest {
    
    public PersonTest() {
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
     * Test of equals method, of class Person.
     */
    @Test
    public void testEquals() {
        Person p = new Person("Steve");
        Person p1 = new Person("Antonis");
        boolean res1 = (p==p1);
        boolean res2 = (p==p);
        assertTrue(!res1 && res2);
        
    }

    /**
     * Test of setNickname method, of class Person.
     */
    @Test
    public void testSetNickname() {
        Person p = new Person("Steve");
        p.setNickname("Stef");
        assertEquals("Stef", p.getNickname());
    }

    /**
     * Test of incrementVictories and IncrementDefeats methods, of class Person.
     */
    @Test
    public void testIncrementVictoriesDefeats() {
        Person p = new Person("Steve");
        int currentNumberOfVic = p.getVictories();
        p.incrementVictories();
        boolean res1 = (currentNumberOfVic == p.getVictories()-1);
        
        int currentNumberOfDefeats = p.getDefeats();
        p.incrementDefeats();
        boolean res2 = (currentNumberOfDefeats == p.getDefeats()-1);
        
        assertTrue(res1 && res2);
    }

    /**
     * Test of addSudokuSolved and hasSolved methods, of class Person.
     */
    @Test
    public void testAddSudokuSolved() {
        Person p = new Person("Steve");
        ClassicSudoku board = new ClassicSudoku(new int[9][9], "23");
        p.addSudokuSolved(board.getID());
        assertTrue(p.hasSolved(Integer.parseInt("23")));
    }


    /**
     * Test of reset method, of class Person.
     */
    @Test
    public void testReset() {
        Person p = new Person("Steve");
        p.incrementDefeats();
        p.incrementVictories();
        
        p.reset();
        
        assertTrue(p.getVictories()==0 && p.getDefeats()==0);
    }
}