package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.buttons;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.R;
import ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game.GameEngine;

//ButtonsNumber assigns a tile from the grid to the a specific button
public class ButtonsNumber extends androidx.appcompat.widget.AppCompatButton implements View.OnClickListener {

    private int num;
    final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.zat);

    public ButtonsNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        GameEngine.getInstance().setNum(num);
        mediaPlayer.start();
    }

    public void setNum(int num) {
        this.num = num;
    }

    //connect to startactivity
}
