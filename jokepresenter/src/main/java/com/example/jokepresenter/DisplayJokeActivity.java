package com.example.jokepresenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {


    public static final String BORING_JOKE = "BORING_JOKE";
    private TextView jokeTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        doBindings();
        String funnyJoke = getIntent().getStringExtra(BORING_JOKE);
        if(!TextUtils.isEmpty(funnyJoke))
            jokeTv.setText(funnyJoke);
    }
    void doBindings(){
        jokeTv = findViewById(R.id.joke_text);
    }
}
