package com.example.galelegii_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScore extends AppCompatActivity implements View.OnClickListener {

    ListView highScore;
    int minScore;
    int score1, score2, score3, score4, score5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);


        highScore = findViewById(R.id.listView);


        SharedPreferences preferences = getSharedPreferences("PR", 0);
        minScore = preferences.getInt("minScore", 0);
        score1 = preferences.getInt("score1", 0);
        score2 = preferences.getInt("score2", 0);
        score3 = preferences.getInt("score3", 0);
        score4 = preferences.getInt("score4", 0);
        score5 = preferences.getInt("score5", 0);



        if (minScore > score5) {

            score5 = minScore;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score5", score5);
            editor.apply();
        }

        if (minScore > score4) {

            int s4 = score4;
            score4 = minScore;
            score5 = s4;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score5", score5);
            editor.putInt("score4", score4);
            editor.apply();

        }
        if (minScore > score3){

            int s3 = score3;
            score3 = minScore;
            score4 = s3;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score4", score4);
            editor.putInt("score3", score3);
            editor.apply();

        }

        if (minScore > score2) {

            int s2 = score2;
            score2 = minScore;
            score3 = s2;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score3", score3);
            editor.putInt("score2", score2);
            editor.apply();

        }

        if (minScore > score1) {

            int s1 = score1;
            score1 = minScore;
            score2 = s1;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("score2", score2);
            editor.putInt("score1", score1);
            editor.apply();

        }



        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(score1);
        arrayList.add(score2);
        arrayList.add(score3);
        arrayList.add(score4);
        arrayList.add(score5);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        highScore.setAdapter(arrayAdapter);


    }


    //Test - til array (remove)
    @Override
    public void onClick(View view) {

        highScore.setAdapter(null);



    }



}
