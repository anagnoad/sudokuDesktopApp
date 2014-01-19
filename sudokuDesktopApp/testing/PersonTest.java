package testing;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;


import com.example.sudokuapp.Logic.Users.Person;

/**
 * 
 */

/**
 * @author Steve
 *
 */
public class PersonTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.Person#setNickname(java.lang.String)}.
	 */
	@Test
	public void testSetNickname() {
		Person testPerson = new Person("Steve");
		testPerson.setNickname("Stefanos");
		assertEquals("Stefanos", testPerson.getNickname());
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.Person#incrementVictories()}.
	 */
	@Test
	public void testIncrementVictories() {
		Person testPerson = new Person("Steve");
		testPerson.incrementVictories();
		testPerson.incrementVictories();
		assertEquals(2, testPerson.getVictories());
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.Person#incrementDefeats()}.
	 */
	@Test
	public void testIncrementDefeats() {
		Person testPerson = new Person("Steve");
		testPerson.incrementDefeats();
		testPerson.incrementDefeats();
		testPerson.incrementDefeats();
		assertEquals(3, testPerson.getDefeats());
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.Person#addSudokuSolved(int)}.
	 */
	@Test
	public void testAddSudokuSolved() {
		Person testPerson = new Person("Steve");
		int sudokuId = 12345;
		testPerson.addSudokuSolved(sudokuId);
		assertTrue(testPerson.hasSolved(sudokuId));
	}


}
