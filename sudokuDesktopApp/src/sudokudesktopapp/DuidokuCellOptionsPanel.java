package sudokudesktopapp;


import sudokudesktopapp.GUIHandler;
import sudokudesktopapp.SudokuCellOptionsPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anthony
 */
public class DuidokuCellOptionsPanel extends SudokuCellOptionsPanel{
    
    public DuidokuCellOptionsPanel(GUIHandler handler)
    {
        super(handler);
        this.getChoicesComboBox().setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4"}));
        
    }
}
