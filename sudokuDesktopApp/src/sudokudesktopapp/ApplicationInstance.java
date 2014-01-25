package sudokudesktopapp;

import Logic.IO.IO;
import Logic.Sudoku.BaseGame;
import Logic.Sudoku.ClassicSudokuGame;
import Logic.Sudoku.DuidokuGame;
import Logic.Sudoku.HyperSudokuGame;
import Logic.Sudoku.TypeOfGame;
import Logic.Users.Person;
import Logic.Users.PersonDB;
import java.util.HashSet;
import java.util.Random;

public final class ApplicationInstance {
    private static volatile ApplicationInstance instance;
    public Person loggedInUser;
    public boolean anonymousUser;
    public PersonDB playersDB; // load or create the db in the ctor
    public BaseGame game;
    private Random rand;
    
    private ApplicationInstance()
    {
            loggedInUser = null;
            game = null;
            anonymousUser = true;
            if (!loadPlayersDB(GlobalConstants.PERSONDB_PATH))
            {
                    this.playersDB = new PersonDB();
            }
//            System.out.println(this.playersDB.searchByNickName("Antonis"));
            rand = new Random();
    }

    public void login(Person person)
    {
        this.anonymousUser = false;
        this.loggedInUser = person;
    }

//    |--notsupported--|
//    public void logout()
//    {
//        this.anonymousUser = true;
//        this.loggedInUser = null;
//    }

    private boolean loadPlayersDB(String filename)
    {
            this.playersDB = IO.loadPlayers(filename, playersDB);
            for (int i = 0; i < 15; i++) {
            playersDB.addNewPerson("foo");
        }
            
            if(this.playersDB ==null)
                return false;
            return true;
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
    
    public boolean loadNewGame(TypeOfGame type)
    {
        String suffix = new String();
        switch(type)
        {
            case CLASSIC:
                suffix = ".classicsudoku";
                break;
            case HYPERDOKU:
                suffix = ".hypersudoku";
                break;
            case DUIDOKU:
                if (this.anonymousUser)
                    this.game = new DuidokuGame();
                else
                    this.game = new DuidokuGame(this.loggedInUser);
                return true;
        }
        if (this.anonymousUser)
        {
            String filename = String.valueOf(rand.nextInt(GlobalConstants.TOTAL_GAMES_PRESAVED) + 1);
            filename = filename + suffix;
            int[][] array = new int[9][9];
            if(IO.loadSudokuFromFile(filename, type, array))
            {
                switch(type)
                {
                    case CLASSIC:
                        game = new ClassicSudokuGame(array, filename);
                        break;
                    case HYPERDOKU:
                        game = new HyperSudokuGame(array,filename);
                }
                return true;
            }
            return false;
        }
        else
        {
            for (int i = 1; i <= GlobalConstants.TOTAL_GAMES_PRESAVED; i++) {
                if(!this.loggedInUser.hasSolved(i))
                {
                    int[][] array = new int[9][9];
                    String id = i+suffix;
                    if(IO.loadSudokuFromFile(id, type, array))
                    {
                        switch(type)
                        {
                            case CLASSIC:
                                game = new ClassicSudokuGame(array, id, this.loggedInUser);
                                break;
                            case HYPERDOKU:
                                game = new HyperSudokuGame(array,id, this.loggedInUser);
                                break;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }
    
    public boolean loadGame()
    {
        BaseGame temp = IO.readFromFile(GlobalConstants.SAVES_PATH+this.loggedInUser.getId()+"_prev");
        if (temp!=null)
        {
            this.game = temp;
            return true;
        }
        else
            return false;
    }
    
    public boolean saveOnClose(boolean answer)
    {
        boolean toBeReturned = false;
        if(!this.anonymousUser && this.game!=null)
        {
            toBeReturned = this.game.onQuitGame(answer);
        }
        return (IO.savePlayers(GlobalConstants.PERSONDB_PATH, playersDB) && toBeReturned);
    }
}
