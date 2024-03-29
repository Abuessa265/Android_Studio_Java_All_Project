package com.example.myclockdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextClock textClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock=findViewById(R.id.analogClockId);
        textClock=findViewById(R.id.textClockId);

        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.analogClockId)
        {
            Toast.makeText(MainActivity.this, "Analog clock", Toast.LENGTH_SHORT).show();
        }
        if (view.getId()==R.id.textClockId)
        {
            Toast.makeText(MainActivity.this, "Text clock", Toast.LENGTH_SHORT).show();
        }

    }
}