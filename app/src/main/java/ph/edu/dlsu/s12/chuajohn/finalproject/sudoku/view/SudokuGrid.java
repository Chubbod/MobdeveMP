package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.GameEngine;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.SudokuChecker;

//SudokuGrid will allow actions to occur in the board
public class SudokuGrid extends GridView {

    Context context;

    public SudokuGrid(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;

        SudokuGridAdapter gridAdapter = new SudokuGridAdapter(context);
        setAdapter(gridAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;
                Toast.makeText(context, "X: " + x + " Y: " + y, Toast.LENGTH_SHORT).show();
                GameEngine.getInstance().getPosition(x, y);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    static class SudokuGridAdapter extends BaseAdapter {

        private Context context;

        public SudokuGridAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameEngine.getInstance().getGrid().getItem(position);
        }
    }


}
