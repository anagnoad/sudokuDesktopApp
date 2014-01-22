/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import Logic.Sudoku.BaseGame;
import Logic.Sudoku.ClassicSudokuGame;
import Logic.Sudoku.Coord_2D;
import Logic.Sudoku.DuidokuGame;
import Logic.Sudoku.HyperSudokuGame;
import Logic.Sudoku.TypeOfGame;
import Logic.Users.Person;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 * The controller of all the GUI elements in the application.
 * Follows the MVC paradigm.
 * @author Steve
 */
public class GUIHandler {
    /*---------------------Member vars--------------------------*/
    /*--------------------Logic elements ----------------------*/
    private ApplicationInstance appInstance; // knows the application instance
    
    /* -------------------GUI elements-------------------------*/
    private Application myApp; // access modifier may need to change
    private MainMenuBar mainMenuBar;
    private GettingStartedPanel gettingStartedPanel;
    private SudokuPanel sudokuPanel;
    private SudokuCellOptionsPanel sudokuCellOptionsPanel;
    private NewUserPanel newUserPanel;
    private NewGameOptionsPanel newGameOptionsPanel;
    private LogInPanel loginPanel;
    private LoggedInPanel loggedInPanel;
    private SudokuHelpDialog sudokuHelpDialog;
    private StatsPanel statsPanel;
    private AboutDialog aboutDialog;
    
    private boolean showHints;
    
    /*--------------------------Methods------------------------------*/
    //ctor
    public GUIHandler(ApplicationInstance appInstance)
    {
        // Start the application
        // to be done:
        // 1. create the application fram
        // 2. add the getting started to the sidebar
        
        
        this.appInstance = appInstance;
        this.myApp = new Application(this);
        // add the menuBar to the app
        this.mainMenuBar = new MainMenuBar(this);
        this.menuLoggedInEnabler();
        myApp.setJMenuBar(this.mainMenuBar);
        
        this.showGettingStartedPanel();
        this.myApp.setVisible(true);
        
        this.showHints = true;
    }
    
    public void toggleShowHints()
    {
        this.showHints = !this.showHints;
        System.out.println(this.showHints);
    }
    
    public void updateHintsFromSudokuCellOptionsPanel()
    {
        if (this.sudokuCellOptionsPanel!=null)
            this.sudokuCellOptionsPanel.getShowHintsLabel().setEnabled(showHints);
    }
    
    public void showHintsOnSudokuGame(Coord_2D selectedCoordinates)
    {
        if (this.appInstance.game != null)
        {
            int[] playableNumbers = new int[1];
            if (this.appInstance.game instanceof ClassicSudokuGame)
            {
                ClassicSudokuGame classicGame = (ClassicSudokuGame) this.appInstance.game;
                playableNumbers = classicGame.getHelp(selectedCoordinates);
            }
            else if (this.appInstance.game instanceof HyperSudokuGame)
            {
                HyperSudokuGame hyperGame = (HyperSudokuGame) this.appInstance.game;
                playableNumbers = hyperGame.getHelp(selectedCoordinates);
            }
            else if (this.appInstance.game instanceof DuidokuGame)
            {
                DuidokuGame duiGame = (DuidokuGame) this.appInstance.game;
                playableNumbers = duiGame.getHelp(selectedCoordinates);
            }
            StringBuilder str = new StringBuilder();
            for (int i=0;i<playableNumbers.length;i++)
            {
                str.append(String.valueOf(playableNumbers[i]));
                str.append(" ");
            }
            this.sudokuCellOptionsPanel.getShowHintsLabel().setText(str.toString());
        }
    }
    
    public void cleanMainPanel(boolean toBeNulled)
    {
        if (this.myApp.mainPanel != null)
        {
            this.myApp.mainPanel.setVisible(false);
            if (toBeNulled)
            {
                this.myApp.mainPanel = null;
            }
        }
    }
    
    public void cleanSidePanel(boolean toBeNulled)
    {
        if (this.myApp.sideBarPanel != null)
        {
            this.myApp.sideBarPanel.setVisible(false);
            if (toBeNulled)
            {
                this.myApp.sideBarPanel = null;
            }
        }
        this.myApp.repaint();
    }
    
    
    public void showGettingStartedPanel() // is supposed to be called on launch
    {
        if (this.gettingStartedPanel == null)
        {
            this.gettingStartedPanel = new GettingStartedPanel(this);
        }
        // make it visible to the sidebar
        myApp.sideBarPanel = this.gettingStartedPanel;
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        myApp.add(myApp.sideBarPanel);
        myApp.sideBarPanel.setVisible(true);
    }
    
