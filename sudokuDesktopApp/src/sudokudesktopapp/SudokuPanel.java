/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokudesktopapp;

import Logic.Sudoku.Coord_2D;
import Logic.Sudoku.TypeOfGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Custom JPanel class used for the main sudoku puzzle panel.
 * It is loaded in the main panel of the application, upon the creation of a new sudoku.
 * @author Anthony
 */
public class SudokuPanel extends JPanel {
    
    /**
     * Instance of the GUIHandler controller.
     */
    private GUIHandler myGuiHandler;
    
    /**
     * 2-D Array of JLabels, each of which represents one Sudoku cell.
     */
    private JLabel[][] labels;
    
    /**
     * Currently selected JLabel.
     */
    public JLabel selected;
    
    /**
     * Currently selected coordinates of the sudoku cell.
     */
    public Coord_2D selectedCoordinates;
    
    /**
     * The type of game that is being played.
     * e.g. CLASSIC, HYPERDOKU, DUIDOKU.
     */
    private TypeOfGame type;
    
    /**
     * Default constructor.
     * @param handler the GUIHandler instance
     * @param type the type of game that will be played.
     */
    public SudokuPanel(GUIHandler handler, TypeOfGame type)
    {
        super();
        selected = null;
        this.myGuiHandler = handler;
        this.type = type;
        int rows = 0;
        int columns = 0;
        switch(type)
        {
            case CLASSIC:
            case HYPERDOKU:
                rows = columns = 9;
                break;
            case DUIDOKU:
                rows = columns = 4;
                break;
        }
        
        labels = new JLabel[rows][columns];
        setLayout(new GridLayout(rows,columns,10,10));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                labels[i][j] = new JLabel(" ");
                labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                labels[i][j].setBackground(Color.getHSBColor(26, 0, 88));
                labels[i][j].setFont(new Font("Serif",Font.PLAIN,20));
                labels[i][j].setOpaque(true);
                labels[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                labels[i][j].addMouseListener(new CellAdapter(i,j));
            }
        }
        for(JLabel[] labelArray: labels)
        {
            for(JLabel x :labelArray)
            {
                add(x);
            }
        }
        setVisible(true);
    }
    
    /**
     * Getter of a particular [i,j] JLabel from the matrix.
     * Is used for modifying values.
     * @param i the x-coordinate of the cell
     * @param j the y-coordinate of the cell.
     * @return the JLabel of that cell.
     */
    public JLabel getJLabel(int i, int j)
    {
        return labels[i][j];
    }
    
    /**
     * MouseAdapter class, needed for a mouseevent on the sudoku cells.
     */
    private class CellAdapter extends MouseAdapter
    {
        /**
         * The x-y coordinates of the cell.
         */
        private int i, j;
        /**
         * Default constructor.
         * @param i the x-coordinate of the selected cell.
         * @param j the y-coordinate of the selected cell.
         */
        public CellAdapter(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
        
        /**
         * Event handling for clicking one of the JLabels (sudoku cells).
         * SudokuCellOptionsPanel is loaded, so that user can play a move on the puzzle.
         * @param ev 
         */
        public void mouseClicked(MouseEvent ev) {
            JLabel label = (JLabel) ev.getSource();
            if(label.isEnabled())
            {
                if(selected!=null)
                    selected.setBackground(Color.getHSBColor(26, 0, 88));
                selected = labels[i][j];
                selected.setBackground(Color.getHSBColor(26, 0, 20));   
                selectedCoordinates = new Coord_2D(i,j);
                myGuiHandler.showSudokuCellOptionsPanel(type, selectedCoordinates);
            }
        }
    }
}
