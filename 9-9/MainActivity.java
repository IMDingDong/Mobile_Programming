package com.example.a20191104_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티:14107050-임대동");

        Button btnNewActivity = (Button)findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editNum1 = (EditText)findViewById(R.id.editNum1);
                EditText editNum2 = (EditText)findViewById(R.id.editNum2);

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));
                startActivityForResult(intent, 0 );
            }
        });
    }

    protected void onActivityResult(int requestCoedm, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}
