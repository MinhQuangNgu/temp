package com.example.sharepreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt_u,edt_p;
    CheckBox cb;

    SharedPreferences shared_pref;

    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_u = ((EditText)findViewById(R.id.txt_name));
        edt_p = ((EditText)findViewById(R.id.txt_password));
        cb = ((CheckBox)findViewById(R.id.box_rem));
        shared_pref = getSharedPreferences("account",MODE_PRIVATE);
        String usn = shared_pref.getString("username","");
        String usp = shared_pref.getString("password","");
        boolean checked = shared_pref.getBoolean("is_Saved",false);
        edt_u.setText(usn);
        edt_p.setText(usp);
        cb.setChecked(checked);
    }
    public void onLogin(View view){
        String txtName = edt_u.getText().toString();
        String txtPassword = edt_p.getText().toString();
        if(cb.isChecked())
        {
            editor = shared_pref.edit();
            editor.putString("username",txtName);
            editor.putString("password",txtPassword);
            editor.putBoolean("is_Saved",true);
            editor.commit();
        }
        else{
            editor = shared_pref.edit();
            editor.remove("username");
            editor.remove("password");
            editor.putBoolean("is_Saved",false);
            editor.clear();
            editor.commit();
        }
    }
}