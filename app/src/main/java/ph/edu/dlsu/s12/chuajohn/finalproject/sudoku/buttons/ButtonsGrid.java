package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.buttons;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R;

//ButtonsGrid will display the buttons that will change the values in the GridView of SudokuBoard
public class ButtonsGrid extends GridView {

    public ButtonsGrid(Context context, AttributeSet attrs) {
        super(context, attrs);

        ButtonsGridAdapter gridAdapter = new ButtonsGridAdapter(context);
        setAdapter(gridAdapter);
    }

    class ButtonsGridAdapter extends BaseAdapter {

        private Context context;

        public ButtonsGridAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 9;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if(view == null) {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                view = inflater.inflate(R.layout.button, parent, false);

                ButtonsNumber number;
                number = (ButtonsNumber) view;
                number.setTextSize(20);
                number.setId(position);
                number.setText(String.valueOf(position + 1));
                number.setNum(position+1);
                return number;
            }
            return view;
        }
    }
}
