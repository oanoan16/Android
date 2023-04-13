package com.example.chuong4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class Date_Time_Picker extends AppCompatActivity {
    EditText txtDate, txtTime;
    Button btDate, btTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        intGUI();
        btDate.setOnClickListener(view -> {
            Calendar c = Calendar.getInstance();
            int cy = c.get(Calendar.YEAR);
            int cm = c.get(Calendar.MONTH); // tính từ 0 -> 11
            int cd = c.get(Calendar.DAY_OF_MONTH); // ngày của 1 tháng
            DatePickerDialog dialog = new DatePickerDialog(Date_Time_Picker.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datetimeView, int year, int month, int dayOfMonth) {
                    txtDate.setText((dayOfMonth + "/" + (month + 1) + "/" + year));
                }
            } , cy, cm, cd); // các đối số năm, tháng, ngày
            dialog.show(); // show ra màn hình
        });

        btTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int ch = c.get(Calendar.HOUR);
            int cminute = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(Date_Time_Picker.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker datetimeView, int hourOfDay, int minute) {
                    txtTime.setText((hourOfDay + ":" + minute));
                }
            }, ch, cminute, false); // định dạng 24h = false
            dialog.show();
        });
    }

    private void intGUI() {
        txtDate = findViewById(R.id.edDate);
        txtTime = findViewById(R.id.edTime);
        btDate = findViewById(R.id.btDate);
        btTime = findViewById(R.id.btTime);
    }
}