package com.example.timeselection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWork();
    }
    public void doWork()
    {
        Button b1=(Button)findViewById(R.id.btn_analogdialog);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analog= new AnalogClock(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(analog);
            }
        });
        Button b2= (Button) findViewById(R.id.btn_Chronometer);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer cro=new  Chronometer(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(cro);
            }
        });

        Button b3 = (Button) findViewById(R.id.btn_timepicker);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        ((TextView) findViewById(R.id.txt_date)).setText(i + " - " + i1 + "@@@" +
                                timePicker.getCurrentHour() + " - " + timePicker.getCurrentMinute());

                    }
                };
                TimePickerDialog time = new TimePickerDialog(MainActivity.this, callback,
                        11, 30, true);
                time.show();
            }
        });


        Button b4 = (Button) findViewById(R.id.btn_datepickerdialog);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        ((TextView)findViewById(R.id.txt_date))
                                .setText((i2+1) + "/" + (i1+1)+ "/" + 1);
                    }
                };
                DatePickerDialog pic=new DatePickerDialog(MainActivity.this,callback,
                        2012,11,30);
                pic.setTitle("My Datetime picker");
                pic.show();

            }
        });
    }
}
