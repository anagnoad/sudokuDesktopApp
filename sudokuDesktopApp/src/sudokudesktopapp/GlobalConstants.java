/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesktopapp;

import java.util.HashMap;

/**
 *
 * @author Steve
 */
public final class GlobalConstants {
    public static final String PERSONDB_PATH = "./resources/personDB_file";
    public static final String SUDOKUHELP_PATH = "./resources/sudoku_help.html";
    public static final String RESOURCES_PATH = "./resources/";
    public static final String SAVES_PATH = "./resources/saves/";
    public static final int TOTAL_GAMES_PRESAVED = 10;
    
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
}
