package Logic.Sudoku;

/**
 * Enumerator containing all possible values for a sudoku game.
 * Finished when the puzzle is complete.
 * Notfinished when the puzzle is still active.
 * Failed when the puzzle is not complete, yet no further action can be made.
 * @author Anthony
 */
public enum sudokuStatus {
FINISHED, FAILED, NOTFINISHED
}
