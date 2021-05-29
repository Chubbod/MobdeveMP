package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.History;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R;

public class GameActivity extends AppCompatActivity {

    TextView timeText;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    private ArrayList<History> historyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        init();
    }

    //Start the Game based on GameMode
    private void init() {
        timeText = (TextView) findViewById(R.id.timeText);
        Intent intent = getIntent();
        timer = new Timer();
        historyArrayList = new ArrayList<>();

        TimeStart();
        int num = getIntent().getExtras().getInt("level");
        GameEngine.getInstance().createGrid(this, num);
        History history = new History();
        history.setDifficulty(getIntent().getExtras().getString("mode"));
        history.setTime(getTimeText());
        historyArrayList.add(history);
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

    //Printing the Sudoku into system view
    private void printSudoku(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.println(sudoku[i][j] + " | ");
            }
            System.out.println();
        }
    }
}