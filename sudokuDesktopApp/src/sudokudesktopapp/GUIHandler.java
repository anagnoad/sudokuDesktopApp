/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

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
        this.newUserPanel = new NewUserPanel(this);
        this.myApp.add(this.newUserPanel);
        this.newUserPanel.setVisible(true);
<<<<<<< HEAD
        
        this.myApp.repaint();
    }
    
        public void closeAddNewUserPanel()
    {
        this.newUserPanel.setVisible(false); // hide the panel
        this.newUserPanel = null; // let the GC delete the Panel
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