    public void hideGettingStartedPanel()
    {
       if (this.gettingStartedPanel == null)
       {/* Nothing to be done */}
       else
       {
           this.cleanSidePanel(false);
//           if(this.gettingStartedPanel.isVisible())
//           {
//               myApp.sideBarPanel.setVisible(false);
//               myApp.sideBarPanel.remove(this.gettingStartedPanel);
//               myApp.sideBarPanel.repaint();
//           }
       }
    }

    public void showAddNewUserPanel() // is supposed to be called when the user wishes to create new user
    {
        /*
         * To-do:
         * 1. hide the gettingStartedPanel
         * 2. Show the newUser to the mainPanel of the application frame
         */
        
        
        // 1)
        this.hideGettingStartedPanel();
        
        // 2)
        this.cleanMainPanel(true);
        this.newUserPanel = new NewUserPanel(this);
        
        this.myApp.mainPanel = newUserPanel;
        this.myApp.mainPanel.setBounds(120, 120, 350, 350);
        this.myApp.add(myApp.mainPanel);
        this.myApp.setVisible(true);
        this.myApp.repaint();
    }
    
        public void hideAddNewUserPanel()
        {
            if (this.newUserPanel!=null)
            {
                this.cleanMainPanel(true);
                this.newUserPanel = null;
            }
        }
        
        
    public void addNewUser(String nickname)
    {
        // add the user to the db saved in the application instance
        Person player = this.appInstance.playersDB.addNewPerson(nickname);
        if (player != null)
        {
            // login to the current user
            this.appInstance.login(player);
            menuLoggedInEnabler();
            //DEBUGING: System.out.println(this.appInstance.loggedInUser.toString());
        }
        else
        {
            // thow exception or/and show message
        }
        this.showLoggedInPanel();
    }
    
    
    public void showLogInPanel()//
    {
        /*
         * To-do:
         * 1. hide the gettingStartedPanel
         * 2. Show the logInPanel to the mainPanel of the application frame
         */
        
        
        // 1)
        this.hideGettingStartedPanel();
        
        // 2)
        this.cleanMainPanel(true);
        this.loginPanel = new LogInPanel(this);
        
        this.myApp.mainPanel = loginPanel;
        this.myApp.mainPanel.setBounds(120, 120, 400, 300);
        this.myApp.add(myApp.mainPanel);
        this.myApp.setVisible(true);
        this.myApp.repaint();
    }
    
    public void hideLoginPanel() //
    {
         if (this.loginPanel!=null)
            {
                this.cleanMainPanel(true);
                this.newUserPanel = null;
            }
    }
    
    public void login(Person person)
    {
        this.appInstance.login(person);
        System.out.println(this.appInstance.loggedInUser);
    }
    
    public void showNewGameOptionsPanel()
    {
        // TODOS:
        // 1) clear the sidepanel
        // 2) show the newGameOptionsPanel
        
        // 1)
        this.cleanSidePanel(true);
        
        //2
        if (this.newGameOptionsPanel==null)    
            this.newGameOptionsPanel = new NewGameOptionsPanel(this);
        this.myApp.sideBarPanel = this.newGameOptionsPanel;
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.myApp.add(myApp.sideBarPanel);
        this.myApp.sideBarPanel.setVisible(true);
    }
    
    public void hideNewGameOptionsPanel()
    {
        
    }
    
    public void showLoggedInPanel()
    {
        if (this.loggedInPanel == null)
        {
            this.loggedInPanel = new LoggedInPanel(this);
        }
        // make it visible to the sidebar
        myApp.sideBarPanel = this.loggedInPanel;
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        myApp.add(myApp.sideBarPanel);
        myApp.sideBarPanel.setVisible(true);
    }
    
    public void hideLoggedInPanel()
    {
        this.cleanSidePanel(false);
    }
    
    
    public ArrayList<Person> searchByNickname(String nicknameToSearch)
    {
        ArrayList<Person> listToReturn;
        listToReturn = this.appInstance.playersDB.searchByNickName(nicknameToSearch);
        return listToReturn; // may return null
    }

