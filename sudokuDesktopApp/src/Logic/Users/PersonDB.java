package com.example.sudokuapp.Logic.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Represent the Database class for all the players.
 * Features:
 * * add
 * * delete
 * * search
 * @author Steve
 *
 */
public class PersonDB implements Serializable {
	/* ---------------- member vars ---------------- */
	/**
	 * Represents the actual container of Person objects.
	 */
	private HashSet<Person> theDB; // have to implement Person isEqual for this to work
	
	//ctor
	/**
	 * Default ctor.
	 * Initializes the member vars.
	 */
	public PersonDB()
	{
		this.theDB = new HashSet<Person>();
	}
	
	/**
	 * Searches the database for matches for the given nickname.
	 * @param nicknameToSearch the nickname that is being searched
	 * @return an ArrayList of matching Person objects or null if no matches are found
	 */
	public ArrayList<Person> searchByNickName(String nicknameToSearch) // for getting specific info, the results may be many
	{ 
		ArrayList<Person> toBeReturned = new ArrayList<Person>();
		Iterator<Person> i = theDB.iterator();
		while (i.hasNext())
		{
			Person currentObject = i.next();
			if (currentObject.getNickname().equals(nicknameToSearch))
			{
				toBeReturned.add(currentObject);
			}
		}
		if (toBeReturned.size() == 0)
		{
			// no results found
			return null;
		}
		return toBeReturned;
	}
	
	/**
	 * Searches the database for matches for the given id.
	 * The result is either one or none, as id is the key of the database.
	 * @param idToSearch the id we are searching for
	 * @return an instance of the Person class representing the result in the db or null if no matches are found.
	 */
	public Person searchById(int idToSearch) //the result is none or one
	{
		Iterator<Person> i = theDB.iterator();
		while (i.hasNext())
		{
			Person currentObject = i.next();
			if (currentObject.getId() == idToSearch)
				return currentObject;
		}
		return null; // not found
	}
	
	/**
	 * Creates and adds a new person to the Database.
	 * @param nickname the nickname we want the player we are adding to have
	 * @return true if added, false otherwise.
	 */
	public boolean addNewPerson(String nickname)
	{
		return theDB.add(new Person(nickname));
	}
	
	public boolean addNewPerson(Person personToAdd)
	{
		return theDB.add(personToAdd); // you have to implement equals, otherwise it fails
	}
	
	/**
	 * Deletes a Person from the Database
	 * @param id the id of the person we want to delete from the database
	 * @return true if deleted, false otherwise
	 */
	public boolean deletePerson(int id)
	{
		Person toBeDeleted = searchById(id);
		if (toBeDeleted == null)
		{
			return false;
		}
		else
		{
			return theDB.remove(toBeDeleted);
		}
	}
}
