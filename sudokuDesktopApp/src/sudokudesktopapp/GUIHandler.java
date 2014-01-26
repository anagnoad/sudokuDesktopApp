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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 * The controller of all the GUI elements in the application.
 * Follows the MVC paradigm.
 * @author Steve
 */
public class GUIHandler {
    /*-------------------------------------------------Member vars-----------------------------------------------------*/
    /*--------------------Logic elements ----------------------*/
    /**
     * The application instance of the app.
     */
    private ApplicationInstance appInstance; // knows the application instance
    
    /**
     * Boolean value to save the preference of the user according to the relevant checkbox in the menu.
     */
    public boolean showHints;
    
    /**
     * Boolean value to save the preference of the user according to the relevant option of the games.
     */
    public boolean showWordoku;
    
    /* -------------------GUI elements-------------------------*/
    /**
     * Instance of the main frame of the application.
     * The application is presented in this frame and contains all of the panels listed below.
     */
    private Application myApp;
    
    /**
     * Instance of the menuBar in the application frame.
     * The menu bar that is shown in the applicaiton window.
     */
    private MainMenuBar mainMenuBar;
    
    /**
     * Instance of the Getting Started JPanel .
     * A panel that is shown when the application starts.
     */
    private GettingStartedPanel gettingStartedPanel;
    
    /**
     * Instance of the Sudoku Panel.
     * A panel that is shown when a user (anonymous or not) plays a game.
     */
    private SudokuPanel sudokuPanel;
    
    /**
     * Instance of the Sudoku Cell Options panel.
     * A panel that presents the user with the available actions during a game.
     */
    private SudokuCellOptionsPanel sudokuCellOptionsPanel;
    
    /**
     * Instance of the New User panel.
     * A panel that is shown when a new user is added to the application.
     */
    private NewUserPanel newUserPanel;
    
    /**
     * Instance of the New Game Options Panel.
     * A panel that is shown when the new game is selected from the Getting Started Panel.
     */
    private NewGameOptionsPanel newGameOptionsPanel;
    
    /**
     * Instance of the Log in panel.
     * A panel that is shown when the user tries to login.
     */
    private LogInPanel loginPanel;
    
    /**
     * Instance of the Logged In panel.
     * A panel that is shown when the user logs in the application.
     */
    private LoggedInPanel loggedInPanel;
    
    /**
     * Instance of the Sudoku Help Window dialog.
     * A window that is shown when the relevant option is selected by the main menu bar of the application.
     */
    private SudokuHelpDialog sudokuHelpDialog;
    
    /**
     * Instance of the Stats Panel.
     * A panel that is shown when a user is logged in and ask for their statistics.
     */
    private StatsPanel statsPanel;
    
    /**
     * Instance of the about window dialog.
     * A window that is show when the relevant option is selected from the main menu bar.
     */
    private AboutDialog aboutDialog;
    
    /**
     * Window adapter for the main application's frame.
     */
    private WindowAdapter myAppWindowAdapter;
    
    /*--------------------------------------------------------Methods------------------------------------------------------------*/
    /**
     * Ctor accepting the ApplicationInstance as a parameter.
     * @param appInstance the instance of the application.
     */
    public GUIHandler(ApplicationInstance appInstance)
    {
        // What it does ...
        // 1. creates the application fram
        // 2. adds the Window Adapter to listen to it
        // 3. adds the main menu to the application form
        // 4. adds the Getting Started Panel to the Side Bar
        
        // 1.
        this.appInstance = appInstance;
        this.myApp = new Application(this);
        
        // 2.
        this.myAppWindowAdapter = new customizedWindowAdapter(this);
        this.myApp.addWindowListener(myAppWindowAdapter);
                
        // 3.
        this.mainMenuBar = new MainMenuBar(this);
        this.menuLoggedInEnabler();
        myApp.setJMenuBar(this.mainMenuBar);
        this.showHints = true;
        this.showWordoku = false;
        
        // 4.
        this.showGettingStartedPanel();
        this.myApp.setVisible(true);
        
        
    }
    
