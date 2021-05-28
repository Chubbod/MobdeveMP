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

    //Generate the Sudoku board
    public void createGrid(Context context, int num) {
        int[][] sudoku = SudokuGenerator.getInstance().GridGenerate();
        sudoku = SudokuGenerator.getInstance().RemoveElements(sudoku, num);
        grid = new BoardGrid(context);
        grid.setGrid(sudoku);
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
}
