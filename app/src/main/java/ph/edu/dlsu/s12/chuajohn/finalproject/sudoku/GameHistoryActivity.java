package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GameHistoryActivity extends AppCompatActivity {

    private ListView listview;
    private ArrayList<History> historyArrayList;
    private GamesAdapter gamesAdapter;
    private Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_history);

        data(); //dummy data
        init();
    }

    private void init() {
        backBtn = (Button) findViewById(R.id.backBtn);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);
        gamesAdapter = new GamesAdapter(this, historyArrayList);
        listview.setAdapter(gamesAdapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameHistoryActivity.this, MainMenuActivity.class);
                mediaPlayer.start();
                finish();
                startActivity(intent);
            }
        });
    }

    private void data() {
        listview = (ListView) findViewById(R.id.listview);
        historyArrayList = new ArrayList<>();

        History history = new History ();
        history.setDifficulty("Easy");
        history.setTime("00:04:21");
        historyArrayList.add(history);

        history = new History ();
        history.setDifficulty("Hard");
        history.setTime("00:10:21");
        historyArrayList.add(history);
    }
}