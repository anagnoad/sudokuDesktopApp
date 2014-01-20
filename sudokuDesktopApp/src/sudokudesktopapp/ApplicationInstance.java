package sudokudesktopapp;

import Logic.IO.IO;
import Logic.Users.Person;
import Logic.Users.PersonDB;

public final class ApplicationInstance {
    private static volatile ApplicationInstance instance;
    public Person loggedInUser;
    public boolean anonymousUser;
    public PersonDB playersDB; // load or create the db in the ctor

    private ApplicationInstance()
    {
            loggedInUser = null;
            anonymousUser = true;
            if (!loadPlayersDB(" "))// enter filename containing the PlayersDB
            {
                    this.playersDB = new PersonDB();
            }
    }

    public void login(Person person)
    {
        this.anonymousUser = false;
        this.loggedInUser = person;
    }

    public void logout()
    {
        this.anonymousUser = true;
        this.loggedInUser = null;
    }

    private boolean loadPlayersDB(String filename)
    {
        return false;
           // return IO.loadPlayers(filename, playersDB);
    }

    public static ApplicationInstance getInstance()
    {
            if( instance == null)
            {
                    synchronized (ApplicationInstance.class)
                    {
                            if (instance == null)
                            {
                                    instance = new ApplicationInstance();
                            }
                    }
            }
            return instance;
    }
}
