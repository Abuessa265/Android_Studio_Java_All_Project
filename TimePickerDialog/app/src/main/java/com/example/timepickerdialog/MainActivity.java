package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     private Button button;
     TimePickerDialog timePickerDialog;
     private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonId);
        textView=findViewById(R.id.textViewId);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        TimePicker timePicker=new TimePicker(this);
        int currentHour=timePicker.getCurrentHour();
        int currentMinute=timePicker.getCurrentMinute();

        timePickerDialog=new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener(){

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textView.setText(hourOfDay+":"+minute);
                    }
                },currentHour,currentMinute,true);

        timePickerDialog.show();

    }
}