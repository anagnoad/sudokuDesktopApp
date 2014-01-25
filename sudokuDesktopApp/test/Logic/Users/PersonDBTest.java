/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic.Users;

import java.util.ArrayList;
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
public class PersonDBTest {
    
    private static PersonDB db = new PersonDB();
    
    public PersonDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        db.addNewPerson("Antonis");
        db.addNewPerson("Steve");
        db.addNewPerson("Greg");
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
     * Test of searchByNickName method, of class PersonDB.
     */
    @Test
    public void testSearchByNickName() {
        String nicknameToSearch = "Antonis";
        ArrayList<Person> result = db.searchByNickName(nicknameToSearch);
        System.out.println(result.toString());
        for(Person p: result)
        {
            System.out.println(p);
        }
        assertTrue(result.get(0).getNickname().equals(nicknameToSearch));
    }

    /**
     * Test of searchById method, of class PersonDB.
     */
    @Test
    public void testSearchById()
    {
        ArrayList<Person> res = db.searchByNickName("Steve");
        Person p = res.get(0);
        
        Person p2 = db.searchById(p.getId());
        
        assertEquals(p, p2);
        
    }
    
    /**
     * Test of addNewPerson method, of class PersonDB.
     */
    @Test
    public void testAddNewPerson() {
        String nickname = "Kostas";
        Person result = db.addNewPerson(nickname);
        assertTrue(result.getNickname().equals(nickname));
    }

    /**
     * Test of deletePerson method, of class PersonDB.
     */
    @Test
    public void testDeleteExistentPerson() {
        String nicknameToDelete = "Greg";
        ArrayList<Person> result = db.searchByNickName(nicknameToDelete);
        boolean flag = true;
        if(result.isEmpty())
            flag = false;
        else
        {
            Person p = result.get(0);
            flag = db.deletePerson(p.getId());
        }
        assertTrue(flag);
    }
    
    /**
     * Test of deletePerson method, of class PersonDB.
     */
    @Test
    public void testDeleteNonExistentPerson() {
        String nicknameToDelete = "Nick";
        ArrayList<Person> result = db.searchByNickName(nicknameToDelete);
        boolean flag = true;
        if(result==null)
            flag = false;
        else
        {
            Person p = result.get(0);
            flag = db.deletePerson(p.getId());
        }
        assertFalse(flag);
    }
    
    /**
     * Test of equals method, of class PersonDB
     */
    public void testEquals()
    {
        Person p1 = new Person("Steve");
        Person p2 = new Person ("Antonis");
        
        PersonDB db1 = new PersonDB();
        PersonDB db2 = new PersonDB();
        // add the people to the db1
        db1.addNewPerson(p1);
        db1.addNewPerson(p2);
        // add the people to the db2
        db2.addNewPerson(p1);
        db2.addNewPerson(p2);
        
        assertEquals(db1, db2);
    }
}
