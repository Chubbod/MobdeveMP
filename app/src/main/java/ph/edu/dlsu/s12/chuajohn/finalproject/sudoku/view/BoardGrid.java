package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.GameMode;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.GameActivity;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.GameEngine;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.SudokuChecker;

//BoardGrid will contain the Sudoku board and the values of the 9by9
public class BoardGrid {

    private Context context;
    private SudokuCell[][] sudoku = new SudokuCell[9][9];

    public BoardGrid(Context context) {
        this.context = context;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sudoku[i][j].setInitVal(grid[i][j]);
                if(grid[i][j] != 0) {
                    sudoku[i][j].setModify();
                }
            }
        }
    }

    public SudokuCell[][] getGrid() {
        return sudoku;
    }

    public SudokuCell getItem(int i, int j) {
        return sudoku[i][j];
    }

    public SudokuCell getItem(int position) {
        int i = position % 9;
        int j = position / 9;
        return  sudoku[i][j];
    }

    public void setItem(int x, int y, int num) {
        sudoku[x][y].setValue(num);
    }

    public void checkBoard() {
        int[][] grid = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                grid[i][j] = getItem(i, j).getValue();
            }
        }
        //All Complete
        if(SudokuChecker.getInstance().SudokuCheck(grid)) {
            new AlertDialog.Builder(context)
                    .setTitle("Sudoku Puzzle Solved!")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context, GameMode.class);
                            context.startActivity(intent);
                        }
                    })
                    .show();
        } else {
            if(SudokuChecker.getInstance().ZeroSudokuCheck(grid)) {
                if(SudokuChecker.getInstance().SingleSudokuCheck(grid)) {
                    //Nothing happens
                } else {
                    Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
