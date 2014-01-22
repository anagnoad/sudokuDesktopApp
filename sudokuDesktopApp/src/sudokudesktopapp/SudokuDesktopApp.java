/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import Logic.IO.IO;
import Logic.Users.PersonDB;

/**
 *
 * @author Steve
 */
public class SudokuDesktopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Start the appInstance and the GuiHandler of the application.
        ApplicationInstance appInstance = ApplicationInstance.getInstance();
//        PersonDB db = new PersonDB();
//        db.addNewPerson("Antonis");
//        db.addNewPerson("Steve");
//        db.addNewPerson("Greg");
//        db.addNewPerson("Dask");
//        db.addNewPerson("Antonis");
//        IO.savePlayers("db.txt", db);
//        
        
        GUIHandler guiHandler = new GUIHandler(appInstance);
    }
}
