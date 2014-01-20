/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokudesktopapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class SudokuPanel extends JPanel {
    
    private GUIHandler myGuiHandler;
    
    private JLabel[][] labels;
    
    
    public SudokuPanel(GUIHandler handler)
    {
        this(handler,9,9);
    }
    
    public SudokuPanel(GUIHandler handler, int rows, int columns)
    {
        super();
        this.myGuiHandler = handler;
        labels = new JLabel[rows][columns];
        setLayout(new GridLayout(rows,columns,10,10));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                labels[i][j] = new JLabel();
                Integer value = new Integer(i*j);
                labels[i][j].setText(value.toString());
                labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                labels[i][j].setBackground(Color.getHSBColor(26, 0, 88));
                labels[i][j].setFont(new Font("Serif",Font.PLAIN,20));
                labels[i][j].setOpaque(true);
                labels[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
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
}
