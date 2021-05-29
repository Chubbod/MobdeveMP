package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.GameActivity;

public class GameMode extends AppCompatActivity {

    private Button easy_mode, normal_mode, hard_mode, back_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        init();
    }

    private void init() {
        easy_mode = (Button) findViewById(R.id.easy_mode);
        normal_mode = (Button) findViewById(R.id.normal_mode);
        hard_mode = (Button) findViewById(R.id.hard_mode);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);

        easy_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMode.this, GameActivity.class);
                intent.putExtra("mode", "easy");
                intent.putExtra("level", 18);
                mediaPlayer.start();
                finish();
                startActivity(intent);
            }
        });

        normal_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMode.this, GameActivity.class);
                intent.putExtra("mode", "normal");
                intent.putExtra("level", 36);
                mediaPlayer.start();
                finish();
                startActivity(intent);
            }
        });

        hard_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMode.this, GameActivity.class);
                intent.putExtra("mode", "hard");
                intent.putExtra("level", 54);
                mediaPlayer.start();
                finish();
                startActivity(intent);
            }
        });
    }
}