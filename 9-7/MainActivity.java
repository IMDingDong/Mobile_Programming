package com.example.myapplication7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText edtAngle;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("¡¶¡÷µµ «≥∞Ê");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.itemRotate:
                imageView1.setRotation(Float.parseFloat(edtAngle.getText().toString()));
                return true;
            case R.id.item1:
                imageView1.setImageResource(R.drawable.jeju1);
                return true;
            case R.id.item2:
                imageView1.setImageResource(R.drawable.jeju2);
                return true;
            case R.id.item3:
                imageView1.setImageResource(R.drawable.jeju3);
                return true;
        }
        return false;
    }
}
