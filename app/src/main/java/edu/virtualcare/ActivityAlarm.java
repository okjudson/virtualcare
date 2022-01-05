package edu.virtualcare;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityAlarm extends AppCompatActivity {
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Backbtn();
    }
    public void Backbtn(){

        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void startAlarmManha(View view) {

        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Hora da SkinCare");
        ArrayList<Integer> alarmDays = new ArrayList<>();
        alarmDays.add(Calendar.SATURDAY);
        alarmDays.add(Calendar.SUNDAY);
        alarmDays.add(Calendar.MONDAY);
        alarmDays.add(Calendar.TUESDAY);
        alarmDays.add(Calendar.WEDNESDAY);
        alarmDays.add(Calendar.THURSDAY);
        alarmDays.add(Calendar.FRIDAY);
        i.putExtra(AlarmClock.EXTRA_DAYS, alarmDays);
        i.putExtra(AlarmClock.EXTRA_VIBRATE, true);
        i.putExtra(AlarmClock.EXTRA_HOUR, 8);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
        startActivity(i);
    }

    public void startAlarmNoite(View view) {

        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Hora da SkinCare");
        ArrayList<Integer> alarmDays = new ArrayList<>();
        alarmDays.add(Calendar.SATURDAY);
        alarmDays.add(Calendar.SUNDAY);
        alarmDays.add(Calendar.MONDAY);
        alarmDays.add(Calendar.TUESDAY);
        alarmDays.add(Calendar.WEDNESDAY);
        alarmDays.add(Calendar.THURSDAY);
        alarmDays.add(Calendar.FRIDAY);
        i.putExtra(AlarmClock.EXTRA_DAYS, alarmDays);
        i.putExtra(AlarmClock.EXTRA_VIBRATE, true);
        i.putExtra(AlarmClock.EXTRA_HOUR, 20);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
        startActivity(i);
    }
}
