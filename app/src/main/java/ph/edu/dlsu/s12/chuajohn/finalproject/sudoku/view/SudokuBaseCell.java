package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SudokuBaseCell extends View {

    private int val;
    private boolean modify = true;

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

    public void setInitVal(int val) {
        this.val = val;
        invalidate();
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        if(modify) {
            this.val = val;
        }
        invalidate();
    }
}
