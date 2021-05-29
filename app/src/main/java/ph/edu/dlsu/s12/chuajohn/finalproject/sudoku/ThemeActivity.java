package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ThemeActivity extends AppCompatActivity {

    private ImageButton woodenTheme;
    private ImageButton pixelTheme;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        woodenTheme = findViewById(R.id.woodtheme);
        pixelTheme = findViewById(R.id.pixeltheme);
        backBtn = findViewById(R.id.backBtn);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}