package com.example.mybuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    private Button loginButton,logoutButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton=findViewById(R.id.loginButtonId);
        logoutButton=findViewById(R.id.logoutButtonId);
        textView=findViewById(R.id.textViewId);


    }

    public void showMessage(View view)
    {
        if(view.getId()==R.id.loginButtonId)
        {
           Toast.makeText(MainActivity.this,"Login button is clicked",Toast.LENGTH_SHORT).show();


        }
        else {
          Toast.makeText(MainActivity.this,"Logout button is clicked",Toast.LENGTH_SHORT).show();

        }
    }



}