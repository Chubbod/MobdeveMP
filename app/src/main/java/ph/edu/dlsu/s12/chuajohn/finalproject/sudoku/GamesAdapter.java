package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R.layout.gamehistory_row;

public class GamesAdapter {
    private Activity activity;
    private ArrayList<History> ghArrayList;

    public GamesAdapter(Activity activity, ArrayList<History> ghArrayList) {
        super(activity, gamehistory_row, ghArrayList);
        this.activity = activity;
        this.ghArrayList = ghArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.activity_game_history, null);

            ViewHolder gamesViewHolder = new ViewHolder();
            gamesViewHolder.difficulty = (TextView) rowView.findViewById(R.id.difficultyTV);
            gamesViewHolder.timer = (TextView) rowView.findViewById(R.id.timeTV);
            gamesViewHolder.wrong = (TextView) rowView.findViewById(R.id.wrongTV);


            rowView.setTag(gamesViewHolder);
        }
        final ViewHolder holder = (ViewHolder) rowView.getTag();
        History info = ghArrayList.get(position);
        holder.difficulty.setText(info.getDifficulty());
        holder.timer.setText(info.getTime());
        holder.wrong.setText(info.getWrong());

        return rowView;
    }

    static class ViewHolder {
        public TextView difficulty;
        public TextView timer;
        public TextView wrong;
    }

}
