/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Steve
 */
public class customizedWindowAdapter extends WindowAdapter{
    private GUIHandler myGuiHandler;
    public customizedWindowAdapter(GUIHandler guiHandler)
    {
        this.myGuiHandler = guiHandler;
    }
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.out.println(myGuiHandler.showOnCloseDialog());
        System.exit(0);
    }
}
