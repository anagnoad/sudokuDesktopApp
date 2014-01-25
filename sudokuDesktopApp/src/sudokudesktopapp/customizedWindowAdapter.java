/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * Custom WindowAdapter class, used for overriding the default window closing operation.
 * It is needed, so that PersonDB can be safely stored, as well as any unfinished game
 * that the user might have been playing.
 * @author Steve
 */
public class customizedWindowAdapter extends WindowAdapter{
    /**
     * Instance of the GUIHandler controller.
     */
    private GUIHandler myGuiHandler;
    /**
     * Default Constructor.
     * @param guiHandler the GUIHandler of the app.
     */
    public customizedWindowAdapter(GUIHandler guiHandler)
    {
        this.myGuiHandler = guiHandler;
    }
    /**
     * Overriding default close operation of a window,
     * so that we can ask the user whether they want to save any unfinished games
     * and save the personDB.
     * @param e 
     */
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.out.println(myGuiHandler.showOnCloseDialog());
        System.exit(0);
    }
}