    /**
     * Cleans the main panel from its contents.
     * @param toBeNulled true if you need the content to be set to null; false otherwise.
     */
    private void cleanMainPanel(boolean toBeNulled)
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
    
    /**
     * Cleans the side panel from its contents.
     * @param toBeNulled true if you need the content to be set to null; false otherwise.
     */
    private void cleanSidePanel(boolean toBeNulled)
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
    
    /**
     * Enables/Disables menu options according to if the user is logged in or not.
     */
    public void menuLoggedInEnabler()
    {
        if (this.appInstance.anonymousUser)
        {
            this.mainMenuBar.disableUserSpecificItems();
        }
        else
            this.mainMenuBar.enableUserSpecificItems();
    }
    
   /**
    * Toggles on/off the Wordoku options with the relevant changes in the ui of the game.
    */ 
    public void toggleWordoku()
    {
        this.showWordoku = !this.showWordoku;
    }
    
    /**
     * Toggles on/off the ShowHints feature of the game according to the selection of the user.
     */
    public void toggleShowHints()
    {
        this.showHints = !this.showHints;
        //JOptionPane.showMessageDialog(newUserPanel, showHints);
    }
    
    /**
     * Shows the About Dialog when the relevant selection is made from the main menu.
     * Contains information about the developers and contact info.
     */
    public void showAboutDialog()
    {
        this.aboutDialog = new AboutDialog(myApp, true);
        this.aboutDialog.setVisible(true);
    }
    
    /**
     * Shows the help dialog window when the relevant selection from the main menu is made.
     */
    public void showHelpDialog() //works
    {
        this.sudokuHelpDialog = new SudokuHelpDialog(myApp, true, this);
        this.sudokuHelpDialog.setVisible(true);
    }
    
