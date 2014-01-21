/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import Logic.Sudoku.ClassicSudokuGame;
import Logic.Sudoku.TypeOfGame;
import Logic.Users.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    private NewUserPanel newUserPanel;
    private LogInPanel loginPanel;
    private LoggedInPanel loggedInPanel;
    private SudokuHelpDialog sudokuHelpDialog;
    private StatsPanel statsPanel;
    private AboutDialog aboutDialog;
    
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
        this.myApp.mainPanel.setBounds(120, 120, 250, 250);
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
        this.appInstance.game = new ClassicSudokuGame();
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.myApp.mainPanel = new SudokuPanel(this,TypeOfGame.CLASSIC, 9, 9);
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void newHyperSudoku()
    {
        this.cleanSidePanel(true);
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.myApp.mainPanel = new SudokuPanel(this,TypeOfGame.HYPERDOKU, 9, 9);
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void newDuidoku()
    {
        this.cleanSidePanel(true);
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.myApp.mainPanel = new SudokuPanel(this,TypeOfGame.DUIDOKU,4,4);
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void showSudokuCellOptions(TypeOfGame type)
    {
        if(this.myApp.sideBarPanel!=null)
        {
            this.myApp.sideBarPanel.setVisible(false);
            this.myApp.remove(myApp.sideBarPanel);
        }
        if(type == TypeOfGame.CLASSIC || type == TypeOfGame.HYPERDOKU)
            this.myApp.sideBarPanel = new SudokuCellOptionsPanel(this);
        else if(type==TypeOfGame.DUIDOKU)
            this.myApp.sideBarPanel = new DuidokuCellOptionsPanel(this);
        this.myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.myApp.add(myApp.sideBarPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.sideBarPanel.setVisible(true);
    }
    
    public void showDuidokuCellOptions()
    {
        if(this.myApp.sideBarPanel!=null)
        {
            this.myApp.sideBarPanel.setVisible(false);
            this.myApp.remove(myApp.sideBarPanel);
        }
        this.myApp.sideBarPanel = new DuidokuCellOptionsPanel(this);
        this.myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.myApp.add(myApp.sideBarPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.sideBarPanel.setVisible(true);
    }
    
    public void changeSudokuCell(int value)
    {
        if (this.myApp.mainPanel instanceof SudokuPanel)
        {
            SudokuPanel panel = (SudokuPanel) this.myApp.mainPanel;
            panel.selected.setText(Integer.toString(value));
        }
    }
    
    public void clearSudokuCell()
    {
        if (this.myApp.mainPanel instanceof SudokuPanel)
        {
            SudokuPanel panel = (SudokuPanel) this.myApp.mainPanel;
            panel.selected.setText("");
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
