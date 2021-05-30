package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

import android.content.Context;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view.BoardGrid;

//Game Engine will create the game
public class GameEngine {

    private static GameEngine instant;
    private BoardGrid grid = null;

    private int xPos = -1, yPos = -1;

    private GameEngine(){}

    public static GameEngine getInstance() {
        if(instant == null) {
            instant = new GameEngine();
        }
        return instant;
    }

    //createGrid will generate and create empty cells
    public void createGrid(Context context, int num) {
        int[][] sudoku = SudokuGenerator.getInstance().GridGenerate();
        int[][] temp = sudoku;
        printSudoku(temp);
        sudoku = SudokuGenerator.getInstance().RemoveElements(sudoku, num);
        grid = new BoardGrid(context);
        grid.setGrid(sudoku, temp);
    }

    public BoardGrid getGrid() {
        return grid;
    }

    public void getPosition(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void setNum(int num) {
        if(xPos != -1 && yPos != -1) {
            grid.setItem(xPos, yPos, num);
        }
        grid.checkBoard();
    }

    //Printing the Sudoku into system view
    private void printSudoku(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[j][i] + " | ");
            }
            System.out.println();
        }
    }
}
