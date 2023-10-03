package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_id,edt_firstName,edt_lastName;

    TextView tv_show;

    MySQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_id = ((EditText)findViewById(R.id.edt_uid));
        edt_firstName = ((EditText)findViewById(R.id.edt_firstname));
        edt_lastName = ((EditText)findViewById(R.id.edt_lastname));
        tv_show = ((TextView)findViewById(R.id.tv_show));
        Button add = ((Button)findViewById(R.id.btn_add));
        Button read = ((Button)findViewById(R.id.btn_read));
        Button remove = ((Button)findViewById(R.id.btn_remove));

        add.setOnClickListener(this);
        read.setOnClickListener(this);
        remove.setOnClickListener(this);

        openHelper = new MySQLiteOpenHelper(this,MySQLiteOpenHelper.DB_NAME,null,MySQLiteOpenHelper.version);

    }
    public void Add(String id,String firstName,String lastName){
        db = openHelper.getWritableDatabase();
        String sql = "INSERT INTO users values (?,?,?)";

        db.execSQL(sql,new String[]{id,firstName,lastName});
    }
    public void Remove(String id){
        db = openHelper.getWritableDatabase();
        String sql = "DELETE FROM users where uid = ?";

        db.execSQL(sql,new String[]{id});
    }
    public void Read(){
        db = openHelper.getReadableDatabase();
        String sql = "SELECT * FROM users";
        Cursor c = db.rawQuery(sql,null);
        String textLine = "";
        while(c.moveToNext()){
            int id = c.getInt(0);
            String firstName = c.getString(1);
            String lastName = c.getString(2);
            textLine += id + ":" + firstName + " " + lastName + "\n";
        }
        tv_show.setText(textLine);
    }

    @Override
    public void onClick(View view) {
        String edt_uid = edt_id.getText().toString();
        String edt_firstname = edt_firstName.getText().toString();
        String edt_lastname = edt_lastName.getText().toString();
        if(view.getId() == R.id.btn_add){
            Add(edt_uid,edt_firstname,edt_lastname);
        }
        else if(view.getId() == R.id.btn_read){
            Read();
        }
        else if(view.getId() == R.id.btn_remove){
            Remove(edt_uid);
        }
    }
}