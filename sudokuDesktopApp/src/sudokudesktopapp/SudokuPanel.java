/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokudesktopapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Anthony
 */
public class SudokuPanel extends JPanel {
    
    private GUIHandler myGuiHandler;
    
    private JLabel[][] labels;
    
    public JLabel selected;
    
    public SudokuPanel(GUIHandler handler, int rows, int columns)
    {
        super();
        selected = null;
        this.myGuiHandler = handler;
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
    
    private class CellAdapter extends MouseAdapter
    {
        private int i, j;
        public CellAdapter(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
        
        public void mouseClicked(MouseEvent ev) {
            if(selected!=null)
                selected.setBackground(Color.getHSBColor(26, 0, 88));
            myGuiHandler.showSudokuCellOptions();
            selected = labels[i][j];
            selected.setBackground(Color.getHSBColor(26, 0, 20));
        }
    }
}
