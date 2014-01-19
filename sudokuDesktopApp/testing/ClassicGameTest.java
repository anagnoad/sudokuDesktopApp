package testing;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.sudokuapp.Logic.Sudoku.Coord_2D;
import com.example.sudokuapp.Logic.Sudoku.ClassicSudokuGame;

/**
 * 
 */

/**
 * @author Anthony
 *
 */
public class ClassicGameTest {

	public ClassicGameTest() {
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
	public void testingHintsPerColumn() {
		ClassicSudokuGame g = new ClassicSudokuGame();
		g.addNumber(2, new Coord_2D(0,0));
		g.addNumber(3, new Coord_2D(0,2));
		int[] r = g.getHelp(new Coord_2D(3,0));
		assertTrue(Arrays.equals(r, new int[]{1,3,4,5,6,7,8,9}));
	}
	@Test
	public void testingHintsPerLine() {
		ClassicSudokuGame g = new ClassicSudokuGame();
		g.addNumber(2, new Coord_2D(0,0));
		g.addNumber(3, new Coord_2D(0,2));
		int[] r = g.getHelp(new Coord_2D(0,3));
		assertTrue(Arrays.equals(r, new int[]{1,4,5,6,7,8,9}));
	}
	@Test
	public void testingHintsPerBlock() {
		ClassicSudokuGame g = new ClassicSudokuGame();
		g.addNumber(2, new Coord_2D(0,0));
		g.addNumber(3, new Coord_2D(0,2));
		int[] r = g.getHelp(new Coord_2D(1,1));
		assertTrue(Arrays.equals(r, new int[]{1,4,5,6,7,8,9}));
	}
	@Test
	public void testingIfCompleted(){
		ClassicSudokuGame g = new ClassicSudokuGame();
		g.addNumber(2, new Coord_2D(0,0));
		g.addNumber(3, new Coord_2D(0,2));
		assertFalse(g.isCompleted());
	}
	
}
