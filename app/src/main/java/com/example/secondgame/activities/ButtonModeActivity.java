package com.example.secondgame.activities;


import static com.example.secondgame.config.Config.KEY_DELAY;
import static com.example.secondgame.config.Config.KEY_MODE;
//import static com.example.secondgame.config.Config.START_IMAGE_LINK;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secondgame.R;

public class ButtonModeActivity extends AppCompatActivity {
    private Button Mode_Fast;
    private Button Mode_Slow;
    private final int FAST = 500;
    private final int SLOW = 1000;


    private ImageView background;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_mode);

        findViews();
        initViews();

    }

    private void findViews() {
        Mode_Fast = findViewById(R.id.buttonMenu_BTN_FastMode);
        Mode_Slow = findViewById(R.id.buttonMenu_BTN_SlowMode);
        background = findViewById(R.id.buttonMenu_IMG_background);
    }

    private void initViews() {
        Mode_Fast.setOnClickListener(view -> changeActivity(FAST));

        Mode_Slow.setOnClickListener(view -> changeActivity(SLOW));
    }

    private void changeActivity(int delay) {
        finish();
        Intent intent;

        intent = new Intent(ButtonModeActivity.this, MainActivity.class);
        int mode = fromLastIntent();
        intent.putExtra(KEY_MODE, mode);
        intent.putExtra(KEY_DELAY, delay);
        startActivity(intent);
    }

    private int fromLastIntent() {
        Intent prevIntent = getIntent();
        return prevIntent.getExtras().getInt(KEY_MODE);
    }
}
