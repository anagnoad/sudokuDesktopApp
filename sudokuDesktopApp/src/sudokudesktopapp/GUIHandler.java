/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import javax.swing.JFrame;

/**
 * The controller of all the GUI elements in the application.
 * Follows the MVC paradigm.
 * @author Steve
 */
public class GUIHandler {
    // create the application instance class
    private Application myApp; // access modifier may need to change
    private GettingStartedPanel gettingStartedPanel;
    private NewUserPanel newUserPanel;
    
    
    public void showAddNewUser() // is supposed to be called when the user wishes to create new user
    {
        // if the action is coming from the gettingStartedPanel
        if (this.gettingStartedPanel.isVisible())
            this.gettingStartedPanel.setVisible(false);
        
        // show the panel to create the new user
        this.newUserPanel = new NewUserPanel();
        this.myApp.add(this.newUserPanel);
        this.newUserPanel.setVisible(true);
    }
    
    public void addNewUser(String nickname)
    {
        // add the user to the db saved in the application instance
    }
    
    public void logIn() // is supposed to be called when the user wishes to login
    {
    
    }
    
    
    
}
