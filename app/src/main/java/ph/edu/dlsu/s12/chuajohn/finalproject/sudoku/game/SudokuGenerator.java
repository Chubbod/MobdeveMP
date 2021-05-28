package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

import java.util.ArrayList;
import java.util.Random;

//SudokuGenerator will generate the numbers into a 9by9 array
public class SudokuGenerator {

    private Random random = new Random();
    private static SudokuGenerator instant;
    private ArrayList<ArrayList<Integer>> available = new ArrayList<ArrayList<Integer>>();

    private SudokuGenerator(){
    }

    //If the class doesn't exist then create the class
    public static SudokuGenerator getInstance(){
        if(instant == null) {
            instant = new SudokuGenerator();
        }
        return instant;
    }

    //GridGenerate will generate the numbers into a 9 by 9 array with restrictions
    //The restrictions will be based on the ConflictCheck method which will analyze the numbers
    public int[][] GridGenerate() {
        int[][] sudoku = new int[9][9];

        //Current Position
        int cur = 0;
        while (cur<81) {
            if(cur == 0) {
                GridClear(sudoku);
            }

            if(available.get(cur).size()!=0) {
                int i = random.nextInt(available.get(cur).size());
                int num = available.get(cur).get(i);

                if(!ConflictCheck(sudoku, cur, num)) {
                    int xPos = cur % 9;
                    int yPos = cur / 9;
                    sudoku[xPos][yPos] = num;
                    available.get(cur).remove(i);
                    cur++;
                } else {
                    available.get(cur).remove(i);
                }

            } else {
                for(int i = 1; i <= 9; i++) {
                    available.get(cur).add(i);
                }
                cur--;
            }
        }

        return sudoku;
    }

    //RemoveElements replaces the generated sudoku with a no value
    public int[][] RemoveElements(int[][] sudoku, int num) {
        int i = 0;
        while(i<num) {
            int j = random.nextInt(9);
            int k = random.nextInt(9);

            if(sudoku[j][k]!=0) {
                sudoku[j][k] = 0;
                i++;
            }
        }
        return sudoku;
    }

    //GridClear cleans up the generated board
    private void GridClear(int[][] sudoku) {
        available.clear();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sudoku[j][i] = -1;
            }
        }

        for(int i = 0; i < 81; i++) {
            available.add(new ArrayList<Integer>());
            for(int j = 1; j <= 9; j++) {
                available.get(i).add(j);
            }
        }
    }


    //(Root Conflict)
    //Checking Horizontal, Vertical, and Region direction for similar numbers
    private boolean ConflictCheck(int[][] sudoku, int cur, final int num) {
        int xPos = cur % 9;
        int yPos = cur / 9;

        if(HorizontalConflictCheck(sudoku, xPos, yPos, num) ||
                VerticalConflictCheck(sudoku, xPos, yPos, num) ||
                RegionalConflictCheck(sudoku, xPos, yPos, num)) {
            return true;
        }

        return false;
    }

    //(Sub Conflict)
    //Checking horizontal values for conflicting numbers
    private boolean HorizontalConflictCheck(final int[][] sudoku, final int xPos, final int yPos, final int num) {
        for(int i = xPos - 1; i >= 0; i--) {
            if(num == sudoku[i][yPos]) {
                return true;
            }
        }
        return false;
    }

    //(Sub Conflict)
    //Checking vertical values for conflicting numbers
    private boolean VerticalConflictCheck(final int[][] sudoku, final int xPos, final int yPos, final int num) {
        for(int i = yPos - 1; i >= 0; i--) {
            if(num == sudoku[xPos][i]) {
                return true;
            }
        }
        return false;
    }

    //(Sub Conflict)
    //Checking regional values for conflicting numbers
    private boolean RegionalConflictCheck(final int[][] sudoku, final int xPos, final int yPos, final int num) {
        int xReg = xPos/3;
        int yReg = yPos/3;

        for(int i = xReg * 3; i < xReg * 3 + 3; i++) {
            for(int j = yReg * 3; j < yReg * 3 + 3; j++) {
                if( (i != xPos || j != yPos) && num == sudoku[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
