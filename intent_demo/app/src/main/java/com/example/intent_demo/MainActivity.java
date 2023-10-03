package com.example.intent_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ((Button)findViewById(R.id.btn_1)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                CharSequence fullname = ((EditText)findViewById(R.id.edt_fullname)).getText();
//                String age = ((EditText)findViewById(R.id.edt_age)).getText().toString();
//
//                /*intent.putExtra("fullname", fullname);
//                intent.putExtra("age", age);*/
//                Person p = new Person(fullname.toString(),Integer.valueOf(age));
//                intent.putExtra("person",p);
//
//                startActivity(intent);
//            }
//        });
        requestCallPermission(android.Manifest.permission.CALL_PHONE);
        ((Button)findViewById(R.id.btn_call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent im_intent = new Intent();
                im_intent.setAction(Intent.ACTION_CALL);
                im_intent.setData(Uri.parse("tel:0987654321"));
                startActivity(im_intent);
            }
        });
    }
    public void requestCallPermission(String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{permission}, 1001);
        }
    }
}