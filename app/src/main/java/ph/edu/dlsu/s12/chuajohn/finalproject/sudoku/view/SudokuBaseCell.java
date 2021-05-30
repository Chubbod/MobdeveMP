package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view;

import android.content.Context;
import android.view.View;

public class SudokuBaseCell extends View {

    private int val;
    private boolean modify = true;
    private SudokuCell[][] sudoku = new SudokuCell[9][9];

    public SudokuBaseCell(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setModify() {
        modify = false;
    }

    //setInitalValue get the number and invalidate the onDraw method
    public void setInitVal(int val) {
        this.val = val;
        invalidate();
    }

    public int getValue() {
        return val;
    }

    //invalidate and set the Value
    public void setValue(int val) {
        if(modify) {
            this.val = val;
        }
        invalidate();
    }

    public void setCoordinate(int position) {
        int xPos = position % 9;
        int yPos = position / 9;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(sudoku[i][j]==sudoku[xPos][yPos]) {
                    invalidate();
                }
            }
        }
    }
}
