package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GamesAdapter extends ArrayAdapter<History> {
    private Activity activity;
    private ArrayList<History> historyArrayList;

    public GamesAdapter(Activity activity, ArrayList<History> historyArrayList) {
        super(activity, R.layout.gamehistory, historyArrayList);
        this.activity = activity;
        this.historyArrayList = historyArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.gamehistory, null);

            ViewHolder gamesViewHolder = new ViewHolder();
            gamesViewHolder.difficulty = (TextView) rowView.findViewById(R.id.difficulty);
            gamesViewHolder.timer = (TextView) rowView.findViewById(R.id.timer);

            rowView.setTag(gamesViewHolder);
        }

        final ViewHolder holder = (ViewHolder) rowView.getTag();
        History info = historyArrayList.get(position);
        holder.difficulty.setText(info.getDifficulty());
        holder.timer.setText(info.getTime());

        return rowView;
    }

    static class ViewHolder {
        public TextView difficulty;
        public TextView timer;
        public TextView wrongs;
    }
}
