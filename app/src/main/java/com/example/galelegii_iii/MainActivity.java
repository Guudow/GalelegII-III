package com.example.galelegii_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startSpillet, indstilling, HighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startSpillet = findViewById(R.id.startSpillet);
        startSpillet.setOnClickListener(this);

        indstilling = findViewById(R.id.indstillinger);
        indstilling.setOnClickListener(this);

       HighScore = findViewById(R.id.HighScore);
       HighScore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == startSpillet) {
            Intent intent = new Intent(this, StartSpillet.class);
            startActivity(intent);
        }
        if (view == indstilling) {
            Intent intent1 = new Intent(this, Indstillinger.class);
            startActivity(intent1);
        }
        if (view == HighScore) {
            Intent intent = new Intent(this, HighScore.class);
            startActivity(intent);
        }
    }
}
