package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private Button gamemodeBtn, themeBtn, gamehistoryBtn;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        init();
    }

    private void init() {
        gamemodeBtn = findViewById(R.id.gamemodeBtn);
        gamehistoryBtn = findViewById(R.id.gamehistoryBtn);
        themeBtn = findViewById(R.id.themeBtn);

        gamemodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, GameMode.class);
                startActivity(intent);
            }
        });

        themeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });

        gamehistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, GameHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}