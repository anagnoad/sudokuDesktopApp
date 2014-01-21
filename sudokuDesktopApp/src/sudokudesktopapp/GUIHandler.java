/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import Logic.Sudoku.ClassicSudokuGame;
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
    private static final String helpPath = "./resources/sudoku_help.html";
    
    /* -------------------GUI elements-------------------------*/
    private Application myApp; // access modifier may need to change
    private GettingStartedPanel gettingStartedPanel;
    private NewUserPanel newUserPanel;
    private LogInPanel loginPanel;
    private SudokuHelpDialog sudokuHelpDialog;
    private StatsPanel statsPanel;
    
    /*--------------------------Methods------------------------------*/
    //ctor
    public GUIHandler(ApplicationInstance appInstance)
    {
        this.appInstance = appInstance;
        // show the main frame
        this.myApp = new Application(this);
        this.myApp.setVisible(true);
        this.showGettingStartedPanel();
    }
    
//---------------------------gettingStartedPanel Methods-------------------------------------------    
    
    public void showGettingStartedPanel() // is supposed to be called on launch
    {
        if (this.gettingStartedPanel == null)
        {
            this.gettingStartedPanel = new GettingStartedPanel(this);
            this.gettingStartedPanel.setVisible(true);
        }
        else
            if (this.gettingStartedPanel.isVisible())
            {/* already visible, nothing to be done*/}
            else
            {
                this.gettingStartedPanel.setVisible(true);
            }
    }
    
    public void closeGettingStartedPanel()
    {
        if (this.gettingStartedPanel == null)
        {/* nothing to be done*/}
        else
        {
            if (this.gettingStartedPanel.isVisible())
            {
                this.gettingStartedPanel.setVisible(false);
            }
            else
            {/* nothing to be done*/}
        }
    }
 //------------------------------------------------------------------------------------------------
    
//---------------------------addNewUserPanel methods-------------------------------------------     
    public void showAddNewUserPanel() // is supposed to be called when the user wishes to create new user
    {
        
        // if the action is coming from the gettingStartedPanel
        if (this.gettingStartedPanel.isVisible())
            this.gettingStartedPanel.setVisible(false);
        
        // show the panel to create the new user
        
        this.myApp.sideBarPanel.setVisible(false);
        this.myApp.remove(myApp.sideBarPanel);
        this.newUserPanel = new NewUserPanel(this);
        this.newUserPanel.setVisible(true);

        this.myApp.sideBarPanel = this.newUserPanel;
        this.myApp.sideBarPanel.setBounds(600, 140, 200, 250);
        this.myApp.add(myApp.sideBarPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.sideBarPanel.setVisible(true);

    }
    
        public void hideAddNewUserPanel()
    {
        if (this.newUserPanel!=null)
        {
            this.newUserPanel.setVisible(false); // hide the panel
            this.myApp.remove(this.newUserPanel); // remove it from the JFrame
            this.newUserPanel = null; // let the GC delete the Panel
        }
    }
    
 //------------------------------------------------------------------------------------------------
        
        
    public void addNewUser(String nickname)
    {
        // add the user to the db saved in the application instance
        Person player = this.appInstance.playersDB.addNewPerson(nickname);
        if (player != null)
        {
            // login to the current user
            this.appInstance.login(player);
        }
        else
        {
            // thow exception or/and show message
        }
    }
    
    
    public void showLogInPanel()
    {
        // if the action is coming from the gettingStartedPanel
        if (this.gettingStartedPanel.isVisible())
            this.gettingStartedPanel.setVisible(false);
        
        if (this.loginPanel == null)
            this.loginPanel = new LogInPanel(this);
        this.myApp.add(loginPanel);
        this.loginPanel.setVisible(true);
        
        this.myApp.repaint();
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
    
    
    public void showStatsPanel()
    {
        if (this.statsPanel == null)
        {
            this.statsPanel = new StatsPanel(this, appInstance.loggedInUser);
            this.myApp.add(statsPanel);
        }
        if (!this.statsPanel.isVisible())
            this.statsPanel.setVisible(true);
        
        this.myApp.repaint();
    }
    
    public void hideStatsPanel()
    {
        if (this.statsPanel != null && this.statsPanel.isVisible())
        {
            this.statsPanel.setVisible(false);
            this.myApp.remove(this.statsPanel);
            this.myApp.repaint();
            this.statsPanel = null;
        }
    }
    
    
    public void newClassicSudoku()
    {
        this.appInstance.game = new ClassicSudokuGame();
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.myApp.mainPanel = new SudokuPanel(this, 9, 9);
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void newHyperSudoku()
    {
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.myApp.mainPanel = new SudokuPanel(this, 9, 9);
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void newDuidoku()
    {
        if(this.myApp.mainPanel!=null)
        {
            this.myApp.mainPanel.setVisible(false);
            this.myApp.remove(myApp.mainPanel);
        }
        this.myApp.mainPanel = new SudokuPanel(this, 4, 4);
        this.myApp.mainPanel.setBounds(20, 20, 520, 520);
        this.myApp.add(myApp.mainPanel);
        this.myApp.getContentPane().validate();
        this.myApp.getContentPane().repaint();
        this.myApp.mainPanel.setVisible(true);
    }
    
    public void showSudokuCellOptions()
    {
        if(this.myApp.sideBarPanel!=null)
        {
            this.myApp.sideBarPanel.setVisible(false);
            this.myApp.remove(myApp.sideBarPanel);
        }
        this.myApp.sideBarPanel = new SudokuCellOptionsPanel(this);
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
        try(BufferedReader input = new BufferedReader(new FileReader(helpPath));)
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
