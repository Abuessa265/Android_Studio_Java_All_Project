package com.example.myfontdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView1,textView2;
    private Typeface typeface1,typeface2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.textView1Id);
        textView2=findViewById(R.id.textView2Id);

        typeface1=Typeface.createFromAsset(getAssets(),"font/soria_font.ttf");
        textView1.setTypeface(typeface1);

        typeface2=Typeface.createFromAsset(getAssets(),"font/SourceSemibold.otf");
        textView2.setTypeface(typeface2);
    }
}