package com.example.galelegii_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Indstillinger extends AppCompatActivity implements View.OnClickListener {

    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indstillinger);


        help = findViewById(R.id.help);
        help.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view == help) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
        }
    }
}



