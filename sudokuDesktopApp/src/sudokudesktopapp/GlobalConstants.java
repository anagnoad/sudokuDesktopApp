/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import java.util.HashMap;

/**
 * Final class that contains all the static final values that are used 
 * throughout the application.
 * @author Steve
 */
public final class GlobalConstants {
    /**
     * The path for the object file of PersonDB.
     */
    public static final String PERSONDB_PATH = "./resources/personDB_file";
    /**
     * The path for the html file of Sudoku Help (used in help dialog)
     */
    public static final String SUDOKUHELP_PATH = "./resources/sudoku_help.html";
    /**
     * The path for the resources directory.
     */
    public static final String RESOURCES_PATH = "./resources/";
    /**
     * The path for the saved games directory.
     */
    public static final String SAVES_PATH = "./resources/saves/";
    
    /**
     * Constant value of the number of presaved games that come with this app.
     */
    public static final int TOTAL_GAMES_PRESAVED = 10;
    
    /** 
     * HashMap that matches numbers to letters (and vice versa) for Wordoku.
     */
    public static final HashMap<String, String> wordokuMap;
    static
    {
        wordokuMap = new HashMap<>();
        wordokuMap.put("1", "A");
        wordokuMap.put("2", "B");
        wordokuMap.put("3", "C");
        wordokuMap.put("4", "D");
        wordokuMap.put("5", "E");
        wordokuMap.put("6", "F");
        wordokuMap.put("7", "G");
        wordokuMap.put("8", "H");
        wordokuMap.put("9", "I");
        wordokuMap.put("A","1");
        wordokuMap.put("B","2");
        wordokuMap.put("C","3");
        wordokuMap.put("D","4");
        wordokuMap.put("E","5");
        wordokuMap.put("F","6");
        wordokuMap.put("G","7");
        wordokuMap.put("H","8");
        wordokuMap.put("I","9");
    }
    
    
    
    // Testing constants
    /**
     * Constant for the PersonDB that is used in JUnit Tests.
     */
    public static final String PERSONDB_PATH_TESTING = "./testing_Resources/testDB";
    /**
     * Constant for the testing directory used in JUnit Tests.
     */
    public static final String TESTING_PATH ="/testing/";
}
