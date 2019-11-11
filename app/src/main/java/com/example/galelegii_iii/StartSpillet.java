package com.example.galelegii_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galelegii_iii.Logic.Galgelogik;

public class StartSpillet extends AppCompatActivity implements View.OnClickListener {

    Galgelogik logic = new Galgelogik();
    Button spil;
    ImageView imageView2;
    TextView textView2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spillet);

        logic.logStatus();
        spil = findViewById(R.id.spil);

        spil.setOnClickListener(this);

        imageView2 = findViewById(R.id.imageView2);

        editText = findViewById(R.id.editText);


        textView2 = findViewById(R.id.textView2);

        textView2.setText("Velkommen til galge. " +
                "\nKan du gætte ordet: " + logic.getSynligtOrd());


    }

    @Override
    public void onClick(View view) {

        String bogstav = editText.getText().toString();

        if (bogstav.length() != 1) {
            editText.setError("Skriv et bogstav!");
            return;
        }
        logic.gætBogstav(bogstav);
        editText.setText("");
        editText.setError(null);


        updateScreen();

    }

    private void updateScreen() {

        textView2.setText("Ordet er: " + logic.getSynligtOrd());
        textView2.append("\n\nDu har " + logic.getAntalForkerteBogstaver() + " forkerte:" + logic.getBrugteBogstaver());


        if (logic.erSpilletVundet()) {


            Intent intent = new Intent(this, Win.class);
            startActivity(intent);


        }


        if (logic.erSpilletTabt()) {


            Intent i = new Intent(this, Lost.class);
            i.putExtra("mit ord", logic.getOrdet());
            startActivity(i);
            finish();


        }

        switch (logic.getAntalForkerteBogstaver()) {

            case 0:
                imageView2.setImageResource(R.drawable.galge);

            case 1:
                imageView2.setImageResource(R.drawable.forkert1);
                break;

            case 2:
                imageView2.setImageResource(R.drawable.forkert2);
                break;

            case 3:
                imageView2.setImageResource(R.drawable.forkert3);
                break;

            case 4:
                imageView2.setImageResource(R.drawable.forkert4);
                break;

            case 5:
                imageView2.setImageResource(R.drawable.forkert5);
                break;


            default:
                imageView2.setImageResource(R.drawable.forkert6);

        }
    }
}
