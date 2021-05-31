package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.GameMode;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.GamesAdapter;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.History;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.MainMenuActivity;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.ThemeActivity;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view.SudokuGrid;

public class GameActivity extends AppCompatActivity {

    TextView timeText;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    private ArrayList<History> historyArrayList;
    private Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        init();
    }

    //Start the Game based on GameMode
    private void init() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);
        timeText = (TextView) findViewById(R.id.timeText);
        backBtn = (Button) findViewById(R.id.backBtn);
        Intent intent = getIntent();

        //Start the timer
        timer = new Timer();
        TimeStart();

        int num = getIntent().getExtras().getInt("level");
        GameEngine.getInstance().createGrid(this, num);

        addNewData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, GameMode.class);
                mediaPlayer.start();
                startActivity(intent);
            }
        });
    }

    private void addNewData() {
        historyArrayList = new ArrayList<>();
        historyArrayList.add(new History(getIntent().getExtras().getString("mode"), getTimeText()));
        saveData();
    }

    private void TimeStart(){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timeText.setText(getTimeText());
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private String getTimeText() {
        int rounded = (int) Math.round(time);
        int sec = ((rounded % 86400) % 3600) % 60;
        int min = ((rounded % 86400) % 3600) / 60;
        int hrs = ((rounded % 86400) / 3600);
        return TimeFormat(sec, min, hrs);
    }

    @SuppressLint("DefaultLocale")
    private String TimeFormat(int sec, int min, int hrs) {
        return String.format("%02d", hrs) + " : " + String.format("%02d", min) + " : " + String.format("%02d", sec);
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedGames", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(historyArrayList);
        editor.putString("games", json);
        editor.commit();
    }
}