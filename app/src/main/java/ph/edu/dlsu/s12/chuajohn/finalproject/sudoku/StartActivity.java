package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {
    private Button playBtn;
    private ImageButton soundBtn;
    private MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        playBtn = findViewById(R.id.playbtn);
        soundBtn = findViewById(R.id.music);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.slick);
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.bgmusic);

        mediaPlayer1.setLooping(true);
        mediaPlayer1.start();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainMenuActivity.class);
                mediaPlayer.start();
                startActivity(intent);
            }
        });

        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundBtn.setBackgroundResource(R.drawable.soundoff);
                if(mediaPlayer1.isPlaying())
                {
                    //stop or pause your media player mediaPlayer.stop(); or mediaPlayer.pause();
                    mediaPlayer1.pause();
                }
                else
                {
                    mediaPlayer1.start();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer1.stop();
        mediaPlayer1.release();
    }
}