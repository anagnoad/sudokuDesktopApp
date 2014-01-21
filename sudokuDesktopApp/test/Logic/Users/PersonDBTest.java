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
 * @author Anthony
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
        for(Person p: result)
        {
            System.out.println(p);
        }
        assertTrue(result.get(0).getNickname().equals(nicknameToSearch));
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
        String nicknameToDelete = "Antonis";
        ArrayList<Person> result = db.searchByNickName(nicknameToDelete);
        boolean flag = true;
        if(result.size()==0)
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
}
