package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "user_db";
    public static final int version = 1;
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version); // tap db voi name, version.
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { // tao bang
        String sql = "CREATE TABLE users (uid int PRIMARY KEY not null," +
                "firstname text not null,lastname text not null)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { // thay doi cau truc bang

    }
}
