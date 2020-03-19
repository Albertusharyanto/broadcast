package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBroadcast = findViewById(R.id.btnBroadcast);
        Button btnBroadcastTime = findViewById(R.id.btnBroadcastTime);

        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent("filter broadcast"));
            }
        });
        btnBroadcastTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager;
                alarmManager = (AlarmManager)getSystemService((ALARM_SERVICE));
                Intent intent = new Intent(MainActivity.this,Receiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime((new Date()));
                calendar.set(Calendar.SECOND,3);

                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmIntent);
            }
        });

    }
}
