package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class TouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        ((LinearLayout)findViewById(R.id.ln_layout)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                /*Log.d("Touch_Log","pointer count:" + motionEvent.getPointerCount());
                Log.d("Touch_Log","X0:" + motionEvent.getX(0));
                Log.d("Touch_Log","Y0:" + motionEvent.getY(0));*/
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d("Touch_Log","ACTION DOWN");
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    Log.d("Touch_Log","ACTION UP");
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    Log.d("Touch_Log","ACTION MOVE");
                }
                return true;
            }
        });
    }
}