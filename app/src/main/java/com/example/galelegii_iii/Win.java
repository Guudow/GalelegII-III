package com.example.galelegii_iii;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galelegii_iii.Logic.Galgelogik;

public class Win extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent();
        final int antalForsøg = intent.getIntExtra("antal forsøg", 0);


        if (antalForsøg == 0){

            score += 30;

        } else if (antalForsøg == 1){

            score += 15;

        } else if (antalForsøg == 2){

            score += 10;

        } else if (antalForsøg == 3){

            score += 5;

        } else {


            score = 1;

        }


    }

    private void tilføjScore() {


        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("minscore", score);
        editor.apply();


        Intent intent = new Intent(getApplicationContext(), HighScore.class);
        startActivity(intent);
        finish();

    }

    private void openActivity1() {

        Intent in = new Intent(this, Galgelogik.class);
        startActivity(in);

    }
}

