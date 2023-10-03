package com.example.intent_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Person p = (Person)getIntent().getSerializableExtra("person");
        ((TextView)findViewById(R.id.txt_name)).setText(p.getFullname());
        ((TextView)findViewById(R.id.txt_age)).setText(p.getAge());
    }
}