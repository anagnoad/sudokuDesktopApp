package sudokudesktopapp;


import Logic.Sudoku.Coord_2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Custom JPanel class, that extends from SudokuCellOptionsPanel.
 * It is used a sidebar panel when playing Duidoku. 
 * @author Anthony
 */
public class DuidokuCellOptionsPanel extends SudokuCellOptionsPanel{
    
    /**
     * Default constructor, that initializes the variables and 
     * sets the combobox value to the appropriate ones for Duidoku.
     * @param handler
     * @param coords 
     */
    public DuidokuCellOptionsPanel(GUIHandler handler, Coord_2D coords)
    {
        super(handler, coords);
        this.getChoicesComboBox().setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4"}));
        
    }
}
