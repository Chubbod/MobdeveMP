package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        init();
    }

    //Start the Game based on GameMode
    private void init() {
        Intent intent = getIntent();
        int num = getIntent().getExtras().getInt("level");
        GameEngine.getInstance().createGrid(this, num);
    }

    //Printing the Sudoku into system view
    private void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.println(sudoku[i][j] + " | ");
            }
            System.out.println();
        }
    }
}