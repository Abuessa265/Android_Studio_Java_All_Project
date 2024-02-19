package com.example.myradiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button showButton;
    private TextView  resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.radioGroupId);
        showButton=findViewById(R.id.showButtonId);
        resultTextView=findViewById(R.id.resultTextViewId);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=radioGroup.getCheckedRadioButtonId();
                genderButton=findViewById(selectedId);

                String value= genderButton.getText().toString();
                resultTextView.setText("You have selected : "+value);
            }
        });
    }
}