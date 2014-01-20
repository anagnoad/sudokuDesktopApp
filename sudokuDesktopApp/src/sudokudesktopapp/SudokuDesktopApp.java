/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

/**
 *
 * @author Steve
 */
public class SudokuDesktopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationInstance appInstance = ApplicationInstance.getInstance();
        GUIHandler guiHandler = new GUIHandler(appInstance);
    }
}
