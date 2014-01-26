/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import Logic.Sudoku.Coord_2D;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * Custom JPanel class used for when a user clicks on a particular Sudoku Cell.
 * It is loaded in the sidebar of the application window.
 * @author Steve
 */
public class SudokuCellOptionsPanel extends javax.swing.JPanel {

    /**
     * Default constructor.
     * Creates new form GettingStartedPanel.
     */
    public SudokuCellOptionsPanel(GUIHandler guiHandler, Coord_2D coords) {
        
        initComponents();
        this.myGuiHandler = guiHandler; //save the instance of the guiHandler
        this.selectedCoordinates = coords;        
        myGuiHandler.updateHintsFromSudokuCellOptionsPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cellOptionsLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        clearLabel = new javax.swing.JLabel();
        showHintsLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(193, 220, 255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(200, 350));
        setLayout(new java.awt.GridBagLayout());

        cellOptionsLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        cellOptionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellOptionsLabel.setText("Cell options");
        cellOptionsLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cellOptionsLabel, gridBagConstraints);
        cellOptionsLabel.getAccessibleContext().setAccessibleName("GettingStartedLabel");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valuesComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(jComboBox1, gridBagConstraints);

        clearLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        clearLabel.setForeground(new java.awt.Color(255, 255, 255));
        clearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearLabel.setText("Clear");
        clearLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearLabelClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(clearLabel, gridBagConstraints);

        showHintsLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        showHintsLabel.setForeground(new java.awt.Color(255, 255, 255));
        showHintsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showHintsLabel.setText("Show Hints");
        showHintsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHintsLabelClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(showHintsLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handling for clicking the "Clear" JLabel.
     * Clears the value of the cell, if allowed.
     * @param evt 
     */
    private void clearLabelClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearLabelClicked
        this.myGuiHandler.clearSudokuCell(selectedCoordinates);
    }//GEN-LAST:event_clearLabelClicked

    /**
     * Event handling for clicking the "Show Hints" JLabel
     * Shows hints on the same JLabel, if any.
     * @param evt 
     */
    private void showHintsLabelClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHintsLabelClicked
        // TODO add your handling code here:
        this.myGuiHandler.showHintsOnSudokuGame(selectedCoordinates);
    }//GEN-LAST:event_showHintsLabelClicked

    /**
     * Event handling for picking another value from the combobox.
     * The value is loaded in the particular sudoku cell, if allowed.
     * @param evt 
     */
    private void valuesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valuesComboBoxActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String value = (String)cb.getSelectedItem();
        Integer intvalue;
        
        if(this.myGuiHandler.showWordoku)
            intvalue = Integer.parseInt(GlobalConstants.wordokuMap.get(value));
        else
            intvalue = Integer.parseInt(value);
        this.myGuiHandler.changeSudokuCell(intvalue, this.selectedCoordinates);
    }//GEN-LAST:event_valuesComboBoxActionPerformed

    /**
     * Getter function for choices combobox.
     * @return the choices combobox
     */
    public JComboBox getChoicesComboBox()
    {
        return jComboBox1;
    }
    
    /**
     * Getter function for show hints JLabel.
     * @return the show hints JLabel.
     */
    public JLabel getShowHintsLabel()
    {
        return this.showHintsLabel;
    }
    
    /**
     * Instance of a Coord_2D object, representing current active cell.
     */
    private Coord_2D selectedCoordinates;
    /**
     * Instance of the GUIHandler controller.
     */
    private GUIHandler myGuiHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cellOptionsLabel;
    private javax.swing.JLabel clearLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel showHintsLabel;
    // End of variables declaration//GEN-END:variables
}
