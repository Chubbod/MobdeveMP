package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.GameMode;
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
    private SudokuGrid sudokuGrid;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        init();
    }

    //Start the Game based on GameMode
    private void init() {
        timeText = (TextView) findViewById(R.id.timeText);
        backBtn = (Button) findViewById(R.id.backBtn);
        Intent intent = getIntent();
        timer = new Timer();
        historyArrayList = new ArrayList<>();
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);

        TimeStart();
        int num = getIntent().getExtras().getInt("level");
        GameEngine.getInstance().createGrid(this, num);
        History history = new History();
        history.setDifficulty(getIntent().getExtras().getString("mode"));
        history.setTime(getTimeText());
        historyArrayList.add(history);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, GameMode.class);
                finish();
                mediaPlayer.start();
                startActivity(intent);
            }
        });
    }

    public void BackgroundChange() {

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


}