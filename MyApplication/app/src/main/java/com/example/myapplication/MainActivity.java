package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slot_5);
        ((Button)findViewById(R.id.btn_5)).setOnClickListener(this);
        ((TextView)findViewById(R.id.txt_forgot)).setOnClickListener(this);
        /*((Button)findViewById(R.id.btn_5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)v).setText("Đã click me");
            }
        });*/
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity Log","go to onRestart");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity Log","go to onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity Log","go to onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity Log","go to onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity Log","go to onDestroy");
    }
    /*public void onClickBtn(View view){
        ((Button)view).setText("Clicked me!");
    }*/

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_5){
            ((Button)view).setText("Login button");
        }
        else if(view.getId() == R.id.txt_forgot){
            ((TextView)view).setText("Text View Here");
        }
    }
}