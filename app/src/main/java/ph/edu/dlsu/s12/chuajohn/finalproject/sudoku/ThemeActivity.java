package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.GameEngine;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view.SudokuCell;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.view.SudokuGrid;

public class ThemeActivity extends AppCompatActivity {

    private ImageView themeView;
    private ImageView classic, grey, wood;
    private SudokuGrid sudokuGrid;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        themeView = findViewById(R.id.themeView);
        classic = findViewById(R.id.classic);
        grey = findViewById(R.id.grey);
        wood = findViewById(R.id.wood);
        sudokuGrid = findViewById(R.id.sudokuGrid);
        backBtn = findViewById(R.id.backBtn);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);

        classic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               themeView.setImageResource(R.drawable.classicboard);
                Toast.makeText(ThemeActivity.this, "Classic Board installed", Toast.LENGTH_SHORT).show();
                /*Cannot connect to board*/
            }
        });

        grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themeView.setImageResource(R.drawable.grayboard);
                Toast.makeText(ThemeActivity.this, "Gray Board installed", Toast.LENGTH_SHORT).show();
                /*Cannot connect to board*/
            }
        });

        wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themeView.setImageResource(R.drawable.woodboard);
                Toast.makeText(ThemeActivity.this, "Wood Board installed", Toast.LENGTH_SHORT).show();
                /*Cannot connect to board*/
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeActivity.this, MainMenuActivity.class);
                finish();
                mediaPlayer.start();
                startActivity(intent);
            }
        });
    }
}