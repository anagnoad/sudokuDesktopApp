/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.sudokuapp.Logic.Users.Person;
import com.example.sudokuapp.Logic.Users.PersonDB;

/**
 * @author Steve
 *
 */
public class PersonDBTest {

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
	 * Test method for {@link com.example.sudokuapp.Logic.Users.PersonDB#searchByNickName(java.lang.String)}.
	 */
	@Test
	public void testSearchByNickName() {
		PersonDB testDB = new PersonDB();
		createFakeDB(testDB);
		
		assertNotNull(testDB.searchByNickName("Stefanos"));
		assertNull(testDB.searchByNickName("George"));
		
		
	}

	private ArrayList<Integer> createFakeDB(PersonDB testDB) {
		// create 2 people and add them
		Person p1 = new Person("Stefanos");
		p1.incrementVictories();
		p1.addSudokuSolved(12);
		
		Person p2 = new Person("Antonis");
		p1.incrementVictories();
		p1.incrementVictories();
		p1.incrementDefeats();
		p1.addSudokuSolved(13);
		
		testDB.addNewPerson(p1);
		testDB.addNewPerson(p2);
		
		ArrayList<Integer> toBeReturned = new ArrayList<Integer>();
		toBeReturned.add(Integer.valueOf(p1.getId()));
		toBeReturned.add(Integer.valueOf(p2.getId()));
		return toBeReturned;
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.PersonDB#searchById(int)}.
	 */
	@Test
	public void testSearchById() {
		PersonDB testDB = new PersonDB();
		ArrayList<Integer> ids = createFakeDB(testDB);
		
		assertNotNull(testDB.searchById(ids.get(0)));
		assertNotNull(testDB.searchById(ids.get(1)));
		assertNull(testDB.searchById(-1));
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.PersonDB#addNewPerson(java.lang.String)}.
	 */
	@Test
	public void testAddNewPerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.sudokuapp.Logic.Users.PersonDB#deletePerson(int)}.
	 */
	@Test
	public void testDeletePerson() {
		PersonDB testDB = new PersonDB();
		ArrayList<Integer> ids = createFakeDB(testDB);
		
		assertTrue(testDB.deletePerson(ids.get(1)));
		assertFalse(testDB.deletePerson(-1));
	}

}
