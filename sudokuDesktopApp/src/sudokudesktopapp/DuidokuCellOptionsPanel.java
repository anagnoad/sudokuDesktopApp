package sudokudesktopapp;


import Logic.Sudoku.Coord_2D;

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
    
    public DuidokuCellOptionsPanel(GUIHandler handler, Coord_2D coords)
    {
        super(handler, coords);
        this.getChoicesComboBox().setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4"}));
        
    }
}
