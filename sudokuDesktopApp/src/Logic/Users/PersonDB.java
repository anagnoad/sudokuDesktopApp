package Logic.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

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
            this.theDB = new HashSet<>();
    }

    /**
     * Searches the database for matches for the given nickname.
     * @param nicknameToSearch the nickname that is being searched
     * @return an ArrayList of matching Person objects or null if no matches are found
     */
    public ArrayList<Person> searchByNickName(String nicknameToSearch) // for getting specific info, the results may be many
    { 
            ArrayList<Person> toBeReturned = new ArrayList<>();
            Iterator<Person> i = theDB.iterator();
            while (i.hasNext())
            {
                    Person currentObject = i.next();
                    if (currentObject.getNickname().equals(nicknameToSearch))
                    {
                            toBeReturned.add(currentObject);
                    }
            }
            if (toBeReturned.isEmpty())
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
     * @return the person added, if added, null otherwise
     */
    public Person addNewPerson(String nickname)
    {
        Person personToBeAdded = new Person(nickname);
            if (theDB.add(personToBeAdded))
                return personToBeAdded;
            else
                return null;
    }

    protected boolean addNewPerson(Person personToAdd)
    {
            return theDB.add(personToAdd); // you have to implement equals, otherwise it fails
    }

    /**
     * Deletes a Person from the Database.
     * @param id the id of the person we want to delete from the database
     * @return true if deleted, false otherwise
     */
    public boolean deletePerson(int id)
    {
            // Created for library uses. Not implemented in the gui forms.
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
    
    /**
     * Overriden method toString().
     * @return all the players in the database delimited with an \n.
     */
    @Override
    public String toString()
    {
        StringBuilder toBeReturned = new StringBuilder();
        for (Person i : this.theDB)
        {
            toBeReturned.append(i.getNickname());
            toBeReturned.append("\n");
        }
        return toBeReturned.toString();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!(obj instanceof PersonDB))
            return false;
        if (this.hashCode() == obj.hashCode())
            return true;
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.theDB);
        return hash;
    }
}