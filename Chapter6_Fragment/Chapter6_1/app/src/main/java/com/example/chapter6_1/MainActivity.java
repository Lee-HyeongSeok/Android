package com.example.chapter6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startBtn, endBtn;
    Chronometer chrono1;
    TimePicker tPicker;
    CalendarView CalView;
    RadioButton radioTime, radioCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.start_button);
        endBtn = (Button)findViewById(R.id.end_button);

        chrono1 = (Chronometer)findViewById(R.id.chronometer01);

        tPicker = (TimePicker)findViewById(R.id.timePicker1);
        CalView = (CalendarView)findViewById(R.id.calendar1);

        radioCal = (RadioButton)findViewById(R.id.radio_calender);
        radioTime = (RadioButton)findViewById(R.id.radio_time);

        tPicker.setVisibility(View.INVISIBLE);
        CalView.setVisibility(View.INVISIBLE);

        radioTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tPicker.setVisibility(View.VISIBLE);
                CalView.setVisibility(View.INVISIBLE);
            }
        });
        radioCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tPicker.setVisibility(View.INVISIBLE);
                CalView.setVisibility(View.VISIBLE);
            }
        });

        tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1){
                Toast.makeText(getApplicationContext(),
                        Integer.toString(i) + "시" +
                        Integer.toString(i1) + "분", Toast.LENGTH_SHORT).show();
            }
        });
        CalView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2){
                Toast.makeText(getApplicationContext(),
                        Integer.toString(i) + "년" +
                        Integer.toString(i1 + 1) + "월" +
                        Integer.toString(i2) + "일", Toast.LENGTH_SHORT).show();
            }
        });
        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // 현재시간을 기반으로 카운팅
                // 숫자가 갑자기 증가하는 것을 방지
                chrono1.setBase(SystemClock.elapsedRealtime());
                chrono1.start();
            }
        });
        endBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                chrono1.stop();
            }
        });
    }
}