    public void showHelpDialog() //works
    {
        this.sudokuHelpDialog = new SudokuHelpDialog(myApp, true, this);
        this.sudokuHelpDialog.setVisible(true);
    }
    
    public void showAboutDialog()
    {
        this.aboutDialog = new AboutDialog(myApp, true);
        this.aboutDialog.setVisible(true);
    }
    
    
    public void showStatsPanel()
    {
        if (this.statsPanel == null)
        {
            //System.out.println(appInstance.loggedInUser.getNickname()+"...");
            this.statsPanel = new StatsPanel(this, appInstance.loggedInUser);
        }
        else
        {
            if (this.statsPanel.isVisible())
            {
                // already visible
                return;
            }
        }
        this.cleanMainPanel(true);
        this.myApp.mainPanel = this.statsPanel;
        this.myApp.mainPanel.setBounds(30, 30, 400, 400);
        this.myApp.add(myApp.mainPanel);
        this.myApp.setVisible(true);
        this.myApp.mainPanel.setVisible(true);
        this.myApp.repaint();
    }
    
    public void hideStatsPanel()
    {
        if (this.statsPanel!=null)
            {
                this.cleanMainPanel(true);
                this.statsPanel = null;
            }
    }
    
    
    public void menuLoggedInEnabler()
    {
        if (this.appInstance.anonymousUser)
        {
            this.mainMenuBar.disableUserSpecificItems();
        }
        else
            this.mainMenuBar.enableUserSpecificItems();
    }
    