    /**
     * Load the HTML file containing help for the Sudoku gameplay.
     * @return a string with the file contents
     */
    public String loadHelpFromHTML()    // this may need to go to the IO class
    {
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
    
    
    /*-------------------------------- Show/Hide panels from the application frame -------------------------------------/
    
    /*--------------------Getting Started Panel --------------------*/
    /**
     * Shows the Getting Started Panel in the side panel of the main application frame.
     */
    public void showGettingStartedPanel()
    {
        // Check if this is the first time this panel is launched
        if (this.gettingStartedPanel == null)
        {
            // if yes, initialize the panel.
            this.gettingStartedPanel = new GettingStartedPanel(this);
        }
        
        // add it to the side-bar of the main application and make it visible
        myApp.sideBarPanel = this.gettingStartedPanel;
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        myApp.add(myApp.sideBarPanel);
        myApp.sideBarPanel.setVisible(true);
    }
    
    /**
     * Hides the Getting Started Panel from the side panel of the main application frame.
     */
    public void hideGettingStartedPanel()
    {
        // if the value is null, there is nothing to be done.
       if (this.gettingStartedPanel == null)
       {/* Nothing to be done */}
       else
       {
           // Clean the side bar panel.
           // Don't set the value to null, because the Getting Started Panel does not ever change.
           this.cleanSidePanel(false);
       }
    }
    
    /*--------------------Add New User panel --------------------*/
    /**
     * Shows the Add New User panel in the main panel of the application frame.
     */
    public void showAddNewUserPanel() // is supposed to be called when the user wishes to create new user
    {
        /*
         * 1. Hides the gettingStartedPanel
         * 2. Cleans up the main panel.
         * 3. Shows the newUser panel to the mainPanel of the application frame
         */
        
        
        // 1.
        this.hideGettingStartedPanel();
        
        // 2.
        this.cleanMainPanel(true);
        this.newUserPanel = new NewUserPanel(this);
        
        // 3.
        this.myApp.mainPanel = newUserPanel;
        this.myApp.mainPanel.setBounds(120, 120, 350, 350);
        this.myApp.add(myApp.mainPanel);
        this.myApp.setVisible(true);
        this.myApp.repaint();
    }
    
    /**
     * Hide the Add New User panel from the main panel of the application frame.
     */
    public void hideAddNewUserPanel()
    {
        // if this panel is null, there is nothing to be made.

        if (this.newUserPanel!=null)
        {
            // we want it to be nulled after cleaning because it is user specific.
            this.cleanMainPanel(true);
            this.newUserPanel = null;
        }
    }

    /*--------------------Log In panel --------------------*/
    /**
     * Shows the Login panel in the main panel of the application frame.
     */
    public void showLogInPanel()
    {
        /*
         * 1. Hide the gettingStartedPanel.
         * 2. Clean the main panel from its contents.
         * 2. Show the logInPanel to the mainPanel of the application frame.
         */
        
        
        // 1.
        this.hideGettingStartedPanel();
        
        // 2.
        this.cleanMainPanel(true);
        this.loginPanel = new LogInPanel(this);
        
        // 3.
        this.myApp.mainPanel = loginPanel;
        this.myApp.mainPanel.setBounds(120, 120, 400, 300);
        this.myApp.add(myApp.mainPanel);
        this.myApp.setVisible(true);
        this.myApp.repaint();
    }
    
    /**
     * Hides the Login panel from the main panel of the application frame.
     */
    public void hideLoginPanel()
    {
        // if it is null, there is nothing to be made.
         if (this.loginPanel!=null)
            {
                this.cleanMainPanel(true);
                this.newUserPanel = null;
            }
    }
    
    /*--------------------Logged In panel --------------------*/
    /**
     * Shows the Logged In panel in the side bar of the application frame.
     */
    public void showLoggedInPanel()
    {
        /*
         * 1. Clean the main panel
         * 2. Create the logged in panel
         * 3. Add it to the main panel of the application
         */
        
        // 1.
        this.cleanSidePanel(true);
        
        // 2.
        if (this.loggedInPanel == null)
        {
            this.loggedInPanel = new LoggedInPanel(this);
        }
        
        // 3.
        myApp.sideBarPanel = this.loggedInPanel;
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        myApp.add(myApp.sideBarPanel);
        myApp.sideBarPanel.setVisible(true);
    }
    
    /**
     * Hide the Logged In panel from the side bar of the application frame.
     */
    public void hideLoggedInPanel()
    {
        // We don't want it nulled since it's the same for every user.
        this.cleanSidePanel(false);
    }
    
    
    /*--------------------Stats panel --------------------*/
    /**
     * Shows the Statistics panel in the main panel of the application.
     */
    public void showStatsPanel()
    {
        /*
         * 1. Clean the main panel from its contents.
         * 2. Create the stats panel,
         * 3. Add the stats panel to the main panel of the frame.
         */
        
        // 1.
        this.cleanMainPanel(true);
        
        // 2.
        if (this.statsPanel == null)
        {
            //Debug/System.out.println(appInstance.loggedInUser.getNickname()+"...");
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
        
        // 3.
        this.myApp.mainPanel = this.statsPanel;
        this.myApp.mainPanel.setBounds(30, 30, 400, 400);
        this.myApp.add(myApp.mainPanel);
        this.myApp.setVisible(true);
        this.myApp.mainPanel.setVisible(true);
        this.myApp.repaint();
    }
    
    /**
     * Hides the Statistics panel from the main panel of the application.
     */
    public void hideStatsPanel()
    {
        if (this.statsPanel!=null)
            {
                this.cleanMainPanel(true);
                this.statsPanel = null;
            }
    }
    
    /*--------------------New Game Options Panel --------------------*/
    /**
     * Shows the New Game Options Panel in the main panel of the application.
     */
    public void showNewGameOptionsPanel()
    {
        /*
         * 1. Clear the side panel.
         * 2. Create the New Game panel.
         * 3. Add it to the main panel of the application frame.
        */
        
        // 1.
        this.cleanSidePanel(true);
        
        // 2.
        if (this.newGameOptionsPanel==null)    
            this.newGameOptionsPanel = new NewGameOptionsPanel(this);
        // 3.
        this.myApp.sideBarPanel = this.newGameOptionsPanel;
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.myApp.add(myApp.sideBarPanel);
        this.myApp.sideBarPanel.setVisible(true);
    }
    
    /**
     * Hides the New Game Options Panel from the main panel of the application.
     */
    public void hideNewGameOptionsPanel()
    {
        // Don't make it null, since it is the same for all the players/games.
        this.cleanMainPanel(false);
    }
    
    /*------------------------- Game Panels -----------------------------*/
    
    /**
     * Shows the Classic Sudoku Game to the main panel of the application.
     */
    private void showClassicSudokuGame()
    {
        /*
         * 1. Clean the main panel from its contents.
         * 2. Clean the side bar from its contents.
         * 3. Create new sudoku panel.
         * 4. Ininitalize the game. Check for wordoku option.
         * 5. Lock the values that are from the sudoku.
         * 6. Add it to the main panel.
         */
        
        // 1,
        this.cleanMainPanel(false);
        
        // 2.
        this.cleanSidePanel(true);

        // 3.
        this.sudokuPanel = new SudokuPanel(this,TypeOfGame.CLASSIC);

        // 4.
        loadValuesFromGame(this.appInstance.game);
        ClassicSudokuGame classicGame = (ClassicSudokuGame) this.appInstance.game;
        if(this.showWordoku)
            changeToWordoku(classicGame);
        
        // 5.
        lockValues(classicGame.getIsEditableMatrix());
        
        // 6.
        this.myApp.mainPanel = this.sudokuPanel;
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    /**
     * Shows the HyperSudoku Game to the main panel of the application.
     */
    private void showHyperSudokuGame()
    {
        /*
         * 1. Clean the main panel from its contents.
         * 2. Clean the side bar from its contents.
         * 3. Create new sudoku panel.
         * 4. Ininitalize the game. Check for wordoku option.
         * 5. Lock the values that are from the sudoku.
         * 6. Add it to the main panel.
         */
        
        // 1.
        this.cleanMainPanel(false);
        
        // 2.
        this.cleanSidePanel(true);
        
        // 3.
        this.sudokuPanel = new SudokuPanel(this,TypeOfGame.HYPERDOKU);
        
        // 4. 
        loadValuesFromGame(this.appInstance.game);
        HyperSudokuGame hyperGame = (HyperSudokuGame) this.appInstance.game;
        if(this.showWordoku)
            changeToWordoku(hyperGame);
        
        // 5.
        lockValues(hyperGame.getIsEditableMatrix());
        
        //6.
        this.myApp.mainPanel = sudokuPanel;
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.mainPanel.setVisible(true);
    }
    
    /**
     * Shows the Duidoku Game to the main panel of the application.
     */
    private void showDuidokuGame()
    {
        /*
         * 1. Clean the main panel from its contents.
         * 2. Clean the side bar from its contents.
         * 3. Create new sudoku panel.
         * 4. Add it to the main panel.
         */
        
        // 1.
        this.cleanMainPanel(false);
        
        // 2.
        this.cleanSidePanel(true);
        
        // 3.
        this.sudokuPanel = new SudokuPanel(this,TypeOfGame.DUIDOKU);
        
        // 4.
        this.myApp.mainPanel = sudokuPanel;
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.mainPanel.setVisible(true);
    }
    
    /**
     * Shows the Sudoku Cell Options panel to the sidebar of the main application frame, when a cell is selected.
     * @param type The type of the game played.
     * @param coords The coordinates of the cell celected
     */
    public void showSudokuCellOptionsPanel(TypeOfGame type, Coord_2D coords)
    {
        // 1. Clear the sidepanel.
        // 2. Show the newGameOptionsPanel
        
        // 1)
        this.cleanSidePanel(true);
        
        //2
        if(type == TypeOfGame.CLASSIC || type == TypeOfGame.HYPERDOKU)
        {
            this.sudokuCellOptionsPanel = new SudokuCellOptionsPanel(this, coords);
        }
        else if(type==TypeOfGame.DUIDOKU)
        {
            this.sudokuCellOptionsPanel = new DuidokuCellOptionsPanel(this, coords);
        }
        JComboBox choicesComboBox = this.sudokuCellOptionsPanel.getChoicesComboBox();
        if(this.showWordoku)
        {
            if(this.sudokuCellOptionsPanel instanceof DuidokuCellOptionsPanel)
                choicesComboBox.setModel(new DefaultComboBoxModel(new String[] { 
                    "A", "B", "C", "D"
                }));
            else
                choicesComboBox.setModel(new DefaultComboBoxModel(new String[] { 
                    "A", "B", "C", "D", "E", "F", "G", "H", "I"
                }));
        }
        this.myApp.sideBarPanel = this.sudokuCellOptionsPanel;
        this.myApp.add(myApp.sideBarPanel);
        myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.updateHintsFromSudokuCellOptionsPanel();
        this.myApp.sideBarPanel.revalidate();
        this.myApp.sideBarPanel.repaint();
        this.myApp.sideBarPanel.setVisible(true);    
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
    
    /**
     * Hides the current game if finished and returns to the Getting Started screen, if not logged in, or in the Logged In screen.
     */
    public void cleanUpFinishedGame()
    {
        this.cleanMainPanel(true);
        this.cleanSidePanel(true);
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
    
    /*------------------------------------------ Helper Methods ------------------------------------------*/
    
    /**
     * Adds a new user to the database and logs them in.
     * @param the nickname given by the player. 
     */
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
    
     /*
      * Logs in the give person to the application instance and the game.
      */
    public void login(Person person)
    {
        this.appInstance.login(person);
        this.mainMenuBar.enableUserSpecificItems();
        System.out.println(this.appInstance.loggedInUser);
    }
     
    /**
     * Performs a search to the Person DB for the given nickname.
     * @param nicknameToSearch the nickname for which we are searching.
     * @return a list of the result matching the nickname given.
     */
    public ArrayList<Person> searchByNickname(String nicknameToSearch)
    {
        ArrayList<Person> listToReturn;
        listToReturn = this.appInstance.playersDB.searchByNickName(nicknameToSearch);
        return listToReturn; // may return null
    }
    
    /**
     * Resets the player statistics when the relevant button is pressed.
     */
    public void resetPlayer()
    {
        if (!this.appInstance.anonymousUser)
            this.appInstance.loggedInUser.reset();
    }
    
    /**
     * Is called when a saved game is available for the current user and is loaded from memory.
     * @return true if loaded, false otherwise.
     */
    public boolean continueGame()
    {
        if (this.appInstance.loadGame())
        {
            if (this.appInstance.game instanceof ClassicSudokuGame)
            {
                this.showClassicSudokuGame();
            }
            else if (this.appInstance.game instanceof HyperSudokuGame)
            {
                this.showHyperSudokuGame();
            }
            else if (this.appInstance.game instanceof DuidokuGame)
            {
                this.showDuidokuGame();
            }
            return true;
        }
        return false;
        
    }
    
    /**
     * Loads a new classic sudoku game and shows it to the main panel of the application.
     */
    public void newClassicSudoku()
    {
       this.appInstance.loadNewGame(TypeOfGame.CLASSIC);
       this.showClassicSudokuGame();
    }

    /**
     * Loads a new HyperSudoku game and shows it to the main panel of the application.
     */
    public void newHyperSudoku()
    {
            this.appInstance.loadNewGame(TypeOfGame.HYPERDOKU);
            this.showHyperSudokuGame();
    }
    
    /**
     * Loads a new Duidoku game and shows it to the main panel of the application.
     */
    public void newDuidoku()
    {
        this.appInstance.loadNewGame(TypeOfGame.DUIDOKU);
        this.showDuidokuGame();
    }
    
    /**
     * Loads the values from a presaved game and shows it to the board of the Sudoku Panel.
     * @param game the presaved game to load from.
     */
    private void loadValuesFromGame(BaseGame game)
    {
        int dim = 0; // takes values according to the type of the sudoku.
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
    
    /**
     * Locks a cell in which the player cannot play.
     * @param i The row of the cell.
     * @param j The column of the cell.
     */
    public void lockValue(int i, int j)
    {
        JLabel label = sudokuPanel.getJLabel(i,j);
        label.setFont(new Font("Serif",Font.BOLD,20));
        label.setEnabled(false);
    }
    
    /**
     * Locks all the values specified by the relevant matrix inside each Sudoku type.
     * @param isEditableMatrix 
     */
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

    /**
     * Changes the sudoku cell, when a selection is made from the combobox in the sidebar panel.
     * @param value The value selected.
     * @param coords The coordinates of the cell.
     */
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
                    if(this.showWordoku)
                        this.changeToWordoku(this.appInstance.game);
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
                    String numvalue =Integer.toString(value);
                    if(this.showWordoku)
                    {
                        numvalue = GlobalConstants.wordokuMap.get(numvalue);
                    }
                    panel.selected.setText(numvalue);
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
    
    /**
     * Clears what the selected cell contains.
     * @param coords The coordinates of the cell selected.
     */
    public void clearSudokuCell(Coord_2D coords)
    {
        if (this.myApp.mainPanel instanceof SudokuPanel)
        {
            this.appInstance.game.addNumber(0, coords);
            SudokuPanel panel = (SudokuPanel) this.myApp.mainPanel;
            panel.selected.setText("");
        }
    }
    
    /**
     * Shows the hints for the selected cell according to the values of the boards.
     * @param selectedCoordinates The coordinates of the cell
     */
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
            if(this.showWordoku)
            {
                for (int i=0;i<playableNumbers.length;i++)
                {
                    str.append(String.valueOf(GlobalConstants.wordokuMap.get(String.valueOf(playableNumbers[i]))));
                    str.append(" ");
                }
            }
            else
            {
                for (int i=0;i<playableNumbers.length;i++)
                {
                    str.append(String.valueOf(playableNumbers[i]));
                    str.append(" ");
                }
            }
            this.sudokuCellOptionsPanel.getShowHintsLabel().setText(str.toString());
        }
    }
    
    
    /**
     * Updates the hints given by the options pane according to the updated board.
     */
    public void updateHintsFromSudokuCellOptionsPanel()
    {
        if (this.sudokuCellOptionsPanel!=null)
            this.sudokuCellOptionsPanel.getShowHintsLabel().setVisible(this.showHints);
    }
    
    /**
     * Changes the board to wordoku game.
     * @param game The game played by the user currently.
     */
    private void changeToWordoku(BaseGame game)
    {
        int dim = 0;
        if (game instanceof ClassicSudokuGame || game instanceof HyperSudokuGame)
        {
            dim = 9;
        }
        else if(game instanceof DuidokuGame)
        {
            dim = 4;
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                JLabel label = sudokuPanel.getJLabel(i,j);
                if (!label.getText().equals(""))
                    label.setText(GlobalConstants.wordokuMap.get(label.getText()));
            }
        }
    }
    
    
     /**
     * Shows a dialog window to save the current game played if the user is logged in.
     * @return true if saved, false otherwise.
     */
    public boolean showOnCloseDialog()
    {
        boolean toSave = false;
        System.out.println("ShowOnCloseDialog --outside");
        if (!this.appInstance.anonymousUser && this.appInstance.game!=null)
        {
//            System.out.println("ShowOnCloseDialog--inside");
            toSave = JOptionPane.showConfirmDialog(myApp, "Save state?","Really",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
        }
//        System.out.println("ToSave?");
//        System.out.println(toSave);
        return appInstance.saveOnClose(toSave);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    


