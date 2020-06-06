package com.example.chapter1104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("14107050-�Ӵ뵿");

        final RatingBar rating1, rating2, rating3;
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btnInc, btnDec;

        rating1 = (RatingBar) findViewById(R.id.ratingBar);
        rating2 = (RatingBar) findViewById(R.id.ratingBar2);
        rating3 = (RatingBar) findViewById(R.id.ratingBar3);
        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);

        btnInc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating2.getRating()+rating2.getStepSize());
                rating3.setRating(rating3.getRating()+rating3.getStepSize());
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rating1.setRating(rating1.getRating()-rating1.getStepSize());
                rating2.setRating(rating2.getRating()-rating2.getStepSize());
                rating3.setRating(rating3.getRating()-rating3.getStepSize());
            }
        });
    }
}
