package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        back_mode = (Button) findViewById(R.id.back_mode);

        easy_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMode.this, GameActivity.class);
                intent.putExtra("mode", "easy");
                intent.putExtra("level", 18);
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
                finish();
                startActivity(intent);
            }
        });

        back_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMode.this, GameActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}