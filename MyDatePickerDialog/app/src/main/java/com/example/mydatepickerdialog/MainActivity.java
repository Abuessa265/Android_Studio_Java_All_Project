package com.example.mydatepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;
    private DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textViewId);
        button=findViewById(R.id.buttonId);

        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        DatePicker datePicker=new DatePicker(this);
        int currentDay = datePicker.getDayOfMonth();
        int currentMonth = (datePicker.getMonth()+1);
        int currentYear = datePicker.getYear();

        datePickerDialog=new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        textView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },currentYear,currentMonth,currentDay);

        datePickerDialog.show();
    }
}