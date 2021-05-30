package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity {
    private Button playBtn;
    private ImageButton soundBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        playBtn = findViewById(R.id.playbtn);
        soundBtn = findViewById(R.id.music);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainMenuActivity.class);
                finish();
                mediaPlayer.start();
                startActivity(intent);
            }
        });
    }

}