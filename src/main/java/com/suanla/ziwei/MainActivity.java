package com.suanla.ziwei;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends FragmentActivity {

    private TextView dateTextView, timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnDatePicker();
        addListenerOnTimePicker();
    }

    public void addListenerOnDatePicker() {
        dateTextView = (TextView) findViewById(R.id.edit_date);
        dateTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        dateTextView.setText(selectedYear + "/" + (selectedMonth + 1) + "/" + selectedDay);
                    }
                }, year, month, day);
                datePickerDialog.setTitle("Select date");
                datePickerDialog.show(); }
        });
    }

    public void addListenerOnTimePicker() {
        timeTextView = (TextView) findViewById(R.id.edit_time);
        timeTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeTextView.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
    }

    public void submitDate(View view) {
        startActivity(DateConversionIntent.buildDateIntent(this, DisplayResult.class, dateTextView.getText().toString() + " " + timeTextView.getText().toString()));
    }
}
