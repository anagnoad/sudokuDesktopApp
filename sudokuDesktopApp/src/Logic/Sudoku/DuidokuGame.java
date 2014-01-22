package Logic.Sudoku;

import Logic.Users.Person;
import java.util.Iterator;
import java.util.Random;


/**
 * Class representing the Duidoku game.
 * Can be extended to work with more than one player.
 * @author Steve
 *
 */
public class DuidokuGame    extends BaseGame // this can be easily extended to be played with more than one player. It's constructor constrained for now.
                                               implements Multiplayer
{
    /**
     * Member variable showing the steps made in the current Game.
     * Is used to find out who the winner is.
     */
    private int stepCounter;
    /**
     * Member variable representing the (4x4) duidoku board.
     */
    protected Duidoku mySudoku;
    
    /**
     * Member variable showing if you play against another player or against the cpu.
     */
    protected boolean computerPlays;
    
    /**
     * Random generator in case we play against the computer.
     */
    private Random randGenerator;
    
    /**
     * Default ctor.
     * Makes the basic initializations of the class.
     */
    public DuidokuGame()
    {
            super();
            this.mySudoku = new Duidoku();
            this.computerPlays = true;
        this.randGenerator = new Random();
        this.players.add(new Person("CPU"));
    }
    
    /**
     * Ctor initializing the game vs. the cpu
     * @param player the player of the game
     */
    public DuidokuGame(Person player)
    {
        this();
        this.players.add(player);
        
    }

//    /**
//     * Ctor initializing the game to a two-player game (default for duidoku)
//     * @param Player1 the main player of the game (logged in)
//     * @param Player2 the second player of the game
//     */
//    public DuidokuGame(Person Player1, Person Player2)
//    {
//            this();
//            this.players.add(Player1);
//            this.players.add(Player2);
//            this.computerPlays = false;
//    }


    public boolean commonAddNumber(int value, Coord_2D coordinates) {
        boolean isValid = mySudoku.setCell(value, coordinates.x, coordinates.y);
        if (isValid)
        {
            stepCounter++;
            this.mySudoku.isEditableArray[coordinates.x][coordinates.y] = false;
        }
        for(int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++)
                System.out.printf("%d ", this.mySudoku.matrix[i][j]);
            System.out.println("");
        }
        System.out.println("--------------");
        return isValid;
    }
    
    @Override
    public boolean addNumber(int value, Coord_2D coordinates)
    {
        boolean flag = commonAddNumber(value, coordinates);
        if(!flag)
            return false;
        return computerAddNumber() || flag;
    }
    
    public boolean computerAddNumber(){
        int value;
        Coord_2D coords;
        if (!this.isCompleted() && this.getSudokuStatus() != sudokuStatus.FAILED)
        {
            do
            {
                value = this.randGenerator.nextInt(9)+1; // it cannot put 0
                coords = new Coord_2D(this.randGenerator.nextInt(9), this.randGenerator.nextInt(9));
            }
            while (!commonAddNumber(value, coords));
            return true;
        }
        return false;
    }


    public int[] getHelp(Coord_2D coords)
    {
        return mySudoku.returnHint(coords);
    }
    @Override
    public Person whoWon() { // returns the winner for updating statistics
        if(this.getSudokuStatus()== sudokuStatus.FAILED || this.getSudokuStatus() == sudokuStatus.FINISHED)
        {
            return this.players.get(this.stepCounter%players.size());
        }
            
        return null;
    }

    @Override
    public int getNumberOfPlayers() {
            return this.players.size();
    }

    @Override
    public boolean isCompleted() {
            return this.mySudoku.isCompleted();
    }

    /**
     * Get specific state of the sudoku.
     * @return the specific state of the duidoku (among FINISHED, NOTFINISHED and FAILED)
     */
    public sudokuStatus getSudokuStatus() // this may go to an abstract class sudoku
    {
            return this.mySudoku.getSudokuStatus();
    }

    @Override
    public boolean onQuitGame(boolean toSave)
    {
        boolean tempRes = super.onQuitGame(toSave);
       // update stats
        if (this.isCompleted())
        {
            Person winner = this.whoWon();
            winner.incrementVictories();
            Iterator<Person> it = players.iterator();
            while (it.hasNext())
            {
                Person temp = it.next();
                if (temp!=winner)
                    temp.incrementDefeats();
            }
        }
        return tempRes;
    }
    public int getMatrixValue(int i, int j)
    {
        return this.mySudoku.getMatrix()[i][j];
    }
    
    public boolean[][] getIsEditableMatrix()
    {
        return this.mySudoku.isEditableArray;
    }
}
