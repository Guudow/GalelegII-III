package com.example.galelegii_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.galelegii_iii.Logic.Galgelogik;

public class Lost extends AppCompatActivity {

    Galgelogik logic = new Galgelogik();
    TextView lost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);


        lost = findViewById(R.id.los);

        Intent i = getIntent();
        final String mitOrdrd = i.getStringExtra("mit ord");

        lost.setText("DU TABT!");


    }
}