    public void newClassicSudoku()
    {
        this.cleanSidePanel(true);
        this.appInstance.loadNewGame(TypeOfGame.CLASSIC);
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.sudokuPanel = new SudokuPanel(this,TypeOfGame.CLASSIC);
        this.myApp.mainPanel = this.sudokuPanel;
        loadValuesFromGame(this.appInstance.game);
        ClassicSudokuGame classicGame = (ClassicSudokuGame) this.appInstance.game;
        lockValues(classicGame.getIsEditableMatrix());
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    private void loadValuesFromGame(BaseGame game)
    {
        int dim = 0;
        if(game instanceof ClassicSudokuGame)
        {
            ClassicSudokuGame classicGame = (ClassicSudokuGame) game;
            dim = 9;
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    JLabel label = sudokuPanel.getJLabel(i, j);
                    label.setText(String.valueOf(classicGame.getMatrixValue(i, j)));
                    if (label.getText().equals("0"))
                        label.setText("");
                }
            }
        }
        else if(game instanceof HyperSudokuGame)
        {
            dim = 9;
            HyperSudokuGame hyperGame = (HyperSudokuGame) game;                    
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    JLabel label = sudokuPanel.getJLabel(i, j);
                    label.setText(String.valueOf(hyperGame.getMatrixValue(i, j)));
                    if (label.getText().equals("0"))
                        label.setText("");
                }
            }
        }
        else if(game instanceof DuidokuGame)
        {
            dim = 4;
            DuidokuGame duiGame = (DuidokuGame) game;                    
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    if(sudokuPanel==null)
                        JOptionPane.showMessageDialog(null,"FOO!");
                    JLabel label = sudokuPanel.getJLabel(i, j);
                    label.setText(String.valueOf(duiGame.getMatrixValue(i, j)));
                    if (label.getText().equals("0"))
                        label.setText("");
                }
            }
        }
    }
    
    public void lockValue(int i, int j)
    {
        JLabel label = sudokuPanel.getJLabel(i,j);
        label.setFont(new Font("Serif",Font.BOLD,20));
        label.setEnabled(false);
    }
    
    private void lockValues(boolean[][] isEditableMatrix)
    {
        for (int i = 0; i < isEditableMatrix.length; i++) {
            boolean[] bs = isEditableMatrix[i];
            for (int j = 0; j < bs.length; j++) {
               if (!bs[j])
                lockValue(i,j);
            }
        }
    }

    
    public void newHyperSudoku()
    {
        this.cleanSidePanel(true);
        this.appInstance.loadNewGame(TypeOfGame.HYPERDOKU);
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.sudokuPanel = new SudokuPanel(this,TypeOfGame.HYPERDOKU);
        this.myApp.mainPanel = sudokuPanel;
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        loadValuesFromGame(this.appInstance.game);
        HyperSudokuGame hyperGame = (HyperSudokuGame) this.appInstance.game;
        lockValues(hyperGame.getIsEditableMatrix());
        this.myApp.add(myApp.mainPanel);

        this.myApp.mainPanel.setVisible(true);
    }
    
    public void newDuidoku()
    {
        this.cleanSidePanel(true);
        this.appInstance.loadNewGame(TypeOfGame.DUIDOKU);
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.sudokuPanel = new SudokuPanel(this,TypeOfGame.DUIDOKU);
        this.myApp.mainPanel = sudokuPanel;
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void showSudokuCellOptionsPanel(TypeOfGame type, Coord_2D coords)
    {
        this.cleanSidePanel(true);
        if(type == TypeOfGame.CLASSIC || type == TypeOfGame.HYPERDOKU)
        {
            this.sudokuCellOptionsPanel = new SudokuCellOptionsPanel(this, coords);
        }
        else if(type==TypeOfGame.DUIDOKU)
        {
            this.sudokuCellOptionsPanel = new DuidokuCellOptionsPanel(this, coords);
        }
        this.myApp.sideBarPanel = this.sudokuCellOptionsPanel;
        this.myApp.add(myApp.sideBarPanel);
        this.myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.myApp.sideBarPanel.setVisible(true);
        this.myApp.sideBarPanel.repaint();
    }
    
//    public void showDuidokuCellOptions()
//    {
//        if(this.myApp.sideBarPanel!=null)
//        {
//            this.myApp.sideBarPanel.setVisible(false);
//            this.myApp.remove(myApp.sideBarPanel);
//        }
//        this.myApp.sideBarPanel = new DuidokuCellOptionsPanel(this);
//        this.myApp.sideBarPanel.setBounds(600, 140, 200, 250);
//        this.myApp.add(myApp.sideBarPanel);
//
//        this.myApp.sideBarPanel.setVisible(true);
//    }
    
    public void changeSudokuCell(int value, Coord_2D coords)
    {
        if (this.myApp.mainPanel instanceof SudokuPanel)
        {
            SudokuPanel panel = (SudokuPanel) this.myApp.mainPanel;
            if (this.appInstance.game.addNumber(value, coords))
            {
                if (this.appInstance.game instanceof DuidokuGame)
                {
                    this.loadValuesFromGame(this.appInstance.game);
                    DuidokuGame game = (DuidokuGame) this.appInstance.game;
                    this.lockValues(game.getIsEditableMatrix());
                    Person winner;
                    if((winner = game.whoWon())!=null)
                    {
                        JOptionPane.showMessageDialog(myApp, "Congratulations to " + winner.getNickname());
                        this.cleanUpFinishedGame();
                    }
                }
                else
                {
                    panel.selected.setText(Integer.toString(value));
                    if (this.appInstance.game.isCompleted())
                    {
                        JOptionPane.showMessageDialog(myApp, "You Won!");
                        this.cleanUpFinishedGame();
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(myApp, "Invalid Move");
            }  
        }
    }
    
    public void clearSudokuCell(Coord_2D coords)
    {
        if (this.myApp.mainPanel instanceof SudokuPanel)
        {
            this.appInstance.game.addNumber(0, coords);
            SudokuPanel panel = (SudokuPanel) this.myApp.mainPanel;
            panel.selected.setText("");
        }
    }
    
    public void cleanUpFinishedGame()
    {
        this.cleanMainPanel(true);
        this.appInstance.game.onQuitGame(false);
        if (this.appInstance.anonymousUser)
        {
            this.showGettingStartedPanel();
        }
        else
        {
            this.showLoggedInPanel();
        }
    }
    
    public String loadHelpFromHTML()
    {
        // define somewhere the constant of the file
        try(BufferedReader input = new BufferedReader(new FileReader(GlobalConstants.SUDOKUHELP_PATH));)
        {
            String temp;
            StringBuilder s = new StringBuilder();
            while ((temp = input.readLine()) != null )
            {
                s.append(temp);
            }
            return s.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUIHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUIHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Help not available";
    }

}
