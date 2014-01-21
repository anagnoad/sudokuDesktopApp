/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import javax.swing.JComboBox;

/**
 *
 * @author Steve
 */
public class SudokuCellOptionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form GettingStartedPanel
     */
    public SudokuCellOptionsPanel(GUIHandler guiHandler) {
        this.myGuiHandler = guiHandler; //save the instance of the guiHandler
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        cellOptionsLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        clearLabel = new javax.swing.JLabel();
        showHintsLabel = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBackground(new java.awt.Color(193, 220, 255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(200, 350));
        setLayout(new java.awt.GridLayout(0, 1, 0, 2));

        cellOptionsLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        cellOptionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellOptionsLabel.setText("Cell options");
        cellOptionsLabel.setToolTipText("");
        add(cellOptionsLabel);
        cellOptionsLabel.getAccessibleContext().setAccessibleName("GettingStartedLabel");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);

        clearLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        clearLabel.setForeground(new java.awt.Color(255, 255, 255));
        clearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearLabel.setText("Clear");
        clearLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSudokuRulesClicked(evt);
            }
        });
        add(clearLabel);

        showHintsLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        showHintsLabel.setForeground(new java.awt.Color(255, 255, 255));
        showHintsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showHintsLabel.setText("Show Hints");
        showHintsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHintsLabelshowSudokuRulesClicked(evt);
            }
        });
        add(showHintsLabel);
    }// </editor-fold>//GEN-END:initComponents

    private void showSudokuRulesClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showSudokuRulesClicked
        this.myGuiHandler.clearSudokuCell();
    }//GEN-LAST:event_showSudokuRulesClicked

    private void showHintsLabelshowSudokuRulesClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHintsLabelshowSudokuRulesClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_showHintsLabelshowSudokuRulesClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String value = (String)cb.getSelectedItem();
        Integer intvalue = new Integer(value);
        this.myGuiHandler.changeSudokuCell(intvalue);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    private GUIHandler myGuiHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cellOptionsLabel;
    private javax.swing.JLabel clearLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel showHintsLabel;
    // End of variables declaration//GEN-END:variables
}