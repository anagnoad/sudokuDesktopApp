/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokudesktopapp;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
    
    private JMenu editMenu;
    
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
        fileMenu.add(restorePreviousItem);
        add(fileMenu);
        
        editMenu = new JMenu("Edit");
        add(editMenu);
        
        userMenu = new JMenu("User");
        loginItem = new JMenuItem("Login");
        newUserItem = new JMenuItem("Create new user");
        newUserItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                myGuiHandler.showAddNewUserPanel();
            }
        
        });
        showStatsItem = new JMenuItem("Show stats");
        deleteHistoryItem = new JMenuItem("Delete history");
        userMenu.add(loginItem);
        userMenu.add(newUserItem);
        userMenu.add(showStatsItem);
        userMenu.add(deleteHistoryItem);
        add(userMenu);
        
        helpMenu = new JMenu("Help");
        sudokuRulesItem = new JMenuItem("Show sudoku rules");
        showHintsItem = new JMenuItem("Show hints");
        aboutItem = new JMenuItem("About..");
        helpMenu.add(sudokuRulesItem);
        helpMenu.add(showHintsItem);
        helpMenu.add(aboutItem);
        add(helpMenu);
    }

}

