
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
    private GUIHandler myGuiHandler;
    
    private JPanel sideBarPanel;
    private JPanel mainPanel;
    
    public Application(GUIHandler guiHandler)
    {
        this.myGuiHandler = guiHandler;
        init();
    }
    
    private void init()
    {
        setTitle("SudokuApp");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setJMenuBar(new MainMenuBar(myGuiHandler));
        
        sideBarPanel = new GettingStartedPanel(myGuiHandler);
        sideBarPanel.setBounds(600, 140, 200, 250);
        add(sideBarPanel);
        sideBarPanel.setVisible(true);
        
        
        mainPanel = new SudokuPanel(myGuiHandler);
        mainPanel.setBounds(20, 20, 520, 520);
        add(mainPanel);
        setVisible(true);
        
    }
}
