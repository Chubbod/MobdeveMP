package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GameHistoryActivity extends AppCompatActivity {

    private ListView listview;
    private ArrayList<History> historyArrayList;
    private GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_history);

        data(); //dummy data

        gamesAdapter = new GamesAdapter(this, historyArrayList);
        listview.setAdapter(gamesAdapter);
    }

    private void data(){
        listview = (ListView) findViewById(R.id.listview);
        historyArrayList = new ArrayList<>();

        History history = new History ();
        history.setDifficulty("Easy");
        history.setTime("00:04:21");
        history.setWrong("3");
        historyArrayList.add(history);

        history = new History ();
        history.setDifficulty("Hard");
        history.setTime("00:10:21");
        history.setWrong("22");
        historyArrayList.add(history);
    }
}