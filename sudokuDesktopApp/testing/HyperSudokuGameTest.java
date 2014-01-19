package testing;
/**
 * 
 */


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.sudokuapp.Logic.Sudoku.Coord_2D;
import com.example.sudokuapp.Logic.Sudoku.ClassicSudokuGame;
import com.example.sudokuapp.Logic.Sudoku.HyperSudokuGame;
import com.example.sudokuapp.Logic.Sudoku.TypeOfGame;
import com.example.sudokuapp.Logic.Users.Person;

/**
 * @author Anthony
 *
 */
public class HyperSudokuGameTest {

	public HyperSudokuGameTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHyperSudoku() {
		HyperSudokuGame g = new HyperSudokuGame(new Person());
		g.addNumber(4, new Coord_2D(2,2));
		g.addNumber(7, new Coord_2D(2,1));
		g.addNumber(9, new Coord_2D(7,7));
		int[] help = g.getHelp(new Coord_2D(5,5));
		for(int x: help)
			System.out.println(x);
		assertTrue(g.addNumber(9, new Coord_2D(5,5)));
	}

}
