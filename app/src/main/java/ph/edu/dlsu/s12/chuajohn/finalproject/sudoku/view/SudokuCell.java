package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

//SudokuCell will design the board with border lines and design the numbers
public class SudokuCell extends SudokuBaseCell {

    private Paint paint;

    public SudokuCell(Context context) {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawNumbers(canvas);
        drawLines(canvas);
    }

    public void drawBackground(Canvas canvas) {
        //Classic
        canvas.drawRGB(255,255,255);

        /*=
        } else if(n==2) {
            canvas.drawRGB(255, 0, 0);
        } else if(n==3) {
            canvas.drawRGB(0, 0, 255);
        } else if(n==4) {
            canvas.drawRGB(0, 255, 0);
        }
         */
    }

    //Apply border to the board
    private void drawLines(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }

    //Apply numbers into the board
    private void drawNumbers(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);
        paint.setStyle(Paint.Style.FILL);

        Rect bounds = new Rect();
        paint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if(getValue()!=0) {
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width())/2, (getHeight() + bounds.height())/2, paint);
        }
    }

}
