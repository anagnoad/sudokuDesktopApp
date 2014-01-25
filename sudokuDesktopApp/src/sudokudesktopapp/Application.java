
package sudokudesktopapp;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Base frame of the Application.
 * Base functionality of the application is presented in this window.
 * @author Steve
 */
public class Application extends JFrame{
    /**
     * Instance of a GUIHandler object.
     * Needed for reference to any other handler function or member.
     */
    private GUIHandler myGuiHandler;
    
    /**
     * Instance of a JPanel object, that contains the sidebar panel of the app.
     */
    public JPanel sideBarPanel;
    /**
     * Instance of a JPanel object, that contains the main panel of the app.
     */
    public JPanel mainPanel;
    
    /**
     * Default constructor, taking the GUIHandler as a parameter.
     * @param guiHandler 
     */
    public Application(GUIHandler guiHandler)
    {
        this.myGuiHandler = guiHandler;
        init();
    }
    
    /**
     * Initializating function for the JFrame.
     */
    private void init()
    {
        setTitle("SudokuApp");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
    }
}
