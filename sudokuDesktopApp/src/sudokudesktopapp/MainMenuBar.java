/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokudesktopapp;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Custom JMenuBar class for the frame of the application.
 * @author Anthony
 */
public class MainMenuBar extends JMenuBar{
    /**
     * An instance of the GUIHandler.
     */
    private GUIHandler myGuiHandler;
    
    /**
     * Instance of the JMenu used for "File".
     */
    private JMenu fileMenu;
    /**
     * Instance of the JMenu used for "New game", under "File".
     */
    private JMenu newGameMenu;
    /**
     * Instance of the JMenuItem used for "Classic Sudoku", under "New Game".
     */
    private JMenuItem classicSudokuItem;
    /**
     * Instance of the JMenuItem used for "Hyper Sudoku", under "New Game".
     */
    private JMenuItem hyperSudokuItem;
    /**
     * Instance of the JMenuItem used for "Duidoku", under "New Game".
     */
    private JMenuItem duidokuItem;
    /**
     * Instance of the JMenuItem used for "Restore previous game", under "File".
     */
    private JMenuItem restorePreviousItem;
    /**
     * Instance of the JMenuItem used for "Exit", under "File".
     */
    private JMenuItem exitItem;
    
    /**
     * Instance of the JMenu used for "User".
     */
    private JMenu userMenu;
    /**
     * Instance of the JMenuItem used for "Login", under "User".
     */
    private JMenuItem loginItem;
    /**
     * Instance of the JMenuItem used for "Create New User", under "User".
     */
    private JMenuItem newUserItem;
    /**
     * Instance of the JMenuItem used for "Show stats", under "User".
     */
    private JMenuItem showStatsItem;
    /**
     * Instance of the JMenuItem used for "Delete history", under "User".
     */
    private JMenuItem deleteHistoryItem;
    
    /**
     * Instance of the JMenu used for "Help".
     */
    private JMenu helpMenu;
    /**
     * Instance of the JMenuItem used for "Show sudoku rules", under "Help".
     */
    private JMenuItem sudokuRulesItem;
    /**
     * Instance of the JCheckBoxMenuItem used for "Show hints", under "Help".
     */
    private JCheckBoxMenuItem showHintsItem;
    /**
     * Instance of the JMenuItem used for "About", under "Help".
     */
    private JMenuItem aboutItem;
    
    /**
     * Default constructor.
     * Initializing all member variables, adding the menu items to their menus
     * and handling the event for each click.
     * @param handler 
     */
    public MainMenuBar(GUIHandler handler)
    {
        super();
        this.myGuiHandler = handler;
        fileMenu = new JMenu("File");
        
        newGameMenu = new JMenu("New game");
        classicSudokuItem = new JMenuItem("Classic sudoku");
        classicSudokuItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.newClassicSudoku();
            }
        }
        );
        hyperSudokuItem = new JMenuItem("HyperSudoku");
        hyperSudokuItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.newHyperSudoku();
            }
        
        });
        duidokuItem = new JMenuItem("Duidoku");
        duidokuItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.newDuidoku();
            }
            
        });
        newGameMenu.add(classicSudokuItem);
        newGameMenu.add(hyperSudokuItem);
        newGameMenu.add(duidokuItem);
        fileMenu.add(newGameMenu);
        restorePreviousItem = new JMenuItem("Restore previous game");
        restorePreviousItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Foo");
            }
            
        });
        fileMenu.add(restorePreviousItem);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Foo");
            }
            
        });
        fileMenu.add(exitItem);
        add(fileMenu);
        
        
        userMenu = new JMenu("User");
        loginItem = new JMenuItem("Login");
        loginItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.showLogInPanel();
            }
            
        });
        newUserItem = new JMenuItem("Create new user");
        newUserItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.showAddNewUserPanel();
            }
        
        });
        showStatsItem = new JMenuItem("Show stats");
        showStatsItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.showStatsPanel();
            }
            
        });
        deleteHistoryItem = new JMenuItem("Delete history");
        deleteHistoryItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {//
                
            }
            
        });
        userMenu.add(loginItem);
        userMenu.add(newUserItem);
        userMenu.add(showStatsItem);
        userMenu.add(deleteHistoryItem);
        add(userMenu);
        
        helpMenu = new JMenu("Help");
        sudokuRulesItem = new JMenuItem("Show sudoku rules");
        sudokuRulesItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.showHelpDialog();
            }
            
        });
        showHintsItem = new JCheckBoxMenuItem("Show hints");
        showHintsItem.getModel().setSelected(true);
        showHintsItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (showHintsItem.getModel().isEnabled())
                    myGuiHandler.toggleShowHints();
                myGuiHandler.updateHintsFromSudokuCellOptionsPanel();
                    
                }
        });
        
        
        aboutItem = new JMenuItem("About..");
        aboutItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.showAboutDialog();
            }
            
        });
        helpMenu.add(sudokuRulesItem);
        helpMenu.add(showHintsItem);
        helpMenu.add(aboutItem);
        add(helpMenu);
    }

    /**
     * Function that disables all options in menus that are user specific.
     * That is to say "Delete History", "Show Stats" and "Restore Previous game".
     * It also enables the "New user" item.
     */
    public void disableUserSpecificItems()
    {
        this.deleteHistoryItem.setEnabled(false);
        this.showStatsItem.setEnabled(false);
        this.newUserItem.setEnabled(true);
        this.restorePreviousItem.setEnabled(false);
    }
    
    /**
     * Function that enables all options in menus that are user specific.
     * That is to say "Delete History", "Show Stats" and "Restore Previous game".
     * It also disables the "Login" item.
     */
    public void enableUserSpecificItems()
    {
        this.loginItem.setEnabled(false);
        this.deleteHistoryItem.setEnabled(true);
        this.showStatsItem.setEnabled(true);
        this.restorePreviousItem.setEnabled(true);
        this.newUserItem.setEnabled(false);
    }
}

