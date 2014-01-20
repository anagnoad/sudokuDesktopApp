/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

/**
 *
 * @author Steve
 */
public class GettingStartedPanel extends javax.swing.JPanel {

    /**
     * Creates new form GettingStartedPanel
     */
    public GettingStartedPanel(GUIHandler guiHandler) {
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

        gettingStartedLabel = new javax.swing.JLabel();
        newUserLabel = new javax.swing.JLabel();
        logInLabel = new javax.swing.JLabel();
        playSudokuLabel = new javax.swing.JLabel();
        showRulesLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(193, 220, 255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(200, 350));
        setLayout(new java.awt.GridLayout(0, 1, 0, 2));

        gettingStartedLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        gettingStartedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gettingStartedLabel.setText("Getting Started");
        gettingStartedLabel.setToolTipText("");
        add(gettingStartedLabel);
        gettingStartedLabel.getAccessibleContext().setAccessibleName("GettingStartedLabel");
        gettingStartedLabel.getAccessibleContext().setAccessibleDescription("");

        newUserLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        newUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        newUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newUserLabel.setText("New User");
        newUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newUserClick(evt);
            }
        });
        add(newUserLabel);
        newUserLabel.getAccessibleContext().setAccessibleName("NewUserLabel");

        logInLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        logInLabel.setForeground(new java.awt.Color(255, 255, 255));
        logInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInLabel.setText("Log In");
        logInLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInClicked(evt);
            }
        });
        add(logInLabel);

        playSudokuLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        playSudokuLabel.setForeground(new java.awt.Color(255, 255, 255));
        playSudokuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playSudokuLabel.setText("Play Sudoku");
        playSudokuLabel.setToolTipText("Play sudoku anonymously");
        playSudokuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playSudokuAnonymouslyClicked(evt);
            }
        });
        add(playSudokuLabel);

        showRulesLabel.setFont(new java.awt.Font("Lucida Grande", 3, 12)); // NOI18N
        showRulesLabel.setForeground(new java.awt.Color(255, 255, 255));
        showRulesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showRulesLabel.setText("Show Sudoku Rules");
        showRulesLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSudokuRulesClicked(evt);
            }
        });
        add(showRulesLabel);
    }// </editor-fold>//GEN-END:initComponents

    private void newUserClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUserClick
        // this will redirect you to a JFrame To Add a new user
        this.myGuiHandler.showAddNewUser();
    }//GEN-LAST:event_newUserClick

    private void logInClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInClicked
        // this will redirect you to a JFrame to choose with which nickname to log in
    }//GEN-LAST:event_logInClicked

    private void playSudokuAnonymouslyClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playSudokuAnonymouslyClicked
        // this will redirect you to a JFrame selecting options for the sudoku
    }//GEN-LAST:event_playSudokuAnonymouslyClicked

    private void showSudokuRulesClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showSudokuRulesClicked
        // this will open up a JPanel showing help from a file for sudoku
    }//GEN-LAST:event_showSudokuRulesClicked

    
    private GUIHandler myGuiHandler;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gettingStartedLabel;
    private javax.swing.JLabel logInLabel;
    private javax.swing.JLabel newUserLabel;
    private javax.swing.JLabel playSudokuLabel;
    private javax.swing.JLabel showRulesLabel;
    // End of variables declaration//GEN-END:variables
}
