package Logic.Sudoku;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Class of Duidoku puzzle.
 * @author Anthony
 */
public class Duidoku extends ClassicSudoku {

    /**
     * Default ctor. Initializes the member variables of the class to the
     * appropriate values.
     */
    public Duidoku() //ctor
    {
        this.id = String.valueOf(hashCode());
        this.type = TypeOfGame.DUIDOKU;
        this.setDimX(4);
        this.setDimY(4);
        this.matrix = new int[getX()][getY()];
    }

    /**
     * Constructor taking a sudoku matrix as a parameter, so as to load it on
     * start.
     *
     * @param arrayToLoad
     */
    public Duidoku(int[][] arrayToLoad) {
        this();
        loadFromArray(arrayToLoad);
    }

    @Override
    public boolean setCell(int value, int x, int y) {
        boolean flag = super.setCell(value, x, y);
        if (flag) {
            this.isEditableArray[x][y] = false;
        }
        return flag;
    }

    @Override
    public boolean checkRules(int value, int x, int y) {
        // it's the same as in the classic sudoku, but with 2 instead of 3
        if (value == 0) {
            return true;
        }

        if (!isEditableArray[x][y]) {
            return false;
        }

        for (int i = 0; i < getX(); i++) {
            if (matrix[i][y] == value) {
                return false;
            }
            if (matrix[x][i] == value) {
                return false;
            }
        }

        int squareX = (int) (x / 2);
        int squareY = (int) (y / 2);

        int X = squareX * 2;
        int Y = squareY * 2;

        for (int i = 0; i < Math.sqrt(getX()); i++) {
            for (int j = 0; j < Math.sqrt(getY()); j++) {
                if (X + i == x || Y + j == y) {
                    continue;
                }
                if (matrix[X + i][Y + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public sudokuStatus getSudokuStatus() {
        int counter = 0;
        for (int i = 0; i < this.getX(); i++) {
            for (int j = 0; j < this.getY(); j++) {
                if (matrix[i][j] == 0 && returnHint(new Coord_2D(i, j)).length != 0) {
                    return sudokuStatus.NOTFINISHED;
                } else if (matrix[i][j] == 0) {
                    counter++;
                }
            }
        }
        return sudokuStatus.FINISHED;
    }

    @Override
    public int[] returnHint(Coord_2D cell) {
        int x = cell.x;
        int y = cell.y;
        HashSet<Integer> allValues = new HashSet<Integer>();
        for (int i = 1; i < 5; i++) {
            allValues.add(i);
        }
        HashSet<Integer> valuesFound = new HashSet<Integer>();

        for (int i = 0; i < getX(); i++) {
            if (matrix[i][y] != 0) {
                valuesFound.add(matrix[i][y]);
            }
        }

        for (int i = 0; i < getY(); i++) {
            if (matrix[x][i] != 0) {
                valuesFound.add(matrix[x][i]);
            }
        }

        int squareX = (int) (x / 2);
        int squareY = (int) (y / 2);

        int X = squareX * 2;
        int Y = squareY * 2;

        for (int i = 0; i < Math.sqrt(getX()); i++) {
            for (int j = 0; j < Math.sqrt(getY()); j++) {
                if (X + i == x || Y + j == y) {
                    continue;
                }
                if (matrix[X + i][Y + j] != 0) {
                    valuesFound.add(matrix[X + i][Y + j]);
                }
            }
        }
        allValues.removeAll(valuesFound);
        int[] toBeReturned = new int[allValues.size()];
        int counter = 0;
        Iterator i = allValues.iterator();
        while (i.hasNext()) {
            toBeReturned[counter] = (Integer) i.next();
            counter++;
        }
        return toBeReturned;
    }

}
