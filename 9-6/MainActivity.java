package com.example.myapplication_14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnCall;
    EditText editCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, MODE_PRIVATE);
        btnCall = (Button) findViewById(R.id.btnCall);
        editCall = (EditText) findViewById(R.id.editCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editCall.setText(getCallHistory());
            }
        });
    }
    public String getCallHistory() {
        String[] callSet = new String[] {CallLog.Calls.DATE, CallLog.Calls.TYPE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};
        @SuppressLint("MissingPermission") Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI, callSet, null, null, null);

        if ( c == null)
            return "��ȭ��� ����";

        StringBuffer callBuff = new StringBuffer();
        callBuff.append("\n ��¥ : ���� : ��ȭ��ȣ : ��ȭ�ð�\n\n");
        c.moveToFirst();
        do {
            long callDate = c.getLong(0);
            SimpleDateFormat datePattern = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = datePattern.format(new Date(callDate));
            callBuff.append(date_str + ":");
            if (c.getInt(1) == CallLog.Calls.INCOMING_TYPE)
                callBuff.append("���� :");
            else
                callBuff.append("�߽� :");
            callBuff.append(c.getString(2) + ":");
            callBuff.append(c.getString(3) + "��\n");
        }
        while (c.moveToNext());

        c.close();
        return callBuff.toString();
    }
}
