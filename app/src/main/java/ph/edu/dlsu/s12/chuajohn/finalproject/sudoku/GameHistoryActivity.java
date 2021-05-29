package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GameHistoryActivity extends AppCompatActivity {

    private ListView ghListView;
    private ArrayList<History> ghArrayList;
    private GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_history);

        data(); //dummy data

        gamesAdapter = new GamesAdapter(this, ghArrayList);
        ghListView.setAdapter((ListAdapter) gamesAdapter);
    }

    public void data(){
        ghListView = findViewById(R.id.ghListView);
        ghArrayList = new ArrayList<>();
        History gh = new History ();

        gh.setDifficulty("Easy");
        gh.setTime("00:04:21");
        gh.setWrong("3");
        ghArrayList.add(gh);

        gh = new History ();
        gh.setDifficulty("Hard");
        gh.setTime("00:10:21");
        gh.setWrong("22");
        ghArrayList.add(gh);

    }
}