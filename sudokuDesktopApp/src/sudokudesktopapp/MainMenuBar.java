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
 *
 * @author Anthony
 */
public class MainMenuBar extends JMenuBar{
    private GUIHandler myGuiHandler;
    
    private JMenu fileMenu;
    private JMenu newGameMenu;
    private JMenuItem classicSudokuItem;
    private JMenuItem hyperSudokuItem;
    private JMenuItem duidokuItem;
    private JMenuItem restorePreviousItem;
    private JMenuItem exitItem;
    
    private JMenu userMenu;
    private JMenuItem loginItem;
    private JMenuItem newUserItem;
    private JMenuItem showStatsItem;
    private JMenuItem deleteHistoryItem;
    
    private JMenu helpMenu;
    private JMenuItem sudokuRulesItem;
    private JMenuItem showHintsItem;
    private JMenuItem aboutItem;
    
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

    
    public void disableUserSpecificItems()
    {
        this.deleteHistoryItem.setEnabled(false);
        this.showStatsItem.setEnabled(false);
        this.newUserItem.setEnabled(true);
        this.restorePreviousItem.setEnabled(false);
    }
    
    public void enableUserSpecificItems()
    {
        this.loginItem.setEnabled(false);
        this.deleteHistoryItem.setEnabled(true);
        this.showStatsItem.setEnabled(true);
        this.restorePreviousItem.setEnabled(true);
        this.newUserItem.setEnabled(false);
    }
}

