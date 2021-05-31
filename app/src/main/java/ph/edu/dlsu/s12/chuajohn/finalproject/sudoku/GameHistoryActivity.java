package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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

        historyArrayList = new ArrayList<>();

        loadData();

        populate(); //dummy data
        init();
    }

    private void init() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);
        backBtn = (Button) findViewById(R.id.backBtn);
        listview = (ListView) findViewById(R.id.listview);

        //History Adapter
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

    private void populate() {
        historyArrayList = new ArrayList<>();
        History history = new History();

        history = new History();
        history.setDifficulty("EASY");
        history.setTime("00:7:19");
        historyArrayList.add(history);

        history = new History();
        history.setDifficulty("HARD");
        history.setTime("00:18:21");
        historyArrayList.add(history);
        saveData();
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedGames", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(historyArrayList);
        editor.putString("games", json);
        editor.commit();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedGames", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("games", null);
        Type type = new TypeToken<ArrayList<History>>() {}.getType();
        historyArrayList = gson.fromJson(json,type);

        if(historyArrayList == null) {
            historyArrayList = new ArrayList<>();
        }
    }
}