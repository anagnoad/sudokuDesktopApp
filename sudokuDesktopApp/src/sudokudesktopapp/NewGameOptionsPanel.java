/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import java.awt.Color;

/**
 *
 * @author Steve
 */
public class NewGameOptionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form GettingStartedPanel
     */
    public NewGameOptionsPanel(GUIHandler guiHandler) {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        newGameLabel = new javax.swing.JLabel();
        classicSudokuLabel = new javax.swing.JLabel();
        hyperSudokuLabel = new javax.swing.JLabel();
        duidokuLabel = new javax.swing.JLabel();
        cancelLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBackground(new java.awt.Color(193, 220, 255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(200, 350));
        setLayout(new java.awt.GridBagLayout());

        newGameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        newGameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newGameLabel.setText("New game");
        newGameLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(newGameLabel, gridBagConstraints);
        newGameLabel.getAccessibleContext().setAccessibleName("GettingStartedLabel");

        classicSudokuLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        classicSudokuLabel.setForeground(new java.awt.Color(255, 255, 255));
        classicSudokuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        classicSudokuLabel.setText("Classic Sudoku");
        classicSudokuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newUserClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                classicSudokuLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                classicSudokuLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(classicSudokuLabel, gridBagConstraints);
        classicSudokuLabel.getAccessibleContext().setAccessibleName("NewUserLabel");

        hyperSudokuLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        hyperSudokuLabel.setForeground(new java.awt.Color(255, 255, 255));
        hyperSudokuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hyperSudokuLabel.setText("Hyper Sudoku");
        hyperSudokuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hyperSudokuLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hyperSudokuLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(hyperSudokuLabel, gridBagConstraints);

        duidokuLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        duidokuLabel.setForeground(new java.awt.Color(255, 255, 255));
        duidokuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duidokuLabel.setText("Duidoku");
        duidokuLabel.setToolTipText("Play sudoku anonymously");
        duidokuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playSudokuAnonymouslyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                duidokuLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                duidokuLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(duidokuLabel, gridBagConstraints);

        cancelLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        cancelLabel.setForeground(new java.awt.Color(255, 255, 255));
        cancelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelLabel.setText("Cancel");
        cancelLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSudokuRulesClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(cancelLabel, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 8;
        add(jSeparator1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void newUserClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUserClick
        // this will redirect you to a JFrame To Add a new user
        this.myGuiHandler.showAddNewUserPanel();
    }//GEN-LAST:event_newUserClick

    private void logInClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInClicked
        // this will redirect you to a JFrame to choose with which nickname to log in
        
    }//GEN-LAST:event_logInClicked

    private void playSudokuAnonymouslyClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playSudokuAnonymouslyClicked
        // this will redirect you to a JFrame selecting options for the sudoku
    }//GEN-LAST:event_playSudokuAnonymouslyClicked

    private void showSudokuRulesClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showSudokuRulesClicked
        // this will open up a JPanel showing help from a file for sudoku
        myGuiHandler.showHelpDialog();
    }//GEN-LAST:event_showSudokuRulesClicked

    private void classicSudokuLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classicSudokuLabelMouseEntered
        // TODO add your handling code here:
        this.classicSudokuLabel.setForeground(alternativeFontColor);
    }//GEN-LAST:event_classicSudokuLabelMouseEntered

    private void classicSudokuLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classicSudokuLabelMouseExited
        // TODO add your handling code here:
        this.classicSudokuLabel.setForeground(defaultFontColor);
        
    }//GEN-LAST:event_classicSudokuLabelMouseExited

    private void hyperSudokuLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hyperSudokuLabelMouseEntered
        // TODO add your handling code here:
        this.hyperSudokuLabel.setForeground(alternativeFontColor);
    }//GEN-LAST:event_hyperSudokuLabelMouseEntered

    private void hyperSudokuLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hyperSudokuLabelMouseExited
        // TODO add your handling code here:
        this.hyperSudokuLabel.setForeground(defaultFontColor);
    }//GEN-LAST:event_hyperSudokuLabelMouseExited

    private void duidokuLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_duidokuLabelMouseEntered
        // TODO add your handling code here:
        this.duidokuLabel.setForeground(alternativeFontColor);
    }//GEN-LAST:event_duidokuLabelMouseEntered

    private void duidokuLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_duidokuLabelMouseExited
        // TODO add your handling code here:
        this.duidokuLabel.setForeground(defaultFontColor);
    }//GEN-LAST:event_duidokuLabelMouseExited

    private void cancelLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelLabelMouseEntered
        // TODO add your handling code here:
        this.cancelLabel.setForeground(alternativeFontColor);
    }//GEN-LAST:event_cancelLabelMouseEntered

    private void cancelLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelLabelMouseExited
        // TODO add your handling code here:
        this.cancelLabel.setForeground(defaultFontColor);
    }//GEN-LAST:event_cancelLabelMouseExited

    
    private static final Color defaultFontColor = new Color(255, 255, 255);
    private static final Color alternativeFontColor = new Color(204, 204, 204);
    private GUIHandler myGuiHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelLabel;
    private javax.swing.JLabel classicSudokuLabel;
    private javax.swing.JLabel duidokuLabel;
    private javax.swing.JLabel hyperSudokuLabel;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel newGameLabel;
    // End of variables declaration//GEN-END:variables
}
